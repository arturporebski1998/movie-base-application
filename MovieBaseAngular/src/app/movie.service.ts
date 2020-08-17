import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

import { Movie } from './movie';
import { MessageService } from './message.service';
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

  

  /** GET movies from the server */
  getMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.moviesUrl)
  }

  /** POST: add a new movie to the server */
  addMovie(movie: Movie): Observable<Movie> {
    return this.http.post<Movie>(this.moviesUrl, movie, this.httpOptions)
  }

  /** DELETE: delete the movie from the server */
  deleteMovie(movie: Movie): Observable<Movie> {
    const url = `${this.moviesUrl}/${movie.id}`;
    return this.http.delete<Movie>(url, this.httpOptions);
  }

  /** PUT: update the movie on the server */
  updateMovie(movie: Movie): Observable<Movie> {
    const url = `${this.moviesUrl}/${movie.id}`;
    return this.http.put<Movie>(url, movie, this.httpOptions);
  }




  
   /** GET movie by id. Will 404 if id not found */
   getMovie(id: number): Observable<Movie> {
    const url = `${this.moviesUrl}/${id}`;
    return this.http.get<Movie>(url);
  }


  // /* GET movies whose title contains search term */
  searchMovies(term: string): Observable<Movie[]> {
    if (!term.trim()) {
      // if not search term, return empty movie array.
      return of([]);
    }
    return this.http.get<Movie[]>(`${this.moviesUrl}/?title=${term}`)
  }

   /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }


  /** Log a MovieService message with the MessageService */
  private log(message: string) {
    this.messageService.add(`MovieService: ${message}`);
  }

  
// moje do wywalenia --------------------------
  // public findAll(): Observable<Movie[]> {
  //   return this.http.get<Movie[]>(this.moviesUrl);
  // }

  // public saveMovie(movie: Movie): Observable<Movie> {
  //   return this.http.post<Movie>(this.moviesUrl, movie, {headers: new HttpHeaders().set('Content-type','application/json')});
  // }
  // moje do wywalenia --------------------------

   /** GET movie by id. Return `undefined` when id not found */
  //  getMovieNo404<Data>(id: number): Observable<Movie> {
  //   const url = `${this.moviesUrl}/?id=${id}`;
  //   return this.http.get<Movie[]>(url)
  //     .pipe(
  //       map(movies => movies[0]), // returns a {0|1} element array
  //       tap(h => {
  //         const outcome = h ? `fetched` : `did not find`;
  //         this.log(`${outcome} movie id=${id}`);
  //       }),
  //       catchError(this.handleError<Movie>(`getMovie id=${id}`))
  //     );
  // }

}
