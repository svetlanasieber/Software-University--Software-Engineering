// SPDX-License-Identifier: GPL-3.0
pragma solidity 0.8.28;

// ERC20-compliant BBP token, implementing loyalty system of BrewBean.
// Partnering cofee shops of BrewBean can reward customers with points on each purchase.
// Customers can earn loyalty points on their purchases and can redeem points.
// Each partner can customize the rules for rewarding and redeeming points.

interface ILoyaltyPoints {
    // Allows cafes to issue BBP tokens to customer
    function rewardPoints(
        uint256 shopId,
        address _customer
    ) external returns (uint256 points);

    // Allows users to spend their points
    function redeemPoints(
        uint256 shopId,
        uint256 _points
    ) external returns (uint256 points);
}

abstract contract BaseLoyaltyProgram is ILoyaltyPoints {
    ///////// Structs ///////////
    struct RewardConditions {
        uint256 minimumSpendingTarget;
        uint256 rewardPercentage;
    }

    struct CofeeShop {
        uint256 id;
        string shopName;
        address shopOwner;
        bool isAuthorized;
    }

    uint256 public shopId;
    ///////// Mappings //////////
    // Contains all shops
    mapping(uint256 shopId => CofeeShop shop) public cofeeShops;
    // Cofee shop's reward conditions
    mapping(uint256 shopId => RewardConditions) public rewardConditions;
    // Customer spendings for a specific shop
    mapping(uint256 shopId => mapping(address customer => uint256 spendings))
        public customerSpendingsForShop;
    // Customer BPP points, issued by a specific shop
    mapping(uint256 shopId => mapping(address customer => uint256 points))
        public customerPointsForShop;
    // Total customer BPP points from all shops
    mapping(address customer => uint256 points) public totalCustomerBBPoints;
    // Allowance for withdrawals for each shop
    mapping(uint256 shopId => mapping(address approver => mapping(address spender => uint256 points)))
        public allowance;

    ///////// Events ///////////
    event Rewarded(
        uint256 indexed _shopId,
        address indexed customer,
        uint256 indexed points
    );
    event Redeemed(
        uint256 indexed _shopId,
        address indexed customer,
        uint256 indexed points
    );

    ////////// Errors //////////
    error InsufficientBalance();

    function rewardPoints(
        uint256 _shopId,
        address _customer
    )
        external
        virtual
        isPartnerCofeeShop(_shopId)
        isAuthorizedForReward(_shopId, _customer)
        returns (uint256 points)
    {
        points = _getRewardPoints(_shopId, _customer);
        customerPointsForShop[_shopId][_customer] += points;

        emit Rewarded(_shopId, _customer, points);
    }

    function redeemPoints(
        uint256 _shopId,
        uint256 _points
    )
        external
        virtual
        isPartnerCofeeShop(_shopId)
        hasBalance(_shopId, msg.sender, _points)
        returns (uint256 points)
    {
        uint256 _currentPoints = customerPointsForShop[_shopId][msg.sender];

        customerPointsForShop[_shopId][msg.sender] = _currentPoints - _points;

        emit Redeemed(_shopId, msg.sender, _points);
    }

    function _getRewardPoints(
        uint256 _shopId,
        address _customer
    ) internal view returns (uint256 _points) {
        RewardConditions memory _conditions = rewardConditions[_shopId];
        uint256 _spendings = customerSpendingsForShop[_shopId][_customer];

        uint256 factor = 1e18;
        uint256 scalledPercentage = (_conditions.rewardPercentage * factor) /
            100;
        _points = (_spendings * scalledPercentage) / factor;
    }

    modifier isPartnerCofeeShop(uint256 _shopId) {
        require(cofeeShops[_shopId].isAuthorized == true, "!auth shop");
        _;
    }

    // verify if a customer is eligible for points
    modifier isAuthorizedForReward(uint256 _shopId, address _customer) {
        // Customer spendings >= minimum spending target
        require(
            customerSpendingsForShop[_shopId][_customer] >=
                rewardConditions[_shopId].minimumSpendingTarget,
            "!minimum spending target"
        );
        _;
    }

    modifier hasBalance(
        uint256 _shopId,
        address _customer,
        uint256 _points
    ) {
        if (customerPointsForShop[_shopId][_customer] < _points) {
            revert InsufficientBalance();
        }
        _;
    }
}

