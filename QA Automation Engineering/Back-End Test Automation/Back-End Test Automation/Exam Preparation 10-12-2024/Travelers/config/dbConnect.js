const { default: mongoose } = require("mongoose");
const { MongoMemoryServer } = require("mongodb-memory-server")


const dbConnect = async () => {
  try {
    let mongoServer = await MongoMemoryServer.create();
    const uri = mongoServer.getUri()

    await mongoose.connect(uri, {
      useNewUrlParser: "true",
      useUnifiedTopology: "true"
    });
    console.log("Database Connected Successfully");
  } catch (error) {
    console.log("Failed to create/connect to Database");
    throw error;
  }
};

module.exports = dbConnect;
