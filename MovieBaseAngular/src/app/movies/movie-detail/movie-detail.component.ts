import { Component, OnInit, Input } from '@angular/core';
import { MovieService } from 'src/app/services/movie-service/movie.service';
import { Movie } from 'src/app/movies/movie';
import { MoviesListComponent } from '../movies-list/movies-list.component';

interface Genre {
  value: string;
  viewValue: string;
}

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
  //  Gdzieś to już widziałem :?
  genres: Genre[] = [
    { value: 'Action', viewValue: 'Action' },
    { value: 'Adventure', viewValue: 'Adventure' },
    { value: 'Comedy', viewValue: 'Comedy' },
    { value: 'Fantasy', viewValue: 'Fantasy' },
    { value: 'Horror', viewValue: 'Horror' },
    { value: 'Mystery', viewValue: 'Mystery' },
    { value: 'Romance', viewValue: 'Romance' },
    { value: 'Thriller', viewValue: 'Thriller' },
    { value: 'Western', viewValue: 'Western' },
    { value: 'Scifi', viewValue: 'Sci-Fi' },
    { value: 'History', viewValue: 'History' }
  ];


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
