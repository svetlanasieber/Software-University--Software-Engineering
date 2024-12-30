describe("gameService Tests", function() {

  describe("getGames()", function() {
    it("should return a successful response with a list of games", function() {
      const result = gameService.getGames();
      expect(result.status).to.equal(200);
      expect(result.data).to.be.an('array').with.lengthOf(3);

      const game = result.data[0];
      expect(game).to.include.keys('id', 'title', 'genre', 'year', 'developer', 'description');
    });
  });

  describe("addGame()", function() {
    it("should add a new game successfully", function() {
      const newGame = {
        id: "4",
        title: "Cyberpunk 2077",
        genre: "RPG",
        year: 2020,
        developer: "CD Projekt Red",
        description: "An open-world RPG set in a dystopian future."
      };
      
      const addResult = gameService.addGame(newGame);
      expect(addResult.status).to.equal(201);
      expect(addResult.message).to.equal("Game added successfully.");

      const games = gameService.getGames().data;
      const addedGame = games.find(game => game.id === newGame.id);
      expect(addedGame).to.deep.equal(newGame);
    });

    it("should return an error for invalid game data", function() {
      const invalidGame = {
        id: "5",
        title: "Invalid Game"
       
      };
      
      const result = gameService.addGame(invalidGame);
      expect(result.status).to.equal(400);
      expect(result.error).to.equal("Invalid Game Data!");
    });
  });

  describe("deleteGame()", function() {
    it("should delete an existing game by ID", function() {
      const gameId = "1";
      const deleteResult = gameService.deleteGame(gameId);
      expect(deleteResult.status).to.equal(200);
      expect(deleteResult.message).to.equal("Game deleted successfully.");

      const games = gameService.getGames().data;
      const deletedGame = games.find(game => game.id === gameId);
      expect(deletedGame).to.be.undefined;
    });

    it("should return an error if the game is not found", function() {
      const invalidId = "999"; // Non-existent ID
      const result = gameService.deleteGame(invalidId);
      expect(result.status).to.equal(404);
      expect(result.error).to.equal("Game Not Found!");
    });
  });

  describe("updateGame()", function() {
    it("should update an existing game with new data", function() {
      const oldId = "2"; 
      const updatedGame = {
        id: "2",
        title: "God of War (Updated)",
        genre: "Action-adventure",
        year: 2018,
        developer: "Santa Monica Studio",
        description: "An updated action-adventure game set in Norse mythology."
      };

      const updateResult = gameService.updateGame(oldId, updatedGame);
      expect(updateResult.status).to.equal(200);
      expect(updateResult.message).to.equal("Game updated successfully.");

      const games = gameService.getGames().data;
      const game = games.find(game => game.id === oldId);
      expect(game).to.deep.equal(updatedGame);
    });

    it("should return an error if the game to update is not found", function() {
      const nonExistentId = "999";
      const updatedGame = {
        id: "999",
        title: "Nonexistent Game",
        genre: "Action",
        year: 2020,
        developer: "Unknown Studio",
        description: "This game does not exist."
      };

      const result = gameService.updateGame(nonExistentId, updatedGame);
      expect(result.status).to.equal(404);
      expect(result.error).to.equal("Game Not Found!");
    });

    it("should return an error if the new game data is invalid", function() {
      const existingId = "3"; 
      const invalidUpdatedGame = {
        id: "3",
        title: "The Witcher 3",
      
      };

      const result = gameService.updateGame(existingId, invalidUpdatedGame);
      expect(result.status).to.equal(400);
      expect(result.error).to.equal("Invalid Game Data!");
    });
  });
});
