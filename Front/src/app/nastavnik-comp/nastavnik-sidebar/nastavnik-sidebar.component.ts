import { Component, OnInit } from '@angular/core';
declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}

export const ROUTES: RouteInfo[] = [
  { path: '/nastavnik/nastavnikProfil', title: 'Profil',  icon: '', class: '' }
  // { path: '/nastavnik/nastavnikStanje', title: 'Stanje',  icon: '', class: '' },
];

@Component({
  selector: 'app-nastavnik-sidebar',
  templateUrl: './nastavnik-sidebar.component.html',
  styleUrls: ['./nastavnik-sidebar.component.css']
})
export class NastavnikSidebarComponent implements OnInit {

  menuItems: any[];
  constructor() { }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }

}
