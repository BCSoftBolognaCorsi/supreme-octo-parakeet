// setters & getters
class  User {
    private _name : string
    
    set name(name: string){
        this._name = name.toUpperCase();
    }
    get name(){
        return this._name;
    }
}

 let user = new User();
 user.name ='hidran';
 console.log(user.name);