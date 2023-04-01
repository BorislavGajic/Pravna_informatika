import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {Router} from '@angular/router';
import {SudijaServiceService} from '../services/sudija-service.service';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-sudija-profil',
  templateUrl: './sudija-profil.component.html',
  styleUrls: ['./sudija-profil.component.css']
})
export class SudijaProfilComponent implements OnInit {
  sudija: any = [];
  korisnik: any = [];
  constructor(private formBuilder: FormBuilder, private router: Router, private sudijaService: SudijaServiceService) { }

  ngOnInit(): void {
    this.ucitajSudiju();
  }

  // tslint:disable-next-line:typedef
  ucitajSudiju() {
    this.sudijaService.getUser(localStorage.getItem('currentuser').toString())
      .pipe(first())
      .subscribe((data: {}) => {
          this.korisnik = data;
          this.sudija = this.korisnik;
        }
      );
  }

  // tslint:disable-next-line:typedef
  logout() {
    localStorage.removeItem('currentuser');
    this.router.navigate(['/']);

  }

}
