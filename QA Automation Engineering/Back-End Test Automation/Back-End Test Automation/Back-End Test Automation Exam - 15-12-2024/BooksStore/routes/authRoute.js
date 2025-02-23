const express = require("express");
const {
  createUser,
  loginUserCtrl,
  logout
} = require("../controller/userCtrl");
const router = express.Router();

router.post("/register", createUser);
router.post("/login", loginUserCtrl);
router.get("/logout", logout);

module.exports = router;