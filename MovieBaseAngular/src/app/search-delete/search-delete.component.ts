import { Component, OnInit } from '@angular/core';
import { UserRegistrationService } from '../user-registration.service';
import { User } from '../user';

@Component({
  selector: 'app-search-delete',
  templateUrl: './search-delete.component.html',
  styleUrls: ['./search-delete.component.css']
})
export class SearchDeleteComponent implements OnInit {
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
