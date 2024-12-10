const mongoose = require('mongoose');
const bcrypt = require('bcrypt');
const Destination = require('./models/destinationModel');
const Category = require('./models/categoryModel');
const User = require('./models/userModel');

// Data to be seeded
const categories = [
    { name: 'Beaches' },
    { name: 'Mountains' },
    { name: 'Cities' },
    { name: 'Historical Sites' },
    { name: 'National Parks' },
    { name: 'Adventure' },
    { name: 'Cultural' },
    { name: 'Resorts' },
    { name: 'Islands' },
    { name: 'Deserts' }
];

const users = [
    {
        firstname: "John",
        lastname: "Doe",
        email: "john.doe@example.com",
        password: "password123",
    },
    {
        firstname: "Jane",
        lastname: "Smith",
        email: "jane.smith@example.com",
        password: "password123",
    },
    {
        firstname: "Alice",
        lastname: "Johnson",
        email: "alice.johnson@example.com",
        password: "password123",
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

const seedData = async () => {
    try {
        await Destination.deleteMany({});
        await Category.deleteMany({});
        await User.deleteMany({});
        console.log('Collections cleared');

        const insertedCategories = await Category.insertMany(categories);
        console.log('Categories seeded successfully');

        categoryMap = insertedCategories.reduce((map, Category) => {
            map[Category.name] = Category._id;
            return map;
        }, {});

        const destinations = [
            {
                name: 'Maui Beach',
                location: 'Hawaii, USA',
                description: 'A beautiful beach with crystal clear waters and white sands.',
                attractions: ['Surfing', 'Sunbathing', 'Snorkeling'],
                bestTimeToVisit: 'April to October',
                category: categoryMap['Beaches'],
                ratings: [],
                imageUrls: ['url_to_image1', 'url_to_image2'],
            },
            {
                name: 'Rocky Mountains',
                location: 'Colorado, USA',
                description: 'A vast mountain range with stunning scenery and hiking trails.',
                attractions: ['Hiking', 'Wildlife Viewing', 'Camping'],
                bestTimeToVisit: 'June to September',
                category: categoryMap['Mountains'],
                ratings: [],
                imageUrls: ['url_to_image1', 'url_to_image2'],
            },
            {
                name: 'New York City',
                location: 'New York, USA',
                description: 'The largest city in the USA, known for its skyscrapers, culture, and entertainment.',
                attractions: ['Times Square', 'Central Park', 'Broadway'],
                bestTimeToVisit: 'April to June, September to November',
                category: categoryMap['Cities'],
                ratings: [],
                imageUrls: ['url_to_image1', 'url_to_image2'],
            },
            {
                name: 'Machu Picchu',
                location: 'Cusco Region, Peru',
                description: 'A 15th-century Inca citadel located in the Eastern Cordillera of southern Peru.',
                attractions: ['Inca Trail', 'Temple of the Sun', 'Intihuatana Stone'],
                bestTimeToVisit: 'April to October',
                category: categoryMap['Historical Sites'],
                ratings: [],
                imageUrls: ['url_to_image1', 'url_to_image2'],
            },
            {
                name: 'Yellowstone National Park',
                location: 'Wyoming, USA',
                description: 'The first national park in the world, known for its geothermal features and wildlife.',
                attractions: ['Old Faithful', 'Grand Prismatic Spring', 'Wildlife Viewing'],
                bestTimeToVisit: 'April to May, September to October',
                category: categoryMap['National Parks'],
                ratings: [],
                imageUrls: ['url_to_image1', 'url_to_image2'],
            },
        ];

        for (let user of users) {
            user.password = await hashPassword(user.password);
        }

        const insertedUsers = await User.insertMany(users);
        console.log('Users seeded successfully');

        userMap = insertedUsers.reduce((map, user) => {
            map[user.email] = user._id;
            return map;
        }, {});

        destinations[0].ratings = [
            { star: 5, comment: 'Amazing place!', postedby: userMap['john.doe@example.com'] }
        ];
        destinations[1].ratings = [
            { star: 5, comment: 'Great for adventure lovers!', postedby: userMap['john.doe@example.com'] }
        ];
        destinations[2].ratings = [
            { star: 5, comment: 'Amazing.', postedby: userMap['jane.smith@example.com'] },
            { star: 4, comment: 'A city that never sleeps!', postedby: userMap['alice.johnson@example.com'] }
        ];
        destinations[3].ratings = [
            { star: 5, comment: 'Very moving!', postedby: userMap['john.doe@example.com'] },
            { star: 4, comment: 'Charming and witty.', postedby: userMap['jane.smith@example.com'] }
        ];
        destinations[4].ratings = [
            { star: 4, comment: 'Nature at its best!', postedby: userMap['alice.johnson@example.com'] },
            { star: 3, comment: 'A historical wonder!', postedby: userMap['john.doe@example.com'] }
        ];

        // Insert Destinations
        await Destination.insertMany(destinations);
        console.log('Destinations seeded successfully');
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