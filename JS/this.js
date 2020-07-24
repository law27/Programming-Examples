let user = {
    name : "Lawrance",
    age : 30,
    password : "*****",
    sayHi() {
        alert(this.name);
    }
};


//user.sayHi();

function sayAge() {
    alert(this.age);
}

user.sayAge = sayAge;

//user['sayAge']();


//alert(this === window);

let calculator = {
    read() {
        this.x = prompt("Enter the Number ", 0);
        this.y = prompt("Enter the Number ", 0);
    },

    sum() {
        return this.x + this.y;
    },

    mul() {
        return this.x * this.y;
    }
}

//calculator.read();

//alert(calculator.sum());
//alert(calculator.mul());


let ladder = {
  step: 0,
  up() {
    this.step++;
    return this;
  },
  down() {
    this.step--;
    return this;
  },
  showStep: function() { // shows the current step
    alert( this.step );
    return this;
  }
};

ladder.up().up().down().showStep(); // 1
