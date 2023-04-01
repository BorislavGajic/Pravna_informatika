import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SudijaServiceService } from '../services/sudija-service.service';

@Component({
  selector: 'app-sudija-nova-presuda',
  templateUrl: './sudija-nova-presuda.component.html',
  styleUrls: ['./sudija-nova-presuda.component.css']
})
export class SudijaNovaPresudaComponent implements OnInit {

  constructor(private router: Router, private sudijaService: SudijaServiceService) { }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  logout() {
    localStorage.removeItem('currentuser');
    this.router.navigate(['/']);

  }

}
