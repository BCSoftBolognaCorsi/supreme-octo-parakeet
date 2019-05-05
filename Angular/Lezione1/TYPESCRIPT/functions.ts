// typed functions

function  myFunction(){
    
}

let myFunc = function () {
     
    
}
myFunc();

let myArrowFunc = (e: any) => { console.log(e)}
myArrowFunc('Rossi')
let myArrowFunc2 =(e: number) : number =>  e*2


console.log(myArrowFunc2(2))



function func(x: string, y: number) : void {
    console.log('I am func')
}

let  myFunc2 : (x: string, y: number) => void;

myFunc2 = func;
myFunc2('ts', 4);
myFunc2 = function (name: string, age: number) : void {
    console.log(name +'  is  '+ age + ' years old')
}
myFunc2('Mario', 45);




























