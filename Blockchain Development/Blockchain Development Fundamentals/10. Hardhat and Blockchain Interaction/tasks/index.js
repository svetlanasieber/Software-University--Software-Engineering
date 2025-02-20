// const ethers = require("ethers");

// hardhat runtime environment
task("accounts", "Prints the list of accounts", async (taskArgs, hre) => {
  const accounts = await hre.ethers.getSigners();
  for (const account of accounts) {
    console.log(account.address);
  }
});

task("balance", "Prints an account's balance")
  .addParam("address", "The address to check")
  .setAction(async (taskArgs, hre) => {
    // const provider = new ethers.JsonRpcProvider("http://127.0.0.1:8545");
    const provider = hre.ethers.provider;
    const res = await provider.getBalance(taskArgs.address);

    console.log(res);
    console.log("result in ETH: ", ethers.formatEther(res));
  });

task("send", "Send ETH to given address")
  .addParam("address", "the addres to send to")
  .addParam("amount", "the amount to send")
  .setAction(async (taskParams, hre) => {
    const [signer] = await hre.ethers.getSigners();
    const tx = await signer.sendTransaction({
      to: taskParams.address,
      value: ethers.parseEther(taskParams.amount),
    });

    console.log("Tx send!");
    console.log(tx);

    const receipt = await tx.wait();
    console.log("Tx mined!");
    console.log(receipt);
  });

task("contract", "Send ETH to given address").setAction(
  async (taskParams, hre) => {
    const ContractFactory = await hre.ethers.getContractFactory("Lock");
    const contract = await ContractFactory.deploy(1737969422);
    console.log("Contract deployed to:", await contract.getAddress());

    const tx = await contract
      .withdraw()
      .catch((err) => console.log(err.message));

    console.log("Tx send!");
  }
);
