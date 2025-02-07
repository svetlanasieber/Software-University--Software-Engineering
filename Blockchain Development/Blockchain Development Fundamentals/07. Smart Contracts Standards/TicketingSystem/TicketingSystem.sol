// SPDX-License-Identifier: GPL-3.0

/**
 * @title EventTicketNFT
 * @notice ERC721-based Ticketing System
 * @dev Users can buy tickets for open events, where
 * only the owner of the contract can mint the purchased tickets.
 * Purchase/minting comes one ticket at a time.
 * The system allows one buyer to buy more than 1 ticket for 1 event.
 */
pragma solidity 0.8.28;

import "@openzeppelin/contracts/token/ERC721/ERC721.sol";
import "@openzeppelin/contracts/access/Ownable.sol";

contract EventTicketNFT is ERC721, Ownable {
    using Strings for uint256;

    constructor() ERC721("EventTicketNFT", "ETN") Ownable(msg.sender) {}

    // --- Structs --- //
    struct Event {
        bool isTicketSaleActive;
        string[20] nameEvent;
        uint256 ticketPrice;
        uint256 availableTickets;
    }

    // --- Storage variables --- //
    uint256 internal _nextEventId;

    // --- Mappings --- //
    mapping(uint256 eventId => Event _event) public events;
    mapping(uint256 eventId => mapping(uint256 tokenId => address buyer))
        public purchases;
    mapping(uint256 eventId => mapping(uint256 tokenId => address newBuyer))
        public resaleRequests;

    // --- Events --- //
    event NewEvent(
        uint256 indexed eventId,
        string[20] indexed name,
        uint256 indexed ticketPrice
    );
    event Purchase(
        uint256 indexed eventId,
        address indexed buyer,
        uint256 indexed tokenId
    );

    event RequestResale(
        uint256 indexed eventId,
        uint256 indexed tokenId,
        address indexed owner,
        address newOwner
    );

    // --- Errors --- //
    error ETNNoPurchase();
    error ETNInvalidEventId();
    error ETNNoTicketOwner();
    error ETNInvalidNumberInput();
    error ETNInactiveTicketSale();
    error ETNNoTicketsAvailable();
    error ETNNotEnoughETHforTicket();

    // Forward Ether to owner
    receive() external payable {
        require(msg.value > 0, "No Ether sent");
        payable(owner()).transfer(msg.value);
    }

    /**
     * @dev Contract owner can create a new event
     */
    function createEvent(
        bool _isTicketSaleActive,
        string[20] calldata _name,
        uint256 _ticketPrice,
        uint256 _availableTickets
    )
        external
        onlyOwner
        isNotZero(_ticketPrice)
        isNotZero(_availableTickets)
        returns (uint256 _eventId)
    {
        _eventId = _nextEventId;
        events[_nextEventId] = Event({
            isTicketSaleActive: _isTicketSaleActive,
            nameEvent: _name,
            ticketPrice: _ticketPrice,
            availableTickets: _availableTickets
        });
        _nextEventId++;
        emit NewEvent(_eventId, _name, _ticketPrice);
    }

    function updateActiveTicketSale(
        uint256 _eventId,
        bool _newStatus
    ) external onlyOwner eventExist(_eventId) returns (bool) {
        events[_eventId].isTicketSaleActive = _newStatus;
        return true;
    }

    /**
     * @dev Purchase one ticket at a time for specific event.
     * Buyers can buy more than 1 ticket for an event.
     */
    function purchaseTicket(
        uint256 _eventId,
        uint256 _tokenId
    )
        public
        payable
        eventExist(_eventId)
        checkPrice(_eventId, msg.value)
        hasTicketsAvailable(_eventId)
        returns (uint256, uint256)
    {
        events[_eventId].availableTickets--;
        purchases[_eventId][_tokenId] = msg.sender;
        emit Purchase(_eventId, msg.sender, _tokenId);
        return (_eventId, _tokenId);
    }

    /**
     * @dev Contract Owner mints tickets bought.
     */
    function mint(
        uint256 _eventId,
        uint256 _tokenId,
        address _ticketOwner
    )
        public
        onlyOwner
        hasPurchase(_eventId, _tokenId, _ticketOwner)
        returns (bool)
    {
        string memory _tokenURI = tokenURI(_tokenId);

        _safeMint(_ticketOwner, _tokenId, bytes(_tokenURI));

        return true;
    }

    function requestResale(
        uint256 _eventId,
        uint256 _tokenId,
        address newOwner
    )
        public
        eventExist(_eventId)
        isTicketHolder(_tokenId)
        nonZeroAddress(newOwner)
    {
        resaleRequests[_eventId][_tokenId] = newOwner;

        emit RequestResale(_eventId, _tokenId, msg.sender, newOwner);
    }

    function transferTicket(
        uint256 _eventId,
        uint256 _tokenId,
        address _owner,
        address _newOwner
    )
        public
        onlyOwner
        eventExist(_eventId)
        isTicketHolder(_tokenId)
        nonZeroAddress(_newOwner)
    {
        safeTransferFrom(_owner, _newOwner, _tokenId);
        emit Purchase(_eventId, msg.sender, _tokenId);
    }

    function tokenURI(
        uint256 tokenId
    ) public view override returns (string memory) {
        _requireOwned(tokenId);

        return
            bytes(_baseURI()).length > 0
                ? string.concat(_baseURI(), tokenId.toString(), ".json")
                : _baseURI();
    }

    function _baseURI() internal pure override returns (string memory) {
        return "./Metadata/";
    }

    // --- Modifiers --- //
    modifier nonZeroAddress(address _owner) {
        if (_owner == address(0)) {
            revert ERC721InvalidOperator(_owner);
        }
        _;
    }

    modifier isTicketHolder(uint256 _tokenId) {
        if (ownerOf(_tokenId) != msg.sender) {
            revert ETNNoTicketOwner();
        }
        _;
    }

    modifier eventExist(uint256 _eventId) {
        require(events[_eventId].nameEvent.length > 0, "Event does not exist");
        _;
    }

    modifier checkPrice(uint256 _eventId, uint256 _price) {
        if (events[_eventId].ticketPrice < _price) {
            revert ETNNotEnoughETHforTicket();
        }
        _;
    }

    modifier isNotZero(uint256 _number) {
        if (_number == 0) {
            revert ETNInvalidNumberInput();
        }
        _;
    }

    modifier isTicketSaleActive(uint256 _eventId) {
        if (events[_eventId].isTicketSaleActive == false) {
            revert ETNInactiveTicketSale();
        }
        _;
    }

    modifier hasTicketsAvailable(uint256 _eventId) {
        if (events[_eventId].availableTickets == 0) {
            revert ETNNoTicketsAvailable();
        }
        _;
    }

    modifier hasPurchase(
        uint256 _eventId,
        uint256 _tokenId,
        address _owner
    ) {
        if (purchases[_eventId][_tokenId] != _owner) {
            revert ETNNoPurchase();
        }
        _;
    }
}
