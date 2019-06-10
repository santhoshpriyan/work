import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AuthGuard } from './_guards/auth.guards';
import { AdminComponent } from './admin/admin.component';
import { Role } from './_models/Role';
const routes: Routes = [
  {path: '', component: DashboardComponent, canActivate: [AuthGuard] },
  {path: 'login', component: LoginComponent},
  {path: 'admin', component: AdminComponent, canActivate: [AuthGuard], data: { roles: [Role.Admin] }},
  {path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard] },
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
