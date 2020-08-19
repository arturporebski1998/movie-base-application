import { Component, OnInit } from '@angular/core';
import { Movie } from '../movie';
import { MovieService } from '../services/movie-service/movie.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-movies-list',
  templateUrl: './movies-list.component.html',
  styleUrls: ['./movies-list.component.css']
})
export class MoviesListComponent implements OnInit {
  movies: Movie[];
  selectedMovie: Movie;


  constructor(
    private movieService: MovieService,
    private location: Location) {
  }

  ngOnInit() {
    this.reloadMovies();
  }

  onSelect(movie: Movie): void {
    this.selectedMovie = movie;
  }

  private reloadMovies(): void {
    this.movieService.getMovies().subscribe(data => {
      this.movies = data;
    });
  }

  public deleteMovie(movie: Movie): void {
    this.movieService.deleteMovie(movie).subscribe(() => {
      this.reloadMovies();
    });
  }

  public update(movie: Movie): void {
    this.movieService.updateMovie(movie).subscribe(movie => {
      this.reloadMovies();
      // fajny error tylko nic nie robi :D
    });
  }

  private goBack(): void {
    this.location.back();
  }

}