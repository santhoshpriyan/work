import { Component } from '@angular/core';
import { AuthenticationService} from './_service/authentication.service';
import { User } from './_models/User';
import { Role } from './_models/Role';
import { Router } from '@angular/router';

@Component({
  selector: 'app-poc-cigna',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'LoginPOCCigna';
  currentUser: User;

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService
  ) {
     this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
}

logout() {
  this.authenticationService.logout();
  this.router.navigate(['/login']);
}

get isAdmin() {
  return this.currentUser && this.currentUser.role === Role.Admin;
}

}
