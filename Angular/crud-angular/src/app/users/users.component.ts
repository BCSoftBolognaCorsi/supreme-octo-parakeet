import { UserService } from './../service/user.service';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { User } from '../classes/user';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  @Output() updateUser = new EventEmitter<User>();
  users: Array<User>;

  constructor(private userService: UserService) { }

  ngOnInit() {
   this.users =  this.userService.getUsers();
  }

  deleteUtente(user: User) {
   this.userService.deleteUser(user);
  }

  updateUtente(user: User) {
    alert("edit utente");
    this.updateUser.emit(user);
  }

}
