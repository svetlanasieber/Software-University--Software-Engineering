require("@nomicfoundation/hardhat-toolbox");
require("./tasks/index.js");
require("@nomicfoundation/hardhat-verify");

require("dotenv").config();

/** @type import('hardhat/config').HardhatUserConfig */
module.exports = {
  solidity: {
    version: "0.8.28",
  },
  networks: {
    sepolia: {
      url: process.env.WEB3_PROVIDER_URL,
      // accounts: [process.env.PRIVATE_KEY],
    },
  },
  etherscan: {
    apiKey: process.env.ETHERSCAN_API_KEY,
  },
  sourcify: {
    enabled: true,
  },
};
