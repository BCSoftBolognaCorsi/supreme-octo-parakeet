// Interface
 interface IUser  {
    lastname:string,
     firstname: string
}
 
function showUser( user: { lastname:string, firstname: string}){
     console.log(user.firstname +' ,' + user.lastname)
}

function showUser2( user: IUser){
    console.log(user.firstname +' ,' + user.lastname)
}
showUser({lastname:'Arias', firstname: 'Hidran'});
showUser2({lastname:'Arias', firstname: 'Hidran'});



interface IUser2  {
    lastname:string,
    firstname: string,
    address? : string
}
function showUser3( user: IUser2){
    console.log(user.firstname +' ,' + user.lastname)
}
showUser3({lastname:'Arias', firstname: 'Hidran'})


interface IUser3  {
    lastname:string,
    firstname: string,
    address? : string,
    [propName :string] : any
    
}
function showUser4( user: IUser3){
    console.log('showuser 4= '+ user.firstname +' ,' + user.lastname +' ,'+user.age)
}

showUser4({lastname:'Arias', firstname: 'Hidran',age:45,   title:'Engineer'});








