import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { AuthenticationService } from '../authentication-service/authentication.service';
import { MovieService } from '../movie-service/movie.service';
import { UserRegistrationService } from '../user-registration-service/user-registration.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor {

  constructor(
    //    pola prywatne
    public auth: AuthenticationService,
    public movieService: MovieService,
    public userService: UserRegistrationService
  ) { }

  intercept(request: HttpRequest<any>, next: HttpHandler) {

    request = request.clone({
      setHeaders: {
        Authorization: `Bearer ${this.auth.getToken()}`
      }
    });


    return next.handle(request);
  }
}