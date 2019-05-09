import { Component } from '@angular/core';
import { User } from './classes/user';
import { JsonPipe } from '@angular/common';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'crud-angular';
  showForm: boolean = false;
  userSelected: User;

  update(user:User) {
    alert("emitted user " + JSON.stringify(user));
    this.showForm = true;
    const userCopy: User = Object.assign({}, user);
    this.userSelected = userCopy;

  }

  newUser() {
    this.showForm = true;
    this.userSelected = new User();
  }
}
