const stock = {
  items: [
    { name: "bread", price: 3, quantity: 100 },
    { name: "milk", price: 6, quantity: 50 },
    { name: "cheese", price: 500, quantity: 70 },
  ],
  totalCost: 0,

  addItem(item) {
    // example of item: { name, price, quantity }
    const existingItem = this.items.find((e) => e.name === item.name);

    if (existingItem) {
      existingItem.quantity += item.quantity;
    } else {
      this.items.push(item);
    }

    this.updateTotalCost();
  },
  removeItem(itemName, count) {
    const index = this.items.findIndex((e) => e.name === item.name);

    if (index !== -1 && itemCount <= this.items[index].quantity) {
      itemCount === this.items[index].quantity
        ? this.items.splice(index, 1)
        : (this.items[index].quantity -= itemCount);
    } else {
      alert("Данного товара недостаточно на складе");
    }
    this.updateTotalCost();
  },

  updateTotalCost() {
    let acc = 0;
    // for (let i = 0; i < this.items.length; i++) {
    //   acc += this.items[i].price * this.items[i].quantity;
    // }
    // this.totalCost = acc;

    this.totalCost = this.items.reduce(
      (acc, item) => acc + item.price * item.quantity,
      0
    );
    // for (const item of this.items) {
    //   acc += item.price * item.quantity;
    // }
    // итерирует массив, оригинал не меняет
    // this.items.reduce((acc, item) => acc + item.price * item.quantity);
  },
};

stock.updateTotalCost();
console.log(stock.totalCost);

add.onclick = addHandler;
function addHandler() {
  const name = productName.value.trim();
  const price = +productPrice.value.trim();
  const quantity = +productQuantity.value.trim();

  if (name && price && price > 0 && quantity && quantity > 0) {
    stock.addItem({ name, price, quantity });
  }

  productName.value = productPrice.value = productQuantity.value = "";

  productsList.innerHTML = ``;

  console.log(stock.totalCost);

  stock.items.forEach((e) => {
    
    const li = document.createElement("li");
    li.textContent = `
    Product name: ${e.name}, 
    Product price: ${e.price},
    Product quantity: ${e.quantity},
    `;
    productsList.appendChild(li);
  });
}

stats.onclick = statsHandler;
function statsHandler() {
  const itemCount = stock.items.length; // кол-во видов товаров
  console.log(itemCount);

  const totalCost = stock.totalCost; // суммарная цена

  let totalQuantity = 0; // кол-во товаров на складе
  for (const item of stock.items) {
    totalQuantity += item.quantity;
  }
  console.log(totalQuantity);

  // инициализация массива, где будут храниться значение price
  // для использования в методе Math.min() и Math.max()
  const arrayOfPrice = [];

  // итерация по массиву товаров, сбор и помещение value цены в массив
  for (const item of stock.items) {
    arrayOfPrice.push(item.price);
  }

  let maxPrice = Math.max(...arrayOfPrice); // максимальная цена
  console.log(maxPrice);

  let minPrice = Math.min(...arrayOfPrice); // минимальная цена
  console.log(minPrice);

  // ...........................................тут все неудачные попытки написания кода....................................
  // let minPrice = 0;
  // function getMinimumPrice(array) {
  //   let minPrice = array[0];
  //   for (let i = 1; i < array.length; i++) {
  //     if (array[i] > minPrice) {
  //       minPrice = array[i];
  //     }
  //   }
  //   return minPrice.price;
  // }

  // minPrice = getMinimumPrice(stock.items);
  // console.log(minPrice);

  // let priceValue = stock.items.price;
  // console.log(priceValue);

  // const priceKeyArr = [];
  // const priceKey = this.item.price.value;
  // for (const item of this.items) {
  //   priceKeyArr.push(priceKey);
  // }
  // const minPrice = Math.min(priceKeyArr)

  // let maxPrice = 0;
  // function getMaximumPrice(array) {
  //   let maxPrice = array[0];
  //   for (let i = 1; i < array.length; i++) {
  //     if (array[i] < maxPrice) {
  //       maxPrice = array[i];
  //     }
  //   }
  //   return maxPrice.price;
  // }

  // maxPrice = getMaximumPrice(stock.items);
  // console.log(maxPrice);
  // .............................тут закончились все неудачные попытки написания кода....................................

  // вычисление средней цены + метод Math.round для округления
  // может, на практике не совсем удобно, но мне так больше нравится пока что
  let averagePrice = Math.round(totalCost / itemCount);
  console.log(averagePrice);

  // создание констант для помещения в HTML
  const ol = (document.getElementById("statsList").innerHTML = `
    Product type quantity: ${itemCount},</br>
    Product total price: ${totalCost},</br>
    Product quantity: ${totalQuantity},</br>
    Product maximum price: ${maxPrice},</br>
    Product minimum price: ${minPrice},</br>
    Product average price: ${averagePrice},</br>
    `);
}
