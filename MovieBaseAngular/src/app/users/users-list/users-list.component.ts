import { Component, OnInit } from '@angular/core';
import { UserRegistrationService } from 'src/app/services/user-registration-service/user-registration.service';
import { User } from 'src/app/users/user';

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

  private reloadUsers(): void {
    this.userRegistrationService.getUsers().subscribe(data => {
      this.users = data;
    });
  }

  private deleteUser(user: User): void {
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
