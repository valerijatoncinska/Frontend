const bank = [];

const bankAccount = {
  accountNumber: "123456789",
  accountHolderName: "Alice",
  balance: 1000,
  deposit: function(sum) {
    sum >= 5 && sum < 100000
      ? (this.balance += sum)
      : alert("Вводимая сумма для пополнения баланса некорректная");
  },
  withdraw: function(sum) {
    sum <= this.balance && sum >= 5
      ? (this.balance -= sum)
      : alert("Вводимая сумма для снятия с баланса некорректная");
  },
  checkBalance() {
    alert(this.balance + "€");
  },
};

const nameInput = document.getElementById("name");
const accountIdInput = document.getElementById("accountId");
const amountInput = document.getElementById("amount");

const accountsListOl = document.getElementById("accountsList");

const withdrawBtn = document.getElementById("withdraw");
const depositBtn = document.getElementById("deposit");

const date = new Date();
console.log(date.getTime()); // кол-во миллисекунд, которое прошло с 1 января 1970 года

// 1713175494805 / 1000 / 60 / 60 / 24 / 365.25

function createAccount() {
  if (nameInput.value.trim()) {
    const date = new Date();
    bank.push({
      ...bankAccount,
      accountNumber: date.getTime() + "",
      accountHolderName: nameInput.value.trim(),
    });
    nameInput.value = "";
    console.log(bank);
  }
}

function showAccounts() {
  accountsListOl.innerHTML = "";
  bank.forEach((account) => {
    const li = document.createElement("li");
    li.innerHTML = `
            <p>Username: ${account.accountHolderName}</p>
            <p>Account Number: ${account.accountNumber}</p>
            <p>Balance: ${account.balance}</p>
        `;
    accountsListOl.appendChild(li);
  });
}

// HOMEWORK

withdrawBtn.onclick = function () {
  const id = accountIdInput.value.trim();
  const amount = +amountInput.value.trim();

  const index = bank.findIndex((account) => account.accountNumber === id);
  if (index === -1) {
    alert(`Проверьте правильность ввода номера аккаунта`);
  } else {
    if (!isNaN(amount)) {
      bank[index].withdraw(amount);
    }
  }

  accountIdInput.value = amountInput.value = "";
};

depositBtn.onclick = function () {
  const id = accountIdInput.value.trim();
  const amount = +amountInput.value.trim();

  const index = bank.findIndex((account) => account.accountNumber === id);
  if (index === -1) {
    alert(`Проверьте правильность ввода номера аккаунта`);
  } else {
    if (!isNaN(amount)) {
      bank[index].deposit(amount);
    }
  }

  accountIdInput.value = amountInput.value = "";
};
