import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';
import { Observable } from 'rxjs';

@Injectable()
export class UserRegistrationService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users';
   }

  public doRegistration(user: User): Observable<User> {
    return this.http.post<User>(this.usersUrl, user, {headers: new HttpHeaders().set('Content-type','application/json')});
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }


}