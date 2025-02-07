// SPDX-License-Identifier: MIT
pragma solidity 0.8.28;

contract DigitalLibrary {

    enum EBookStatus { Active, Outdated, Archived }

    struct EBook {
        uint256 id;
        string title;
        string author;
        uint256 publicationDate;
        uint256 expirationDate;
        EBookStatus status;
        address primaryLibrarian;
        uint256 readCount;
    }

    EBook[] private books;
    
    mapping(uint256 => mapping(address => bool)) authorizedLibrariansByBook;

    error InvalidExpirationDate();

    event BookStatusChanged(EBookStatus oldStatus, EBookStatus newStatus);
    event EBookAccessed(uint256 bookId, string title, string author, uint256 readCount);

    // Creates book and returns book id
    function createBook (
        string calldata title,
        string calldata author,
        uint256 publicationDate,
        uint256 expirationDate
        ) external returns (uint256 bookId) {
        require(publicationDate > 0, "Not a valid publicationDate ");
        require(bytes(title).length != 0 || bytes(author).length != 0, "Empty title or author");
        require(bytes(title).length <= 100, "Title too long");
        require(bytes(author).length <= 100, "Author too long");

        bookId = books.length + 1;
        EBook memory newBook = EBook({
            id: bookId,
            title: title,
            author: author,
            publicationDate: publicationDate,
            expirationDate: expirationDate,
            status: EBookStatus.Active,
            primaryLibrarian: msg.sender,
            readCount: 0
        });
        
        books.push(newBook);
    }
    
    // Only the primary librarian can add additional authorized librarians for an e-book.
    // Returns true if successfully added
    function addLibrarian(uint256 bookId, address librarian) external returns (bool) {
        require(bookId != 0, "Invalid zero bookId");
        uint256 index = convertBookIdToIndex(bookId);
        require(msg.sender == books[index].primaryLibrarian, "Unauthorized primary librarian");

        return authorizedLibrariansByBook[index][librarian] = true;
    }

    // Only authorized librarians can extend the expiration date.
    // Returns the extended  if successful txn
    function extendExpDate(uint256 bookId, uint256 daysExtension) external returns (uint256) {
        require(bookId != 0, "Invalid zero bookId");
        require(isAuthorizedToExtend(bookId, msg.sender), "Unauthorized librarian");
        require(daysExtension != 0, "Expiration date cannot be zero");

        uint256 index = convertBookIdToIndex(bookId);
        uint256 bookExpirationDate = books[index].expirationDate;
        return books[index].expirationDate = bookExpirationDate + (daysExtension * 1 days);
    }

    // Only primary librarian can change book status
    function changeStatus(uint256 bookId, EBookStatus newStatus) external {
        require(bookId != 0, "Invalid zero bookId");
        uint256 index = convertBookIdToIndex(bookId);
        require(msg.sender == books[index].primaryLibrarian, "Not a primary librarian");

        EBookStatus oldStatus = books[index].status;
        books[index].status = newStatus;

        emit BookStatusChanged(oldStatus, newStatus);
    }

    // Checks if e-book is outdated (real-time) and increases read count
    function checkExpiration(uint256 bookId) external returns (bool bookOutdated) {
        require(bookId != 0, "Invalid zero bookId");
        uint256 index = convertBookIdToIndex(bookId);
        books[index].readCount += 1;
        bookOutdated = isOutdated(bookId);
    }

    // Returns EBook and increaes read count
    function getEBook(uint256 bookId) external {
        require(bookId != 0, "Invalid zero bookId");
        
        uint256 index = convertBookIdToIndex(bookId);
        books[index].readCount += 1;
        
        emit EBookAccessed(
            bookId,
            books[index].title,
            books[index].author,
            books[index].readCount
            );
    }

        function convertBookIdToIndex(uint256 bookId) internal pure returns (uint256) {
        return bookId - 1;
    }

    function isAuthorizedToExtend(uint256 bookId, address librarian) internal view returns (bool) {
        require(bookId != 0, "Invalid zero bookId");

        uint256 index = convertBookIdToIndex(bookId);
        return books[index].primaryLibrarian == msg.sender || authorizedLibrariansByBook[index][librarian];
    }

    function isOutdated(uint256 bookId) internal view returns (bool) {
        require(bookId != 0, "Invalid zero bookId");

        uint256 index = convertBookIdToIndex(bookId);
        return books[index].expirationDate <= block.timestamp;
    }
}
