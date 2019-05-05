class MathCalc {
  static readonly PI = 3.1459;
  static readonly rate = 1.12;
  static calcCirclePerimeter(r: number){
      return 2*MathCalc.PI*r;
      
  }
  calcEuroToDollar(euro: number){
     return  MathCalc.rate * euro
  }
}

let calc = new MathCalc();
 console.log(MathCalc.PI)

console.log(MathCalc.calcCirclePerimeter(2));
 // calc exchange rate
console.log('120 Euro are ' + calc.calcEuroToDollar(120) +' Dollars')