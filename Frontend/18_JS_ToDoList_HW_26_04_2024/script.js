const toDoBank = {
  tasks: [],
  addTask(task) {
    const existingTask = this.tasks.find((e) => e.name === task.name);

    if (existingTask) {
      alert("У вас уже есть эта цель в списке.");
    } else {
      this.tasks.push(task);
    }
  },

  removeTask(taskName) {
    const index = this.tasks.findIndex((e) => e.name === taskName);
    this.tasks.splice(index, 1);
  },
};

addBtn.onclick = addHandler;

function addHandler() {
  const name = taskName.value.trim();
  taskName.value = "";
  toDoBank.addTask({name});

  updateTotalList();
}

function updateTotalList() {
  tasksList.innerHTML = "";

  toDoBank.tasks.forEach((e) => {
    const li = document.createElement("li");
    li.classList.add("list-group-item", "list-group-item-action");
    const removeButton = document.createElement("button");
    removeButton.textContent = "X";
    removeButton.classList.add("btn", "btn-danger", "ms-2");
    removeButton.onclick = () => {
      toDoBank.removeTask(e.name);
      li.remove();
    };

    li.textContent = `
            ${e.name}
          `;
    li.appendChild(removeButton);

    tasksList.appendChild(li);
  });
}
