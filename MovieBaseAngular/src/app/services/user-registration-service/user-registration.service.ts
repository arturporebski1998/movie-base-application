import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { User } from '../../users/user';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = environment.httpUsers;
  }

  public getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl)
  }

  public getUserById(id: number): Observable<User> {
    const url = `${this.usersUrl}/${id}`;
    return this.http.get<User>(url);
  }

  public addUser(user: User): Observable<User> {
    return this.http.post<User>(this.usersUrl, user, environment.httpOptions)
  }

  public deleteUser(user: User): Observable<User> {
    const url = `${this.usersUrl}/${user.id}`;
    return this.http.delete<User>(url, environment.httpOptions);
  }

  // --will be used--
  // getUserByEmail(email: string): Observable<User> {
  //   const url = `${this.usersUrl}/${email}`;
  //   return this.http.get<User>(url);
  // }
}

