const express = require("express");
const {
  createDestination,
  getaDestination,
  getAllDestinations,
  updateDestination,
  deleteDestination
} = require("../controller/destinationCtrl");
const { authMiddleware } = require("../middlewares/authMiddleware");
const router = express.Router();

router.get("/", getAllDestinations);
router.get("/:id", getaDestination);
router.post("/", authMiddleware, createDestination);
router.put("/:id", authMiddleware, updateDestination);
router.delete("/:id", authMiddleware, deleteDestination);

module.exports = router;