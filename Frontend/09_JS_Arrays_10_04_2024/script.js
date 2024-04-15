let array = [1, 2, 3, 'four', 'five']
console.log(array);
console.log(typeof array);

// push method, меняет исходный массив и возвращает длину массива
console.log('=============== PUSH ===============');
let result1 = array.push(6, 7, 8)
console.log(array);
console.log(result1);

// pop method, удаляет последний элемент и возвращает длину массива
console.log('=============== POP ===============');
let result2 = array.pop();
console.log(array);
console.log(result2);

// shift method, удаляет первый элемент и возвращает длину массива
console.log('=============== SHIFT ===============');
let result3 = array.shift();
console.log(array);
console.log(result3);

// unshift method, меняет исходный массив, добавляя в начало массива, возвращает длину массива
console.log('=============== SHIFT ===============');
let result4 = array.shift(0, 1);
console.log(array);
console.log(result4);

