import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

import { Movie } from '../../movie';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';


@Injectable({ providedIn: 'root'})
export class MovieService {

  private moviesUrl: string;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  messageService: any;

  constructor(private http: HttpClient) {
    this.moviesUrl = 'http://localhost:8080/movies';
  }

  
  getMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.moviesUrl)
  }


  addMovie(movie: Movie): Observable<Movie> {
    return this.http.post<Movie>(this.moviesUrl, movie, this.httpOptions)
  }


  deleteMovie(movie: Movie): Observable<Movie> {
    const url = `${this.moviesUrl}/${movie.id}`;
    return this.http.delete<Movie>(url, this.httpOptions);
  }


  updateMovie(movie: Movie): Observable<Movie> {
    const url = `${this.moviesUrl}/${movie.id}`;
    return this.http.put<Movie>(url, movie, this.httpOptions);
  }

  //get by id 
   getMovie(movie: Movie): Observable<Movie> {
    const url = `${this.moviesUrl}/${movie.id}`;
    return this.http.get<Movie>(url);
  }

}
