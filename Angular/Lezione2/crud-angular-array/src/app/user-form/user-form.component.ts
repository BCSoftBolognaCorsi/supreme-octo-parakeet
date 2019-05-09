import { Component, OnInit, Input } from '@angular/core';
import { User } from '../classes/user';
import { UserService } from './../service/user.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
 _user: User;
 userCopy: User;
 
  @Input() set  user(user: User) {
    this._user = user;
    this.userCopy = Object.assign({}, user);
  }

  get user() {
    return this._user;
  }
  constructor(private userService: UserService) { }

  ngOnInit() {

  }

  saveUser(){
    if(this.user.id > 0) {
      //UPDATE
      this.userService.updateUser(this.user);
    } else {
      //CREATE
      this.userService.createUser(this.user);
    }
    
  }

  resetForm() {
    if (this.user.id === 0) {
        this.user = new User();
    } else {
        this.user = this.userCopy;
    }
    // this.user = new User();
  }

}
