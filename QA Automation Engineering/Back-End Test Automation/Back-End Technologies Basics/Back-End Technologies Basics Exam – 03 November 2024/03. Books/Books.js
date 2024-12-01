describe("Book Service Tests", function() {

    describe("getBooks()", function() {
        it("should return status 200 and an array of books", function() {
            const response = bookService.getBooks();
            expect(response.status).to.equal(200);
            expect(response.data).to.be.an('array');
            expect(response.data.length).to.be.at.least(1);

           
            const firstBook = response.data[0];
            expect(firstBook).to.have.keys('id', 'title', 'author', 'year', 'genre');
        });
    });

    describe("addBook()", function() {
        it("should add a new book successfully", function() {
            const newBook = { id: "4", title: "Brave New World", author: "Aldous Huxley", year: 1932, genre: "Dystopian" };
            const response = bookService.addBook(newBook);
            expect(response.status).to.equal(201);
            expect(response.message).to.equal("Book added successfully.");
            
            
            const books = bookService.getBooks().data;
            const addedBook = books.find(book => book.id === "4");
            expect(addedBook).to.exist;
            expect(addedBook).to.deep.equal(newBook);
        });

        it("should return status 400 when adding a book with missing fields", function() {
            const invalidBook = { id: "5", title: "Incomplete Book" }; 
            const response = bookService.addBook(invalidBook);
            expect(response.status).to.equal(400);
            expect(response.error).to.equal("Invalid Book Data!");
        });
    });

    describe("deleteBook()", function() {
        it("should delete a book by id successfully", function() {
            const newBook = { id: "6", title: "Test Book", author: "Author Test", year: 2021, genre: "Test Genre" };
            bookService.addBook(newBook); 

            const response = bookService.deleteBook("6");
            expect(response.status).to.equal(200);
            expect(response.message).to.equal("Book deleted successfully.");
            
            
            const books = bookService.getBooks().data;
            const deletedBook = books.find(book => book.id === "6");
            expect(deletedBook).to.be.undefined;
        });

        it("should return status 404 when deleting a book with a non-existent id", function() {
            const response = bookService.deleteBook("non-existent-id");
            expect(response.status).to.equal(404);
            expect(response.error).to.equal("Book Not Found!");
        });
    });

    describe("updateBook()", function() {
        it("should update a book successfully", function() {
            const updatedData = { id: "1", title: "1984 (Updated)", author: "George Orwell", year: 1949, genre: "Dystopian" };
            const response = bookService.updateBook("1", updatedData);
            expect(response.status).to.equal(200);
            expect(response.message).to.equal("Book updated successfully.");

            
            const books = bookService.getBooks().data;
            const updatedBook = books.find(book => book.id === "1");
            expect(updatedBook).to.deep.equal(updatedData);
        });

        it("should return status 404 when updating a non-existent book", function() {
            const updatedData = { id: "10", title: "Non-existent Book", author: "Unknown", year: 2022, genre: "Unknown" };
            const response = bookService.updateBook("non-existent-id", updatedData);
            expect(response.status).to.equal(404);
            expect(response.error).to.equal("Book Not Found!");
        });

        it("should return status 400 when updating with incomplete book data", function() {
            const incompleteData = { title: "Incomplete Book" }; 
            const response = bookService.updateBook("1", incompleteData);
            expect(response.status).to.equal(400);
            expect(response.error).to.equal("Invalid Book Data!");
        });
    });
});
