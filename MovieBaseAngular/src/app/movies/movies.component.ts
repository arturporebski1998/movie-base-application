import { Component, OnInit } from '@angular/core';
import { Movie } from '../movie';
import { MovieService } from '../services/movie-service/movie.service';
import { title } from 'process';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})

export class MoviesComponent implements OnInit {

  movie: Movie = new Movie(0, '', '', '', 0, '', '');

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private movieService: MovieService) {
    this.movie = new Movie(0, '', '', '', 0, '', '');
  }

  ngOnInit() {
  }














}