const mongoose = require('mongoose');
const bcrypt = require('bcrypt');
const Book = require('./models/bookModel');
const Category = require('./models/bookCategoryModel');
const User = require('./models/userModel');

// Data to be seeded
const categories = [
    { "title": "Classic Literature" },
    { "title": "Dystopian" },
    { "title": "Romance" },
    { "title": "Science Fiction" },
    { "title": "Fantasy" },
    { "title": "Mystery" },
    { "title": "Thriller" },
    { "title": "Non-Fiction" },
    { "title": "Biography" },
    { "title": "Self-Help" },
    { "title": "Fiction"}
];

const users = [
    {
        "firstname": "John",
        "lastname": "Doe",
        "email": "john.doe@example.com",
        "password": "password123",  
    },
    {
        "firstname": "Jane",
        "lastname": "Smith",
        "email": "jane.smith@example.com",
        "password": "password123",  
    },
    {
        "firstname": "Alice",
        "lastname": "Johnson",
        "email": "alice.johnson@example.com",
        "password": "password123",  
    }
];


let userMap;
let categoryMap;

function getTestUsersMap(){
    return userMap;
}

function getTestCategoryMap() {
    return categoryMap;
}

// Seed data function
const seedData = async () => {
    try {
        // Clear existing data
        await Book.deleteMany({});
        await Category.deleteMany({});
        await User.deleteMany({});
        console.log('Collections cleared');

        for (let user of users) {
            user.password = await hashPassword(user.password);
        }

        const insertedUsers = await User.insertMany(users);
        console.log('Users seeded successfully');

        const insertedCategories = await Category.insertMany(categories);
        console.log('Categories seeded successfully');

        userMap = insertedUsers.reduce((map, user) => {
            map[user.email] = user._id;
            return map;
        }, {});

        categoryMap = insertedCategories.reduce((map, Category) => {
            map[Category.title] = Category._id;
            return map;
        }, {});

        const books = [
            {
                "title": "The Great Gatsby",
                "author": "F. Scott Fitzgerald",
                "description": "A novel set in the Roaring Twenties, narrating the story of Jay Gatsby and his unrequited love for Daisy Buchanan.",
                "price": 10.99,
                "category": categoryMap['Classic Literature'],
                "pages": 180,
                "tags": "classic, twenties, romance",
                "ratings": [{ "star": 5, "comment": "A timeless masterpiece.", "postedby": userMap["john.doe@example.com"] },
                { "star": 4, "comment": "Captivating story and characters.", "postedby": userMap["jane.smith@example.com"] }],
                "totalrating": "4.5"
            },
            {
                "title": "To Kill a Mockingbird",
                "author": "Harper Lee",
                "description": "A novel about racial injustice in the Deep South, seen through the eyes of young Scout Finch.",
                "price": 8.99,
                "category": categoryMap['Classic Literature'],
                "pages": 281,
                "tags": "classic, racial, justice",
                "ratings": [{ "star": 5, "comment": "Profound and moving.", "postedby": userMap["john.doe@example.com"] },
                { "star": 5, "comment": "A book everyone should read.", "postedby": userMap["alice.johnson@example.com"] }],
                "totalrating": "5.0"
            },
            {
                "title": "1984",
                "author": "George Orwell",
                "description": "A dystopian novel that explores the dangers of totalitarianism and extreme political ideology.",
                "price": 9.99,
                "category": categoryMap['Dystopian'],
                "pages": 328,
                "tags": "dystopian, political, thriller",
                "ratings": [{ "star": 5, "comment": "Chilling and thought-provoking.", "postedby": userMap["jane.smith@example.com"] },
                { "star": 4, "comment": "A must-read for everyone.", "postedby": userMap["alice.johnson@example.com"] }],
                "totalrating": "4.5"
            },
            {
                "title": "Pride and Prejudice",
                "author": "Jane Austen",
                "description": "A romantic novel that critiques the societal norms and expectations of 19th-century England.",
                "price": 7.99,
                "category": categoryMap['Romance'],
                "pages": 279,
                "tags": "romance, classic, society",
                "ratings": [{ "star": 5, "comment": "A delightful read.", "postedby": userMap["john.doe@example.com"] },
                { "star": 4, "comment": "Charming and witty.", "postedby": userMap["jane.smith@example.com"] }],
                "totalrating": "4.5"
            },
            {
                "title": "The Catcher in the Rye",
                "author": "J.D. Salinger",
                "description": "A novel about teenage alienation and angst as experienced by the protagonist, Holden Caulfield.",
                "price": 6.99,
                "category": categoryMap['Fiction'],
                "pages": 214,
                "tags": "fiction, classic, teenage",
                "ratings": [{ "star": 4, "comment": "A powerful narrative.", "postedby": userMap["alice.johnson@example.com"] },
                { "star": 3, "comment": "A bit overrated but still good.", "postedby": userMap["john.doe@example.com"] }],
                "totalrating": "3.5"
            }
        ];

        // Insert categories and books
        await Book.insertMany(books);
        console.log('Data seeded successfully');
    } catch (error) {
        console.error('Error seeding data:', error);
    }
};

const hashPassword = async (password) => {
    const salt = await bcrypt.genSalt(10);
    return await bcrypt.hash(password, salt);
};

module.exports = {
    seedData,
    getTestUsersMap,
    getTestCategoryMap
}