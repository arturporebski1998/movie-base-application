import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { MoviesComponent } from './movies/movies.component';
import { MovieDetailComponent } from './movie-detail/movie-detail.component';
import { MessagesComponent } from './messages/messages.component';
import { AppRoutingModule } from './app-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HttpClientModule } from '@angular/common/http'
import { MovieSearchComponent } from './movie-search/movie-search.component';
import { MovieService } from './movie.service';
import { SearchDeleteComponent } from './search-delete/search-delete.component';
import { MoviesListComponent } from './movies-list/movies-list.component';
import { MovieAddComponent } from './movie-add/movie-add.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule


  ],
  declarations: [
    AppComponent,
    DashboardComponent,
    MoviesComponent,
    MovieDetailComponent,
    MessagesComponent,
    MovieSearchComponent,
    SearchDeleteComponent,
    MoviesListComponent,
    MovieAddComponent
  ],
  providers: [ MovieService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }