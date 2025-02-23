const Book = require("../models/bookModel");
const asyncHandler = require("express-async-handler");
const slugify = require("slugify");
const validateMongoDbId = require("../utils/validateMongodbId");

const createBook = asyncHandler(async (req, res) => {
  try {
    if (req.body.title) {
      req.body.slug = slugify(req.body.title);
    }
    let newBook = await Book.create(req.body);
    newBook = await newBook.populate('category');
    res.json(newBook);
  } catch (error) {
    throw new Error(error);
  }
});

const updateBook = asyncHandler(async (req, res) => {
  const { id } = req.params;
  validateMongoDbId(id);
  try {
    if (req.body.title) {
      req.body.slug = slugify(req.body.title);
    }

    let updateBook = await Book.findByIdAndUpdate(id, req.body, {
      new: true,
      runValidators: true
    });
    updateBook = await updateBook.populate('category');
    res.json(updateBook);
  } catch (error) {
    throw new Error(error);
  }
});

const deleteBook = asyncHandler(async (req, res) => {
  const {id} = req.params;
  validateMongoDbId(id);
  try {
    let deleteBook = await Book.findByIdAndDelete(id);
    deleteBook = await deleteBook.populate('category');
    res.json(deleteBook);
  } catch (error) {
    throw new Error(error);
  }
});

const getaBook = asyncHandler(async (req, res) => {
  const { id } = req.params;
  validateMongoDbId(id);
  try {
    const findBook = await Book.findById(id).populate('category');
    res.json(findBook);
  } catch (error) {
    throw new Error(error);
  }
});

const getAllBooks = asyncHandler(async (req, res) => {
  try {
    const queryObj = { ...req.query };
    const excludeFields = ["page", "sort", "limit", "fields"];
    excludeFields.forEach((el) => delete queryObj[el]);
    let queryStr = JSON.stringify(queryObj);
    queryStr = queryStr.replace(/\b(gte|gt|lte|lt)\b/g, (match) => `$${match}`);

    let query = Book.find(JSON.parse(queryStr)).populate('category');

    if (req.query.sort) {
      const sortBy = req.query.sort.split(",").join(" ");
      query = query.sort(sortBy);
    } else {
      query = query.sort("-createdAt");
    }

    if (req.query.fields) {
      const fields = req.query.fields.split(",").join(" ");
      query = query.select(fields);
    } else {
      query = query.select("-__v");
    }

    const page = req.query.page;
    const limit = req.query.limit;
    const skip = (page - 1) * limit;
    query = query.skip(skip).limit(limit);
    if (req.query.page) {
      const booksCount = await Book.countDocuments();
      if (skip >= booksCount) throw new Error("This Page does not exists");
    }
    const book = await query;
    res.json(book);
  } catch (error) {
    throw new Error(error);
  }
});

module.exports = {
  createBook,
  getaBook,
  getAllBooks,
  updateBook,
  deleteBook
};
