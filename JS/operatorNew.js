//Constructor Functions
/*
function User(name) {
    this.name = name;
    this.isAdmin = false;

    this.sayHi = function() {
        console.log("Screw You");
    }
}

let user = new User("Lawrance");
alert(user.name);
alert(user.isAdmin);
user.sayHi();
*/

//Constructor functions will return this
//If there is a return statement explicitly mentioned && if it is a object then the object will be returned
//If not the return statement ignored and this will be returned

/*
 * Constructor functions or, briefly, constructors, are regular functions, but there’s a common agreement to name them with capital letter first.
Constructor functions should only be called using new. Such a call implies a creation of empty this at the start and returning the populated one at the end!
 * */


function problemOne() {
    function Calculator() {
        this.read = function() {
            this.a = prompt("Enter the number", 0);
            this.b = prompt("Enter the number", 0);
        }

        this.sum = function() {
            return +this.a + +this.b;
        }

        this.multi = function() {
            return this.a * this.b;
        }
    }
    let calculator = new Calculator();
    calculator.read();

    alert( "Sum=" + calculator.sum() );
    alert( "Mul=" + calculator.multi() );
}

function problemTwo() {
    function Accumulator(startingValue) {
        this.value = startingValue;
        this.read = function() {
            this.value += +prompt("Enter the Number", 0);
        }
    }

    let accumulator = new Accumulator(1); // initial value 1

    accumulator.read(); // adds the user-entered value
    accumulator.read(); // adds the user-entered value

    alert(accumulator.value); // shows the sum of these values

}
