const BASE_URL = "http://localhost:3030/jsonstore/matches/";

const loadMatchesButton = document.getElementById("load-matches");
const matchesList = document.getElementById("list");
const addButton = document.getElementById("add-match");
const editButton = document.getElementById("edit-match");

const hostInput = document.getElementById("host");
const scoreInput = document.getElementById("score");
const guestInput = document.getElementById("guest");

let currentMatchId = null;

loadMatchesButton.addEventListener("click", loadMatches);
addButton.addEventListener("click", addMatch);
editButton.addEventListener("click", editMatch);

async function loadMatches() {
    try {
        const response = await fetch(BASE_URL);
        const matches = await response.json();

        matchesList.innerHTML = "";

        Object.values(matches).forEach(match => {
            const matchElement = createMatchElement(match);
            matchesList.appendChild(matchElement);
        });

        editButton.disabled = true;
    } catch (error) {
        console.error("Error loading matches:", error);
    }
}

function createMatchElement(match) {
    const li = document.createElement("li");
    li.className = "match";
    li.dataset.id = match._id;

    const infoDiv = document.createElement("div");
    infoDiv.className = "info";

    const hostP = document.createElement("p");
    hostP.textContent = match.host;
    const scoreP = document.createElement("p");
    scoreP.textContent = match.score;
    const guestP = document.createElement("p");
    guestP.textContent = match.guest;

    infoDiv.appendChild(hostP);
    infoDiv.appendChild(scoreP);
    infoDiv.appendChild(guestP);

    const btnWrapperDiv = document.createElement("div");
    btnWrapperDiv.className = "btn-wrapper";

    const changeButton = document.createElement("button");
    changeButton.className = "change-btn";
    changeButton.textContent = "Change";
    changeButton.addEventListener("click", () => populateEditForm(match));

    const deleteButton = document.createElement("button");
    deleteButton.className = "delete-btn";
    deleteButton.textContent = "Delete";
    deleteButton.addEventListener("click", () => deleteMatch(match._id));

    btnWrapperDiv.appendChild(changeButton);
    btnWrapperDiv.appendChild(deleteButton);

    li.appendChild(infoDiv);
    li.appendChild(btnWrapperDiv);

    return li;
}

async function addMatch(event) {
    event.preventDefault();

    const host = hostInput.value;
    const score = scoreInput.value;
    const guest = guestInput.value;

    console.log("Adding match with:", { host, score, guest });

    if (!host || !score || !guest) {
        console.log("Missing fields");
        return;
    }

    const newMatch = {
        host,
        score,
        guest
    };

    try {
        const response = await fetch(BASE_URL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(newMatch)
        });

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        clearInputFields();
        await loadMatches();
    } catch (error) {
        console.error("Error adding match:", error);
    }
}

function populateEditForm(match) {
    hostInput.value = match.host;
    scoreInput.value = match.score;
    guestInput.value = match.guest;
    currentMatchId = match._id;

    addButton.disabled = true;
    editButton.disabled = false;
}

async function editMatch(event) {
    event.preventDefault();

    const host = hostInput.value;
    const score = scoreInput.value;
    const guest = guestInput.value;

    if (!host || !score || !guest) {
        return;
    }

    const updatedMatch = {
        host,
        score,
        guest,
        _id: currentMatchId
    };

    try {
        await fetch(`${BASE_URL}${currentMatchId}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(updatedMatch)
        });

        clearInputFields();
        await loadMatches();

        addButton.disabled = false;
        editButton.disabled = true;
        currentMatchId = null;
    } catch (error) {
        console.error("Error editing match:", error);
    }
}

async function deleteMatch(matchId) {
    try {
        await fetch(`${BASE_URL}${matchId}`, {
            method: "DELETE"
        });

        await loadMatches();
    } catch (error) {
        console.error("Error deleting match:", error);
    }
}

function clearInputFields() {
    hostInput.value = "";
    scoreInput.value = "";
    guestInput.value = "";
}