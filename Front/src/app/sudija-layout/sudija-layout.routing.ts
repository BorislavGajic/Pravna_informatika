import {Routes} from '@angular/router';
import { SudijaNovaPresudaComponent } from '../sudija-nova-presuda/sudija-nova-presuda.component';
import { SudijaPresudeComponent } from '../sudija-presude/sudija-presude.component';
import {SudijaProfilComponent} from '../sudija-profil/sudija-profil.component';
import { SudijaPresudaPrikazComponent } from '../sudija-presuda-prikaz/sudija-presuda-prikaz.component';

export const SudijaLayoutRutes: Routes = [
  { path: 'profilSudija',      component: SudijaProfilComponent },
  { path: 'presudeSudija',      component: SudijaPresudeComponent },
  { path: 'novaPresudaSudija',  component: SudijaNovaPresudaComponent },
  { path: 'prikazPresude/:id', component: SudijaPresudaPrikazComponent},

];
