let users = {
    name : "Lawrance",
    age: 20,
    address : "Coimbatore"
}

let a = users; //this copies the reference

let clonedUser = Object.assign({} , users); //This will clone but shallow cloning not deep cloning

function deepCloning(object) {
    let cloneObject = new Object();
    for(let keys in object) {
        if(typeof(object[keys]) === "object") {
            cloneObject[keys] = deepCloning(object[keys],cloneObject);
        } else {
            cloneObject[keys] = object[keys];
        }
    }
    return cloneObject;
}   //DeepCloning a Object {Limited to only to Objects of objects not for arrays}


let values = {
    obj1 : {
        obj2 : {
            obj3 : {
                obj4 : {
                    obj5 : {
                        obj6 : {
                            name: "Lawrance"
                        }
                    }
                }
            }
        }
    }
}
console.log(values);
console.log(deepCloning(values));
values.obj1.obj2.obj3.obj4.obj5.obj6.name = "Rubesh";
console.log(values);
console.log(deepCloning(values));
