import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { AppComponent } from './app.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { UsersComponent } from './users/users.component';
import { UserService } from './service/user.service';
import { UserFormComponent } from './user-form/user-form.component';
import { FormsModule } from '@angular/forms';
@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    UserFormComponent
  ],
  imports: [
    BrowserModule, FormsModule, NgbModule.forRoot(), AngularFontAwesomeModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
