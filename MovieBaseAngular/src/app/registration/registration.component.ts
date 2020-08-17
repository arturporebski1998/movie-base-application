import { Component, OnInit } from '@angular/core';
import { User } from './../user';
import { UserRegistrationService } from './../user-registration.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

   user: User = new User('','',0);
   message: any;

   constructor(
    private route: ActivatedRoute, 
    private router: Router,
    private userService: UserRegistrationService) { 
      this.user = new User('','',0);
    }

   ngOnInit() {};
    
  
  onSubmit() {
    this.userService.doRegistration(this.user).subscribe(result => this.gotoUserList());
  }
 
  gotoUserList() {
    this.router.navigate(['/users']);
  }

  saveUser(): void {
    this.userService.doRegistration(this.user).subscribe((data) => this.message = data);
  }



}