import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserRegistrationService } from '../services/user-registration-service/user-registration.service';
import {FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {



  user: User = new User(0,'','','','','');

  constructor(private userRegistrationService: UserRegistrationService) { }

  ngOnInit() {
  }

  public registerNow() {
    this.userRegistrationService.addUser(this.user).subscribe();
  }

}
