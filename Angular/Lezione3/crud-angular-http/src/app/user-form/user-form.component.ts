import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
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
  @Output() userOp = new EventEmitter<any>();
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
      this.userService.updateUser(this.user).subscribe(data => {
        console.log(data);
        this.userOp.emit(data);
      }, error => {
        console.log(error)
      });
    } else {
      //CREATE
      this.userService.createUser(this.user).subscribe(data => {
        console.log(data);
        this.userOp.emit(data);
      }, error => {
        console.log(error)
      });
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
