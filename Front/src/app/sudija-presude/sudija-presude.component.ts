import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SudijaServiceService } from '../services/sudija-service.service';

@Component({
  selector: 'app-sudija-presude',
  templateUrl: './sudija-presude.component.html',
  styleUrls: ['./sudija-presude.component.css']
})
export class SudijaPresudeComponent implements OnInit {

  constructor(private router: Router, private sudijaService: SudijaServiceService) { }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  logout() {
    localStorage.removeItem('currentuser');
    this.router.navigate(['/']);

  }

}
