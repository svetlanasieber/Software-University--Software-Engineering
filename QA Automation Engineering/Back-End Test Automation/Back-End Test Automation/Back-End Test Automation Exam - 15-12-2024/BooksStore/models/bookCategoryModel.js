const mongoose = require("mongoose"); 

var bookCategorySchema = new mongoose.Schema(
  {
    title: {
      type: String,
      required: true,
      unique: true,
      index: true,
    },
  },
  {
    toObject: {
      transform: function (doc, ret) {
        delete ret.__v;
      }
    },
    toJSON: {
      transform: function (doc, ret) {
        delete ret.__v;
      }
    },
    timestamps: true
  }
);

module.exports = mongoose.model("BookCategory", bookCategorySchema);
