import { Injectable } from '@angular/core';
import { User } from '../classes/user';
import { HttpClient } from '@angular/common/http';
const GET_UTENTI: any = 'http://localhost:3000/users';
const POST_UTENTI: any = 'http://localhost:3000/users';
const DELETE_UTENTI: any = 'http://localhost:3000/users/';
const PUT_UTENTI: any = 'http://localhost:3000/users/';

@Injectable({
  providedIn: 'root'
})
export class UserService {



  constructor(private httpClient: HttpClient) { }


  getUsers() {
    return this.httpClient.get(GET_UTENTI);

  }

  deleteUser(user: User) {
    console.log("deleteUser: IN");
    console.log("deleteUser: id " + user.id);
    return this.httpClient.delete(DELETE_UTENTI + user.id);

  }

  createUser(user: User) {
    console.log("createUser: IN");
    console.log("request: " + JSON.stringify(user));
    return this.httpClient.post(POST_UTENTI, user);
  }

  updateUser(user: User) {
    console.log("updateUser: IN");
    console.log("request: " + JSON.stringify(user));
    return this.httpClient.put(PUT_UTENTI + user.id, user);
    
  }
}
