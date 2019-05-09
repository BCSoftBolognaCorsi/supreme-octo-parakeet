import { UsersComponent } from './users/users.component';
import { UserFormComponent } from './user-form/user-form.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '../../node_modules/@angular/router';
const routes: Routes = [
  {
    path: 'utenti',
    pathMatch: 'full',
    component: UsersComponent
  }, {
    path: '',
    redirectTo: 'utenti',
    pathMatch: 'full'
  }, {
    path: 'utenti/nuovo',
    component: UserFormComponent
  },
  {
    path: 'utenti/:id',
    component: UserFormComponent
  }

];
@NgModule({
  declarations: [],
  imports: [
    CommonModule, RouterModule.forRoot(routes)
  ], exports:[RouterModule]
})
export class AppRoutingModule { }
