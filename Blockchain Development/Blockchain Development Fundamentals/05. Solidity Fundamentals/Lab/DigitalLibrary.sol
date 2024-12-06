// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract DigitalLibrary {
  
    enum Status {
        Active,
        Outdated,
        Archived
    }

 
    struct EBook {
        string title;
        string author;
        uint256 publicationDate;
        uint256 expirationDate;
        Status status;
        address primaryLibrarian;
        uint256 readCount;
    }

   
    mapping(uint256 => EBook) public eBooks;
   
    mapping(uint256 => mapping(address => bool)) public authorizedLibrarians;

   
    uint256 public nextEBookId;

   
    event EBookCreated(uint256 indexed eBookId, string title, string author);
    event LibrarianAdded(uint256 indexed eBookId, address librarian);
    event ExpirationExtended(uint256 indexed eBookId, uint256 newExpirationDate);
    event StatusChanged(uint256 indexed eBookId, Status newStatus);

   
    function createEBook(
        string calldata title,
        string calldata author,
        uint256 publicationDate,
        uint256 expirationDays
    ) external {
        require(bytes(title).length > 0, "Title cannot be empty");
        require(bytes(author).length > 0, "Author cannot be empty");
        require(expirationDays > 0, "Expiration days must be greater than zero");

        uint256 eBookId = nextEBookId++;
        uint256 expirationDate = block.timestamp + (expirationDays * 1 days);

        eBooks[eBookId] = EBook({
            title: title,
            author: author,
            publicationDate: publicationDate,
            expirationDate: expirationDate,
            status: Status.Active,
            primaryLibrarian: msg.sender,
            readCount: 0
        });

        emit EBookCreated(eBookId, title, author);
    }

   
    function addLibrarian(uint256 eBookId, address librarian) external {
        require(msg.sender == eBooks[eBookId].primaryLibrarian, "Only primary librarian can add librarians");
        require(librarian != address(0), "Invalid librarian address");

        authorizedLibrarians[eBookId][librarian] = true;
        emit LibrarianAdded(eBookId, librarian);
    }

   
    function extendExpirationDate(uint256 eBookId, uint256 additionalDays) external {
        require(authorizedLibrarians[eBookId][msg.sender] || msg.sender == eBooks[eBookId].primaryLibrarian,
                "Not authorized to extend expiration");
        require(additionalDays > 0, "Additional days must be greater than zero");

        eBooks[eBookId].expirationDate += additionalDays * 1 days;
        emit ExpirationExtended(eBookId, eBooks[eBookId].expirationDate);
    }

   
    function changeStatus(uint256 eBookId, Status newStatus) external {
        require(msg.sender == eBooks[eBookId].primaryLibrarian, "Only primary librarian can change status");

        eBooks[eBookId].status = newStatus;
        emit StatusChanged(eBookId, newStatus);
    }

   
    function checkExpiration(uint256 eBookId) external returns (bool isOutdated) {
        eBooks[eBookId].readCount++;
        if (block.timestamp > eBooks[eBookId].expirationDate) {
            eBooks[eBookId].status = Status.Outdated;
            return true;
        }
        return false;
    }

   
    function getReadCount(uint256 eBookId) external view returns (uint256) {
        return eBooks[eBookId].readCount;
    }
}
