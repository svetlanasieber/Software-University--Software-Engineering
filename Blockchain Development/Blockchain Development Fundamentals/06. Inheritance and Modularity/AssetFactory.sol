// SPDX-License-Identifier: GPL-3.0
pragma solidity 0.8.28;

contract Asset {
    constructor(
        string memory symbol,
        string memory name,
        uint256 initialSupply,
        address owner
    ) {
        symbol = symbol;
        name = name;
        initialSupply = initialSupply;
        owner = owner;
        balances[owner] = initialSupply;
    }

    mapping(address => uint256) public balances;

    event Transfer(address indexed from, address indexed to, uint256 value);

    function transfer(
        address to,
        uint256 amount
    ) external nonZeroAmount(amount) sufficientBalance(amount) returns (bool) {
        balances[msg.sender] -= amount;
        balances[to] += amount;
        emit Transfer(msg.sender, to, amount);
        return true;
    }

    modifier sufficientBalance(uint256 _amount) {
        require(balances[msg.sender] >= _amount, "Insufficient balance");
        _;
    }

    modifier nonZeroAmount(uint256 _amount) {
        require(_amount != 0, "Invalid zero amount");
        _;
    }
}

contract AssetFactory {
    uint8 public SYMBOL_MAX_CHARS = 5;
    uint8 public NAME_MAX_CHARS = 40;

    mapping(string => Asset) public assets;

    error CallFailed();

    function createAsset(
        string memory symbol,
        string memory name,
        uint256 initialSupply
    )
        public
        maxSymbol(symbol, SYMBOL_MAX_CHARS)
        maxSymbol(name, NAME_MAX_CHARS)
    {
        Asset asset = new Asset({
            symbol: symbol,
            name: name,
            initialSupply: initialSupply,
            owner: msg.sender
        });

        assets[symbol] = asset;
    }

    function transferUnits(
        string memory assetSymbol,
        address to,
        uint256 amount
    ) public assetExists(assetSymbol) {
        Asset _asset = assets[assetSymbol];
        bool ok = _asset.transfer(to, amount);
        if (!ok) revert CallFailed();
    }

    function checkBalances(
        string memory assetSymbol,
        address user
    ) public view assetExists(assetSymbol) returns (uint256 balance) {
        Asset asset = assets[assetSymbol];
        balance = asset.balances(user);
    }

    modifier assetExists(string memory _assetSymbol) {
        require(
            address(assets[_assetSymbol]) != address(0),
            "Nonexistent asset"
        );
        _;
    }

    modifier maxSymbol(string memory symbol, uint256 limitNumber) {
        require(bytes(symbol).length <= limitNumber, "Symbol too long");
        _;
    }

    modifier validSupply(uint256 initialSuppy) {
        require(initialSuppy != 0, "Invalid zero supply");
        _;
    }
}
