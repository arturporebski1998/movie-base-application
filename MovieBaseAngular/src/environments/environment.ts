import { HttpHeaders } from '@angular/common/http';

export const environment = {
  production: false,
  httpUsers: 'http://localhost:8080/users',
  httpMovies: 'http://localhost:8080/movies',
  httpOptions: {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

};

