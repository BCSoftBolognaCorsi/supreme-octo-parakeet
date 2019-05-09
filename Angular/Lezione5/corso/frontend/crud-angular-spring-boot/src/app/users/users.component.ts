import { UserService } from './../service/user.service';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { User } from '../classes/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  @Output() updateUser = new EventEmitter<User>();
  users: any;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    console.log("ngOnInit - UsersComponent");
    this.getUtenti();
  }

  getUtenti(){
    console.log("getUtenti");
    this.userService.getUsers().subscribe(data => {
      console.log(data);
      this.users = data;
    }, error => {
      console.log(error);
    });
  }

  deleteUtente(user: User) {
  console.log("deleteUtente");
   this.userService.deleteUser(user).subscribe(data => {
     this.getUtenti();
   }, error => {
     console.log(error)
   });
  }

  updateUtente(user: User) {
    console.log("updateUtente");
    this.router.navigate(['utenti', user.id]);
  }



}
