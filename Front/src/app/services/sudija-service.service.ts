import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SudijaServiceService {
  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:typedef
  registrujSudiju(user) {
    return this.http.post('http://localhost:8060/api/v1/korisnik', user,      {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
      responseType: 'text'
    });
  }

  // tslint:disable-next-line:typedef
  login(user) {
    return this.http.post('http://localhost:8060/api/v1/korisnik/login', user,      {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    });
  }

  // tslint:disable-next-line:typedef
  getUser(username) {
    return this.http.get('http://localhost:8060/api/v1/korisnik/' + username,      {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    });
  }

  // tslint:disable-next-line:typedef
  getPresude() {
    return this.http.get('http://localhost:8060/api/v1/presuda',      {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    });
  }
}
