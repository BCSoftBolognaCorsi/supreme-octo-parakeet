import { Injectable } from '@angular/core';
import { User } from '../classes/user';
import { HttpClient } from '@angular/common/http';
const GET_UTENTI: any = 'http://localhost:8080/utenti';
const GET_UTENTE: any = 'http://localhost:8080/utenti/';
const POST_UTENTI: any = 'http://localhost:8080/utentis';
const DELETE_UTENTI: any = 'http://localhost:8080/utenti/';
const PUT_UTENTI: any = 'http://localhost:8080/utenti/';

@Injectable({
  providedIn: 'root'
})
export class UserService {



  constructor(private httpClient: HttpClient) { }


  getUsers() {
    return this.httpClient.get(GET_UTENTI);

  }

  getUser(id: any) {
    return this.httpClient.get(GET_UTENTE + id);
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
