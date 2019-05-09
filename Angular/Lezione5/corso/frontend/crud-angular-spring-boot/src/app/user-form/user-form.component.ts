import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { User } from '../classes/user';
import { UserService } from './../service/user.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
 _user: User;
 userCopy: User;
  @Input() set  user(user: any) {
    this._user = user;
    this.userCopy = Object.assign({}, user);
  }

  get user() {
    return this._user;
  }
  constructor(private userService: UserService,private router: Router,  private route: ActivatedRoute) { }

  ngOnInit() {
    this.user = new User();

    this.route.params.subscribe(
      (params: any) => {
        if (!params.id) {
          return;
        }
       this.userService.getUser(+params.id).subscribe(  data => {
              this.user =  data;
        },
            error => {
                console.log(error);
     });
       }
    );
  }

  saveUser(){
    if(this.user.id > 0) {
      //UPDATE
      this.userService.updateUser(this.user).subscribe(data => {
        console.log(data);
      }, error => {
        console.log(error)
      });
    } else {
      //CREATE
      this.userService.createUser(this.user).subscribe(data => {
        console.log(data);
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
  }

  backToUsers() {
    this.router.navigate(['utenti']);

  }

}
