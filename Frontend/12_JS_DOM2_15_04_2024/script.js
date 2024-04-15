const bank = [];

const bankAccount = {
  number: "123456789",
  holderName: "Alice",
  balance: 0,
  deposit: (sum) => {
    sum >= 5 && sum < 100000
      ? (bankAccount.balance += sum)
      : alert("Вводимая сумма для пополнения баланса некорректная");
    return bankAccount.balance;
  },
  withdraw: (sum) => {
    sum <= bankAccount.balance && sum >= 5
      ? (bankAccount.balance -= sum)
      : alert("Вводимая сумма для снятия с баланса некорректная");
    return bankAccount.balance;
  },
  checkBalance() {
    alert(this.balance + "€");
  },
};

const nameInput = document.getElementById("name");
const accountIdInput = document.getElementById("accountId");
const amountInput = document.getElementById("amount");

const accountListOl = document.getElementById("accountsList");

const withdrawBtn = document.getElementById("withdraw");
const depositBtn = document.getElementById("deposit");

const date = new Date();
console.log(date.getTime());

function createAccount() {
  if (nameInput.value.trim()) {
    const date = new Date();
    bank.push({
      ...bankAccount,
      number: date.getTime() + "",
      holderName: nameInput.value.trim(),
    });
    nameInput.value = "";
    console.log(bank);
  }
}

function showAccounts() {
  accountListOl.innerHTML = ``;
  bank.forEach((account) => {
    const li = document.createElement("li");
    li.innerHTML = `
        <p>Username: ${account.holderName}</p>
        <p>Account Number: ${account.number}</p>
        <p>Balance: ${account.balance}</p>­
        `;
    accountListOl.appendChild(li);
  });
}
