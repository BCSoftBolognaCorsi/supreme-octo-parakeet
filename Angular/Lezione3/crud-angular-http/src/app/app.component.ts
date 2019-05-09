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

  createUpdatedUser(userData: User) {
    this.userOperation = userData;
    let foundItem = false;
    let replaceTarget: User;
    this.myChild.users.forEach(u => {
      if (u.id === userData.id) {
         replaceTarget  = u;
          foundItem = true;
      }
    });
    if (!foundItem) {
      this.myChild.users.push(this.userOperation);
    } else {
      this.myChild.users.splice(this.myChild.users.indexOf(replaceTarget), 1, userData);
    }

  }
}
