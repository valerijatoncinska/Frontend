console.log(document.body);

// ссылка на элемент с #div1
const div1 = document.getElementById("div1"); // ссылка на элемент
div1.style.border = "1px solid black"; // настройка значения свойства border у элемента div1

console.log(div1.style.border); // значение свойства border у элемента div1

const div1Query = document.querySelector("#div1");
console.log(div1Query); // ссылка на элемент

const pDiv1 = document.querySelectorAll("#div1 > p");
console.log(pDiv1); // массив ссылок на элемент(-ы)

/*
    "x = x"   'x = x'    `x = ${x}`
*/

for (let i = 0; i < pDiv1.length; i++) {
  pDiv1[i].innerHTML = `<span>new text ${i + 1}</span>`; // "<span>new text " + (i + 1) + "</span>"
}

const newP = document.createElement("p"); // создали параграф
newP.textContent = "Данный элемент был создан с помощью метода createElement()"; // наделили параграф контентом
div1.appendChild(newP); // добавили элемент в тот, который уже есть на странице

const t = setInterval(move, 20); // 1000ms = 1s

const box = document.getElementById("box");
let step = 0;
let flag = false;

function move() {
//   if (step === 150) { // long version
//     flag = false;
//   }
//   if (step === 0) {
//     flag = true;
//   }
    if (step === 0 || step === 150) { // short version
        flag = !flag;
    }

  if (flag) {
    step++;
  } else {
    step--;
  }
  box.style.top = `${step}px`; // или step + "px"
  box.style.left = `${step}px`;
}

// clearInterval(t) - для остановки автозапуска функции
