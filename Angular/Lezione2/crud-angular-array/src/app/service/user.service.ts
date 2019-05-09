import { Injectable } from '@angular/core';
import { User } from '../classes/user';
import { HttpClient } from '@angular/common/http';
const GET_UTENTI: any = 'http://localhost:3000/users';
const GET_UTENTI_PAGE: any = 'http://localhost:3000/users';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  users: Array<User> = [{
    "id": 1,
    "cognome":"test",
    "nome": "test"
  },
  {
    "id": 2,
    "cognome":"alfa",
    "nome": "alfa"
  },
  {
    "id": 3,
    "cognome":"beta",
    "nome": "beta"
  }];

  constructor(private httpClient: HttpClient) { }

  getUsers(): Array<User> {
    return this.users;
  }

  getUsersHttp() {
    return this.httpClient.get(GET_UTENTI);

  }

  deleteUser(user: User) {
    alert("UserService: delete User ");
    const index = this.users.indexOf(user);
    if (index >= 0) {
        this.users.splice(index, 1);
    }
  }

  createUser(user: User) {
    alert(JSON.stringify(user));
    let lastId = -1;
    this.users.forEach(u => {
      if(u.id > lastId) {
        lastId = u.id;
      }
    });
    user.id = lastId == -1 ? 1 : lastId +1;
    let userCopy = Object.assign({}, user);
    this.users.push(userCopy);
  }

  updateUser(user: User) {
    let index = -1;
    this.users.forEach(u =>{
      if(u.id == user.id){
        index = this.users.indexOf(u);
      }
    });
    let userCopy = Object.assign({}, user);
    if (index > -1) {
      this.users.splice(index, 1, userCopy);
    }
    
  }
}
