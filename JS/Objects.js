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

for(let key in user) {
    alert(key);
    alert(user[key]);
}
