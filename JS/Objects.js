let obj1 = new Object();
let obj2 = {};

obj1.name = "Lawrance";
obj1["age"] = 20;
obj2.name = "karthick";
obj2["age"] = 19;

let user = {
    name : "Lawrance",
    age: 20,
    id: "igfuh4hj"
};
/*
for(let key in user) {
    alert(key);
    alert(user[key]);
}
*/
function problem1() {
let isEmpty = (schedule) => {
    for(let key in schedule) {
        return false;
    } return true;
};


let schedule = {};
alert(isEmpty(schedule))
schedule["Lawrance"] = 2.5;
alert(isEmpty(schedule))
}


function problem2() {
let salaries = {
  John: 100,
  Ann: 160,
  Pete: 130
}

let sum = 0;

for(let keys in salaries) {
    sum += salaries[keys];
}

    console.log(sum);
}

function problem3() {
    let multiplyNumeric = menu => {
        for(let keys in menu) {
            if(typeof(menu[keys]) === "number") {
                menu[keys] *= 2;
            }
        }
    }

    let menu = {
    width: 200,
    height: 300,
    title: "My menu"
    };

    multiplyNumeric(menu);
    console.log(menu)
}

problem3();
