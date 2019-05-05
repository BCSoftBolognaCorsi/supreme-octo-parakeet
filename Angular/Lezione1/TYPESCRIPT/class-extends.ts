// classes
class AnimalBase {
    name : string
    constructor(name: string){
        this.name = name;
    }
    move(distance : number){
         console.log('I am moving '+ distance + ' Meters')
    }
    getName(){
        return 'my name is '+this.name;
    }
}

class Birds extends AnimalBase {
     place : string
    
    constructor(name: string, place : string = 'SEA'){
         
         super(name);
         
        this.place = place;
    }
    getPlace() : string{
         return this.place; 
    }
    setPlace(place: string) : void {
         this.place = place
    }
    move(distance : number){
        console.log('I am flying  ' +distance + ' high')
    }
}

let dove = new Birds('Dove', 'OCEAN');
dove.move(50);
console.log(dove.getName())
console.log(dove.getPlace())
