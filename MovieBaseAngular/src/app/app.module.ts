import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { MoviesComponent } from './movies/movies.component';
import { MovieDetailComponent } from './movie-detail/movie-detail.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http'
import { MovieService } from './services/movie-service/movie.service';
import { MoviesListComponent } from './movies-list/movies-list.component';
import { MovieAddComponent } from './movie-add/movie-add.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './modules/material.module';
import { RegistrationComponent } from './registration/registration.component';
import { UserRegistrationService } from './services/user-registration-service/user-registration.service';
import { UsersListComponent } from './users-list/users-list.component';
import { DashboardComponent } from './dashboard/dashboard.component';


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,


  ],
  declarations: [
    AppComponent,
    DashboardComponent,
    MoviesComponent,
    MovieDetailComponent,
    UsersListComponent,
    MoviesListComponent,
    MovieAddComponent,
    RegistrationComponent,
  ],
  
  providers: [ MovieService, UserRegistrationService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }