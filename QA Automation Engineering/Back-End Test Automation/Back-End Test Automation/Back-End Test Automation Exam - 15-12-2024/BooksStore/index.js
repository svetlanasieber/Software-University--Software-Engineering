const bodyParser = require("body-parser");
const express = require("express");
const dbConnect = require("./config/dbConnect");
const { notFound, errorHandler } = require("./middlewares/errorHandler");
const authRouter = require("./routes/authRoute");
const bookRouter = require("./routes/bookRoute");
const categoryRouter = require("./routes/bookCategoryRoute");
const cookieParser = require("cookie-parser");
const morgan = require("morgan");
const cors = require("cors");
const swaggerUi = require('swagger-ui-express');
const YAML = require('yamljs');
const { seedData, getTestUsersMap, getTestCategoryMap } = require('./seed');

process.env.NODE_NO_WARNINGS = 1;
process.env.JWT_SECRET = 'mysecret';

const PORT = 5000;

(async () => {
  try {
    //create in-memory db and conneciton
    await dbConnect();
    //seed initial data
    await seedData();

    let usersMap = getTestUsersMap();
    let categoryMap = getTestCategoryMap();
    const swaggerDocument = YAML.load('./swagger.yaml');

    // bootstrap example to use actual Id
    let exampleUserId = usersMap['john.doe@example.com'].toString();
    let exampleCategoryId = categoryMap['Classic Literature'].toString();

    swaggerDocument.components.schemas['Book(Create,Update)'].example.category = exampleCategoryId;
    swaggerDocument.components.schemas['Book(Create,Update)'].example.ratings[0].postedby = exampleUserId;
    const app = express();
    app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerDocument));

    app.use(morgan("dev"));
    app.use(cors());
    app.use(bodyParser.json());
    app.use(bodyParser.urlencoded({ extended: false }));
    app.use(cookieParser());

    app.use("/api/user", authRouter);
    app.use("/api/book", bookRouter);
    app.use("/api/category", categoryRouter);

    app.use(notFound);
    app.use(errorHandler);
    app.listen(PORT, () => {
      console.log(`Server is running  at PORT ${PORT}`);
    });
  } catch(e) {
      console.log(`Error during startup: ${e.stack}`)
  }
})();


