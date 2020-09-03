import { Component, OnInit, Input } from '@angular/core';
import { MovieService } from 'src/app/services/movie-service/movie.service';
import { Movie } from 'src/app/movies/movie';
import { MoviesListComponent } from '../movies-list/movies-list.component';
import { Genres, Countries } from 'src/environments/environment';

@Component({
  selector: 'app-movie-detail',
  templateUrl: './movie-detail.component.html',
  styleUrls: ['./movie-detail.component.css']
})

export class MovieDetailComponent implements OnInit {

  @Input() movie: Movie;
  

  constructor(
    private movieService: MovieService,
    private moviesList: MoviesListComponent,
  ) { }

  genres = Genres;
	country = Countries;


  ngOnInit(): void {
    //this.selectedMovie();
  }

  selectedMovie(): void {
    this.moviesList.onSelect(this.movie);
  }

  getMovie(movie: Movie): void {
    this.movieService.getMovie(movie)
    .subscribe(movie => this.movie = movie);
  }

  updateMovie(movie: Movie): void {
    this.moviesList.update(movie);
  }

  deleteMovie(movie: Movie): void {
    this.moviesList.deleteMovie(movie);
  }

  // goBack(): void {
  //   this.location.back();
  // }



}
