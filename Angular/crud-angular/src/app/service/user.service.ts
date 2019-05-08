import { Injectable } from '@angular/core';
import { User } from '../classes/user';

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

  constructor() { }

  getUsers(): Array<User> {
    return this.users;
  }

  deleteUser(user: User) {
    alert("UserService: delete User ");
    const index = this.users.indexOf(user);
    if (index >= 0) {
        this.users.splice(index, 1);
    }
  }
}
