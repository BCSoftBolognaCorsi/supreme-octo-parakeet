import { Component, OnInit, Input } from '@angular/core';
import { User } from '../classes/user';

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
  constructor() { }

  ngOnInit() {
    this.user = new User();
  }

}
