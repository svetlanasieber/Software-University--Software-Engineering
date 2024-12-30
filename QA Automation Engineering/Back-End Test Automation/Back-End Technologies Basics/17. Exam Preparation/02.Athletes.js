function solve(athletes) {
    // Filter athletes by sport
    function getAthletesBySport(sport) {
        return athletes.filter(athlete => athlete.sport === sport);
    }

    // Add a new athlete
    function addAthlete(id, name, sport, medals, country) {
        athletes.push({ id, name, sport, medals, country });
        return athletes;
    }

    // Find athlete by ID
    function getAthleteById(id) {
        const athlete = athletes.find(athlete => athlete.id === id);
        return athlete ? athlete : `Athlete with ID ${id} not found`;
    }

    // Remove athlete by ID
    function removeAthleteById(id) {
        const index = athletes.findIndex(athlete => athlete.id === id);
        if (index !== -1) {
            athletes.splice(index, 1);
            return athletes;
        }
        return `Athlete with ID ${id} not found`;
    }

    // Update athlete's medal count
    function updateAthleteMedals(id, newMedals) {
        const athlete = athletes.find(athlete => athlete.id === id);
        if (athlete) {
            athlete.medals = newMedals;
            return athletes;
        }
        return `Athlete with ID ${id} not found`;
    }

    // Update athlete's country
    function updateAthleteCountry(id, newCountry) {
        const athlete = athletes.find(athlete => athlete.id === id);
        if (athlete) {
            athlete.country = newCountry;
            return athletes;
        }
        return `Athlete with ID ${id} not found`;
    }

    // Return an object with references to all the methods
    return {
        getAthletesBySport,
        addAthlete,
        getAthleteById,
        removeAthleteById,
        updateAthleteMedals,
        updateAthleteCountry
    };
}
