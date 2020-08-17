import { Component, OnInit } from '@angular/core';
import { Movie } from '../movie';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from '../movie.service';
import { MoviesListComponent } from '../movies-list/movies-list.component';

interface Genre {
  value: string;
  viewValue: string;
}


@Component({
  selector: 'app-movie-add',
  templateUrl: './movie-add.component.html',
  styleUrls: ['./movie-add.component.css']
})
export class MovieAddComponent implements OnInit {

  movie: Movie = new Movie(0, '', '', '', 0, '', '');

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

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private movieService: MovieService,) {
    this.movie = new Movie(0, '', '', '', 0, '', '');
  }

  ngOnInit() {
  }

  saveMovie(): void {
    this.movieService.addMovie(this.movie).subscribe();
  }





}