contract BrewBeanPoints is BaseLoyaltyProgram {
    address public owner;
    string public name = "BrewBeanPoints";
    string public symbol = "BBP";
    uint256 public decimals = 1e18;
    uint256 public totalSupply;

    constructor() {
        owner = msg.sender;
    }

    ///////// Events ///////////
    event Transfer(address indexed _from, address indexed _to, uint256 _value);
    event Approval(
        address indexed _owner,
        address indexed _spender,
        uint256 _oldValue,
        uint256 _value
    );

    ////////// Errors //////////
    error UnauthorizedSpender();

    function createCofeeShop(
        string calldata _shopName,
        uint256 _minSpendingTarget,
        uint8 _rewardPercentage
    ) public validatePercentage(_rewardPercentage) returns (uint256 newShopId) {
        shopId++;

        cofeeShops[shopId] = CofeeShop({
            id: shopId,
            shopName: _shopName,
            shopOwner: msg.sender,
            isAuthorized: false
        });

        rewardConditions[shopId] = RewardConditions({
            minimumSpendingTarget: _minSpendingTarget,
            rewardPercentage: _rewardPercentage
        });
        return shopId;
    }

    function rewardPoints(
        uint256 _shopId,
        address _customer
    )
        external
        override
        isPartnerCofeeShop(_shopId)
        isAuthorizedForReward(_shopId, _customer)
        returns (uint256 points)
    {
        points = _getRewardPoints(_shopId, _customer);
        customerPointsForShop[_shopId][_customer] += points;
        totalSupply += points;
        totalCustomerBBPoints[_customer] += points;
    }

    // Total BBP tokens for a customer
    function balanceOf(address _owner) public view returns (uint256 balance) {
        return totalCustomerBBPoints[_owner];
    }

    // Tranfers BPP tokens for a specific shop
    function transfer(
        address _to,
        uint256 _value,
        uint256 _shopId
    ) public hasBalance(_shopId, msg.sender, _value) returns (bool success) {
        customerPointsForShop[_shopId][msg.sender] -= _value;
        customerPointsForShop[_shopId][_to] += _value;

        emit Transfer(msg.sender, _to, _value);
        return true;
    }

    function transferFrom(
        address _from,
        address _to,
        uint256 _value,
        uint256 _shopId
    )
        public
        isAuthorizedSpender(_shopId, _from, msg.sender)
        hasBalance(_shopId, _from, _value)
        returns (bool success)
    {
        uint256 _currentValue = allowance[_shopId][_from][msg.sender];
        // Update allowance with new value
        allowance[_shopId][_from][msg.sender] = _value - _currentValue;

        customerPointsForShop[_shopId][_from] -= _value;
        customerPointsForShop[_shopId][_to] += _value;

        emit Transfer(msg.sender, _to, _value);
        return true;
    }

    modifier isAuthorizedSpender(
        uint256 _shopId,
        address approver,
        address potentialSpender
    ) {
        if (allowance[_shopId][approver][potentialSpender] == 0) {
            revert UnauthorizedSpender();
        }
        _;
    }

    // Allows _spender to withdraw from your account for a specific shop, up to the _value amount.
    // Approvals can be set upfront, i.e. the points check is postponed to the actual BPP transfer / transferFrom.
    // Clients SHOULD make sure to create user interfaces in such a way that they set the
    // allowance first to 0 before setting it to another value for the same spender
    function approve(
        address _spender,
        uint256 _shopId,
        uint256 _currentValue,
        uint256 _value
    ) public isValidAddress(_spender) returns (bool success) {
        if (allowance[_shopId][msg.sender][_spender] == _currentValue) {
            allowance[_shopId][msg.sender][_spender] = _value;
            emit Approval(msg.sender, _spender, _currentValue, _value);
            return true;
        } else {
            return false;
        }
    }

    modifier onlyPartner(uint256 _id) {
        require(msg.sender == cofeeShops[_id].shopOwner, "!auth");
        _;
    }

    modifier onlyOwner() {
        require(msg.sender == owner, "!owner");
        _;
    }

    modifier validatePercentage(uint8 _rewardPercentage) {
        require(
            _rewardPercentage > 0 && _rewardPercentage <= 100,
            "!_rewardPercentage"
        );
        _;
    }

    modifier validateTarget(uint256 _minSpendingTarget) {
        require(_minSpendingTarget > 0, "!_minSpendingTarget");
        _;
    }

    modifier isValidAddress(address _spender) {
        require(_spender != address(0), "!zero address");
        _;
    }
}
