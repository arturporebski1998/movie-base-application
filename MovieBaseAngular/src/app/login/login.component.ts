import { Component, OnInit, Input } from '@angular/core';
import { User } from '../users/user';
import { AuthenticationService } from '../services/authentication-service/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User(0, '', '', '', '', '');
  invalidLogin = false

  @Input() error: string | null;

  constructor(private router: Router,
    private loginService: AuthenticationService) { }

  ngOnInit() {
  }

  checkLogin() {
    (this.loginService.authenticate(this.user.username, this.user.password).subscribe(
      data => {
        this.router.navigate([''])
        this.invalidLogin = false
      },
      error => {
        this.invalidLogin = true
        this.error = error.message;
      }
    )
    );

  }

}