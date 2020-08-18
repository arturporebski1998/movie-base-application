import { Component, OnInit } from '@angular/core';
import { UserRegistrationService } from '../services/user-registration-service/user-registration.service';
import { User } from '../user';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {
  users: any;
  email: string;

  constructor(private userRegistrationService: UserRegistrationService) { }

  ngOnInit() {
    this.reloadUsers();
  }

  reloadUsers(): void {
    this.userRegistrationService.getUsers().subscribe(data => {
      this.users = data;
    });
  }

  removeUser(user: User): void {
    this.userRegistrationService.deleteUser(user).subscribe(() => {
      this.reloadUsers();
    });
  }

  // --Not used now--
  // findUserByEmail(): void {
  //   this.userRegistrationService.getUserByEmail(this.email).subscribe(()=>{
  //     this.reloadUsers();
  //   });
  // }

}
