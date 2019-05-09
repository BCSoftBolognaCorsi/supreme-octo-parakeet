import { Component, ViewChild } from '@angular/core';
import { User } from './classes/user';
import { JsonPipe } from '@angular/common';
import { UsersComponent } from './users/users.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'crud-angular';
  @ViewChild(UsersComponent)
  private _myChild: UsersComponent;
  public get myChild(): UsersComponent {
    return this._myChild;
  }
  public set myChild(value: UsersComponent) {
    this._myChild = value;
  }
  showForm: boolean = false;
  userSelected: User;
  userOperation: User;

  update(user:User) {
    console.log("emitted user " + JSON.stringify(user));
    this.showForm = true;
    const userCopy: User = Object.assign({}, user);
    this.userSelected = userCopy;

  }

  newUser() {
    this.showForm = true;
    this.userSelected = new User();
  }


}
