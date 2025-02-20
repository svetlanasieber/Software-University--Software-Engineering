// SPDX-License-Identifier: MIT
pragma solidity 0.8.27;

import {Event} from "./Event.sol";

error InvalidInput(string info);
error AlreadyListed();
error MustBeOrganizer();
error WrongBuyingOption();
error ProfitDistributionFailed();

enum BuyingOption {
    FixedPrice,
    Bidding
}

struct EventData {
    uint256 ticketPrice;
    BuyingOption saleType;
    uint256 salesEnds; // timestamp
}

contract Marketplace {
    uint256 public constant MIN_SALE_PERIOD = 24 hours;
    uint256 public constant SALE_FEE = 0.1 ether;

    address public immutable feeCollector;

    mapping(address => EventData) public events;
    mapping(address => uint256) public profits;
    mapping(address => mapping(uint256 => bool)) public secondMarketListings;

    event NewEvent(address indexed newEvent);

    constructor(address feeCollector_) {
        feeCollector = feeCollector_;
    }

    function createEvent(
        string memory eventName,
        uint256 date,
        string memory location,
        uint256 ticketPrice,
        BuyingOption saleType,
        uint256 salesEnds,
        uint256 ticketAvailability_,
        bool isPriceCapSet_,
        address whitelistedAddress_
    ) external {
        address newEvent = address(
            new Event(
                address(this),
                eventName,
                date,
                location,
                msg.sender,
                ticketAvailability_,
                isPriceCapSet_,
                whitelistedAddress_
            )
        );

        emit NewEvent(newEvent);

        _listEvent(newEvent, ticketPrice, saleType, salesEnds);
    }

    function listEvent(
        address newEvent,
        uint256 ticketPrice,
        BuyingOption saleType,
        uint256 salesEnds
    ) external {
        if (msg.sender != Event(newEvent).organizer()) {
            revert MustBeOrganizer();
        }

        _listEvent(newEvent, ticketPrice, saleType, salesEnds);
    }

    function _listEvent(
        address newEvent,
        uint256 ticketPrice,
        BuyingOption saleType,
        uint256 salesEnds
    ) internal {
        // TODO: Ensure External Event contract is compatible with IEvent
        if (salesEnds < block.timestamp + MIN_SALE_PERIOD) {
            revert InvalidInput("salesEnds is invalid");
        }

        if (ticketPrice < SALE_FEE) {
            revert InvalidInput("ticketPrice >= SALE_FEE");
        }

        if (events[newEvent].salesEnds != 0) {
            revert AlreadyListed();
        }

        events[newEvent] = EventData({
            ticketPrice: ticketPrice,
            saleType: saleType,
            salesEnds: salesEnds
        });
    }

    function buyOnSecondMarket(
        address event_,
        uint256 ticketId,
        address owner
    ) external payable {
        if (events[event_].saleType != BuyingOption.FixedPrice) {
            revert WrongBuyingOption();
        }

        if (msg.value != events[event_].ticketPrice) {
            revert InvalidInput("wrong value");
        }

        profits[Event(event_).organizer()] += msg.value - SALE_FEE;
        profits[feeCollector] += SALE_FEE;

        Event(event_).safeTransferFrom(owner, msg.sender, ticketId);
    }

    // TODO: CHECK FOR REENTRANCY ATTACK POSIBILITIES
    function buyTicket(address event_) external payable {
        if (events[event_].saleType != BuyingOption.FixedPrice) {
            revert WrongBuyingOption();
        }

        if (msg.value != events[event_].ticketPrice) {
            revert InvalidInput("wrong value");
        }

        profits[Event(event_).organizer()] += msg.value - SALE_FEE;
        profits[feeCollector] += SALE_FEE;

        Event(event_).safeMint(msg.sender);
    }

    function withdrawProfit(address to) external payable {
        uint256 profit = profits[msg.sender];
        profits[msg.sender] = 0;
        (bool success, ) = to.call{value: profit}("");
        if (!success) {
            revert ProfitDistributionFailed();
        }
    }
}
