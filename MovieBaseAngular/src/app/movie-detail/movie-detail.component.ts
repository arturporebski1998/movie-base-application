import { Component, OnInit, Input } from '@angular/core';
import { Movie } from '../movie';
import { Location } from '@angular/common';
import { MovieService } from '../movie.service';
import { MoviesListComponent } from '../movies-list/movies-list.component';
import { ActivatedRoute, Router } from '@angular/router';

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
    private route: ActivatedRoute,
    private movieService: MovieService,
    private location: Location,
    private moviesList: MoviesListComponent,
    private router: Router, 
  ) {}

  genres: Genre[] = [
    {value: 'Action', viewValue: 'Action'},
    {value: 'Adventure', viewValue: 'Adventure'},
    {value: 'Comedy', viewValue: 'Comedy'},
    {value: 'Fantasy', viewValue: 'Fantasy'},
    {value: 'Horror', viewValue: 'Horror'},
    {value: 'Mystery', viewValue: 'Mystery'},
    {value: 'Romance', viewValue: 'Romance'},
    {value: 'Thriller', viewValue: 'Thriller'},
    {value: 'Western', viewValue: 'Western'},
    {value: 'Scifi', viewValue: 'Sci-Fi'},
    {value: 'History', viewValue: 'History'}
  ];

  

  ngOnInit(): void {
    this.getMovie();
  } 

  getMovie(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.movieService.getMovie(id)
      .subscribe(movie => this.movie = movie);
  }

  updateMovie(movie: Movie): void {
    this.moviesList.update(movie);
  }

  deleteMovie(movie: Movie): void {
    this.moviesList.deleteMovie(movie);
  }

  goBack(): void {
    this.location.back();
  }
  



}
