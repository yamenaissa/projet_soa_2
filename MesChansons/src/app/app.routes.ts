import { Routes } from '@angular/router';
import { ChansonsComponent } from './chansons/chansons.component';
import { AddChansonComponent } from './add-chanson/add-chanson.component';
import { UpdateChansonComponent } from './services/update-chanson/update-chanson.component';
import { RechercheParAlbumComponent } from './recherche-par-album/recherche-par-album.component';
import { RechercheParNomComponent } from './recherche-par-nom/recherche-par-nom.component';
import { ListeAlbumsComponent } from './liste-albums/liste-albums.component';
import { LoginComponent } from './login/login.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { chansonGuard } from './chanson.guard';
import { RegisterComponent } from './register/register.component';
import { VerifEmailComponent } from './verif-email/verif-email.component';

export const routes: Routes = [
  { path: '', redirectTo: 'chansons', pathMatch: 'full' },
  { path: 'chansons', component: ChansonsComponent },
  { path: 'add-chanson', component: AddChansonComponent, canActivate: [chansonGuard] },
  { path: 'updateChanson/:id', component: UpdateChansonComponent },
  { path: 'rechercheParAlbum', component: RechercheParAlbumComponent },
  { path: 'rechercheParNom', component: RechercheParNomComponent },
  { path: 'listeAlbums', component: ListeAlbumsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'app-forbidden', component: ForbiddenComponent },
  {path:'register',component:RegisterComponent},
   { path: 'verifEmail', component: VerifEmailComponent }
];
