const express = require("express");
const {
  createBook,
  getaBook,
  getAllBooks,
  updateBook,
  deleteBook
} = require("../controller/bookCtrl");
const { authMiddleware } = require("../middlewares/authMiddleware");
const router = express.Router();

router.get("/", getAllBooks);
router.get("/:id", getaBook);
router.post("/", authMiddleware, createBook);
router.put("/:id", authMiddleware, updateBook);
router.delete("/:id", authMiddleware, deleteBook);

module.exports = router;