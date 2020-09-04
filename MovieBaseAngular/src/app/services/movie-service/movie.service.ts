import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Movie } from '../../movies/movie';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { AuthInterceptorService } from '../auth-interceptor/auth-interceptor.service';


@Injectable({ providedIn: 'root' })
export class MovieService {

  private moviesUrl: string;
  //    pola prywatne
  messageService: any;

  constructor(
    private http: HttpClient) {
    // można jako const zadeklarować
    this.moviesUrl = environment.httpMovies;

  }


  public getMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.moviesUrl)
  }


  public addMovie(movie: Movie): Observable<Movie> {
    return this.http.post<Movie>(this.moviesUrl, movie, environment.httpOptions)
  }


  public deleteMovie(movie: Movie): Observable<Movie> {
    const url = `${this.moviesUrl}/${movie.id}`;
    return this.http.delete<Movie>(url, environment.httpOptions);
  }


  public updateMovie(movie: Movie): Observable<Movie> {
    const url = `${this.moviesUrl}/${movie.id}`;
    return this.http.put<Movie>(url, movie, environment.httpOptions);
  }

  //get by id 
  public getMovie(movie: Movie): Observable<Movie> {
    const url = `${this.moviesUrl}/${movie.id}`;
    return this.http.get<Movie>(url, environment.httpOptions);
  }

}
