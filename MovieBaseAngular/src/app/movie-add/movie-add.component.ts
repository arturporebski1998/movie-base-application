import { Component, OnInit } from '@angular/core';
import { Movie } from '../movie';
import { MovieService } from '../services/movie-service/movie.service';
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
	// private _
	movie: Movie = new Movie(0, '', '', '', 0, '', '');

	// To nie je enum xD
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
		private movieService: MovieService) {
		this.movie = new Movie(0, '', '', '', 0, '', '');
	}

	ngOnInit() {
	}

	// saveMovie a zaraz addMovie trzymaj się jednego
	saveMovie(): void {
		this.movieService.addMovie(this.movie).subscribe();
	}





}
