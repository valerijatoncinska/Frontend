const stock = {
    items: [
      { name: "milk", price: 6, quantity: 50 },
      { name: "cheese", price: 30, quantity: 70 },
      { name: "meat", price: 30, quantity: 40 },
      { name: "pizza", price: 30, quantity: 110 },
      { name: "bread", price: 3, quantity: 100 },
    ], 
    totalCost: 0, 
    addItem(item) {

      const existingItem = this.items.find((e) => e.name === item.name);
  
      if (existingItem) {
        existingItem.quantity += item.quantity;

      } else {
        this.items.push(item);
      }
  
      this.updateTotalCost();
    },

    removeItem(itemName, itemCount) {

      const index = this.items.findIndex((e) => e.name === itemName);
  
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
      this.totalCost = this.items.reduce(
        (acc, item) => acc + item.price * item.quantity,
        0
      );
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
  
    productsList.innerHTML = "";
  
    stock.items.forEach((e, i) => {
      const li = document.createElement("li");
      li.classList.add("list-group-item");
      li.classList.add("list-group-item-action");
      li.textContent = `
              Product name: ${e.name},
              Product price: ${e.price},
              Product quantity: ${e.quantity}
          `;
      productsList.appendChild(li);
    });
  }
  
  stats.onclick = statsHandler;
  
  function statsHandler() {

    const itemsCount = stock.items.length;
    const totalCost = stock.totalCost;
    const totalQuantity = stock.items.reduce(
      (acc, item) => acc + item.quantity,
      0
    );

    const arrPrices = stock.items.map((e) => e.price);
    const maxPrice = Math.max(...arrPrices);
    const minPrice = Math.min(...arrPrices);
    const avgPrice =
      arrPrices.reduce((acc, item) => acc + item, 0) / arrPrices.length;
  

    console.log(stock.items.sort((a, b) => a.price - b.price));

    console.log(stock.items.sort((a, b) => a.quantity - b.quantity));

    console.log(stock.items.sort((a, b) => a.name.length - b.name.length));
  
    console.log(
      stock.items.sort((a, b) => {
        if (a.price === b.price) {
          return a.quantity - b.quantity;
        }
        return a.price - b.price;
      })
    );
  
    statsList.innerHTML = `
          <li class="list-group-item list-group-item-action">
              <p>Count of items: ${itemsCount}</p>
              <p>Total cost: ${totalCost}</p>
              <p>Total Quantity: ${totalQuantity}</p>
              <p>Min price: ${minPrice}</p>
              <p>Average price: ${avgPrice}</p>
              <p>Max price: ${maxPrice}</p>
          </li>
      `;
  }
  
  let countSort = 0;
  function bubbleSort(arr) {
    for (let i = 0; i < arr.length - 1; i++) {
      for (let j = 0; j < arr.length - 1 - i; j++) {
        countSort++;
        if (arr[j] > arr[j + 1]) {
          const temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }
  
  const numbers = [1, 9, 2, 8, 3, 7, 4, 6, 5];
  bubbleSort(numbers);
  
  let double = 0;
  for (const num of numbers) {
      if (num > 0) {
          double += num * 2;
      }
  }