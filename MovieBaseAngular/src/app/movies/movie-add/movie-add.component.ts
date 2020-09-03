import { Component, OnInit } from '@angular/core';
import { Movie } from 'src/app/movies/movie';
import { MovieService } from 'src/app/services/movie-service/movie.service';
import { Genres, Countries } from 'src/environments/environment';

@Component({
	selector: 'app-movie-add',
	templateUrl: './movie-add.component.html',
	styleUrls: ['./movie-add.component.css']
})
export class MovieAddComponent implements OnInit {

	private movie: Movie = new Movie(0, '', '', '', 0, '', '');

	genre = Genres;
	country = Countries;

	constructor(
		private movieService: MovieService) {
		this.movie = new Movie(0, '', '', '', 0, '', '');
	}

	ngOnInit() {
	}

	private addMovie(): void {
		this.movieService.addMovie(this.movie).subscribe();
	}





}
