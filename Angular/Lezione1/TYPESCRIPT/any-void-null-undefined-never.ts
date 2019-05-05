// any, void, null, undefined , never

let age: any = 45;
age = '45';
age = [];

let userData: any[] = [45, 'Rossi', 'Mario', {address: 'Bologna'}];

userData = ['444',[], {}];
// void
let myAge:null;



function printName() : void {
   console.log('error')
}

 function returnNever() :never {
      throw new Error('No values defined');
 }
returnNever();

