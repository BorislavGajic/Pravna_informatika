import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SudijaServiceService } from '../services/sudija-service.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-sudija-presuda-prikaz',
  templateUrl: './sudija-presuda-prikaz.component.html',
  styleUrls: ['./sudija-presuda-prikaz.component.css']
})
export class SudijaPresudaPrikazComponent implements OnInit {
  tekstPresude: any = "";
  id: any = 0;
  constructor(private router: Router,private activatedRoute: ActivatedRoute, private sudijaService: SudijaServiceService) {

   }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(paramMap => { 
      this.id = paramMap.get('id'); 
      this.ucitajPresudu();
  });
    
  }

  ucitajPresudu() {
    this.sudijaService.getTekstPresude(this.id)
      .pipe(first())
      .subscribe((data: {}) => {
          this.tekstPresude = data;
        }
      );
  }

    // tslint:disable-next-line:typedef
    logout() {
      localStorage.removeItem('currentuser');
      this.router.navigate(['/']);
  
    }

}
