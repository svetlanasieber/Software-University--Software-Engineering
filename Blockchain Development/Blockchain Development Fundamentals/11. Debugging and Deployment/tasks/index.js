task("deploy", "Deploy contract", async (taskArgs, hre) => {
  if (!taskArgs.unlockTime) {
    throw new Error("unlockTime is required");
  }

  const ContractFactory = await hre.ethers.getContractFactory("Lock");
  const contract = await ContractFactory.deploy(taskArgs.unlockTime);
  console.log("Contract deployed to:", contract.target);

  await contract.waitForDeployment();

  const unlockTimeSet = await contract.unlockTime();
  if (unlockTimeSet.toString() !== taskArgs.unlockTime) {
    throw new Error("unlockTime was not set correctly");
  }
}).addParam(
  "unlockTime",
  "The unix timestamp after which the contract will be unlocked."
);

task("test", "Deploy contract", async (taskArgs, hre) => {
  const ContractFactory = await hre.ethers.getContractFactory("Lock");
  const contract = await ContractFactory.attach(
    "0x595f1BA9bac5C1977affF7f2C13E3F0BE07Db938"
  );

  const unlockTimeSet = await contract.unlockTime();
  console.log("unlockTimeSet", unlockTimeSet.toString());
});
