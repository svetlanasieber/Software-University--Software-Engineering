window.addEventListener("load", solve);
function solve() {
  const placeInput = document.getElementById("place");
  const actionInput = document.getElementById("action");
  const personInput = document.getElementById("person");
  const addBtn = document.getElementById("add-btn");
  const taskList = document.getElementById("task-list");
  const doneList = document.getElementById("done-list");
  const form = document.querySelector("#add-task form");

  addBtn.addEventListener("click", addTask);

  function addTask(e) {
    e.preventDefault();
    const place = placeInput.value;
    const action = actionInput.value;
    const person = personInput.value;

    if (place.trim() === "" || action.trim() === "" || person.trim() === "") {
      return;
    }

    const taskLi = document.createElement("li");
    taskLi.classList.add("clean-task");

    const article = document.createElement("article");
    const placeP = document.createElement("p");
    placeP.textContent = `Place:${place}`;
    const actionP = document.createElement("p");
    actionP.textContent = `Action:${action}`;
    const personP = document.createElement("p");
    personP.textContent = `Person:${person}`;

    article.appendChild(placeP);
    article.appendChild(actionP);
    article.appendChild(personP);

    const buttonsDiv = document.createElement("div");
    buttonsDiv.classList.add("buttons");

    const editBtn = document.createElement("button");
    editBtn.classList.add("edit");
    editBtn.textContent = "Edit";
    editBtn.addEventListener("click", onEdit);

    const doneBtn = document.createElement("button");
    doneBtn.classList.add("done");
    doneBtn.textContent = "Done";
    doneBtn.addEventListener("click", onDone);

    buttonsDiv.appendChild(editBtn);
    buttonsDiv.appendChild(doneBtn);

    taskLi.appendChild(article);
    taskLi.appendChild(buttonsDiv);

    taskList.appendChild(taskLi);

    form.reset();

    function onEdit() {
      placeInput.value = place;
      actionInput.value = action;
      personInput.value = person;
      taskList.removeChild(taskLi);
    }

    function onDone() {
      const doneLi = document.createElement("li");
      
      const doneArticle = article.cloneNode(true);
      doneLi.appendChild(doneArticle);

      const deleteBtn = document.createElement("button");
      deleteBtn.classList.add("delete");
      deleteBtn.textContent = "Delete";
      deleteBtn.addEventListener("click", onDelete);
      
      doneLi.appendChild(deleteBtn);
      doneList.appendChild(doneLi);
      taskList.removeChild(taskLi);

      function onDelete() {
        doneList.removeChild(doneLi);
      }
    }
  }
}