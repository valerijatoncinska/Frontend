// вызов функции
console.log(multiply (2, 5));
 
// создание этой самой функции, не имеет значения, когда она создана, её можно использоваться везде
function multiply(a, b) { 
    return a * b
}
// а тут так не работает, регулярные функции существуют глобально,
// стрелочные функции создаются локально и имеют "мёртвые зоны"
// multiplyArrow (3, 4);

console.log(multiply (2, 5));

// здесь нужно после стрелки писать, что нужно вернуть
const multiplyArrow = (a, b) => a * b;

// const multiplyArrow = (a, b) => {
//     return a * b;
// }
// одно и то же

multiplyArrow (3, 4);

let arr = ['one', 'two', 'Three', 'eight', 'tHree', 'thrEE', 'six'];

console.log('=======================indexOf==============================');
//возвращает первый индекс элемента или -1, если элемент не найден
let res = arr.indexOf(Three, 3);
console.log(res); 

console.log('=======================includes==============================');
//возвращает true или false
let res1 = arr.includes(two);
console.log(res1); 

console.log('=======================indexOf==============================');
//predicate должен возвращать true, когда элемент подходит к искомому
let res2 = arr.findIndex((e, i) => e.length === 3 && i > 2);
console.log(res2); 

// то же самое, но код короче
function predicateLength3(e, i) {
    return e.length === 3 && i > 2;
}
