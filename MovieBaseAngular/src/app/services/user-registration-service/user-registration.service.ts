import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { User } from '../../user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  private usersUrl: string;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users';
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl)
  }

  getUserById(id: number): Observable<User> {
    const url = `${this.usersUrl}/${id}`;
    return this.http.get<User>(url);
  }

  addUser(user: User): Observable<User> {
    return this.http.post<User>(this.usersUrl, user, this.httpOptions)
  }

  deleteUser(user: User): Observable<User> {
    const url = `${this.usersUrl}/${user.id}`;
    return this.http.delete<User>(url, this.httpOptions);
  }

  // --will be used--
  // getUserByEmail(email: string): Observable<User> {
  //   const url = `${this.usersUrl}/${email}`;
  //   return this.http.get<User>(url);
  // }
}

