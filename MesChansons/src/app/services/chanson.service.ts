import { Injectable } from '@angular/core';
import { Chanson } from '../model/chanson.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Album } from '../model/album.model';
import { environment } from '../../environments/environment';
import { AlbumWrapper } from '../model/albumWrapped.model';
import { AuthService } from './auth.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class ChansonService {
  aiURLAlbum: string = environment.apiURL + '/alb';

  chansons: Chanson[] = [];

  constructor(private http: HttpClient, private authService: AuthService) {
    console.log('Environment:', environment);
  }

  listeChansons(): Observable<Chanson[]> {
    return this.http.get<Chanson[]>(environment.apiURL + '/all');
  }

  ajouterChanson(chans: Chanson): Observable<Chanson> {
    return this.http.post<Chanson>(environment.apiURL + '/addchans', chans);
  }

  supprimerChanson(id: number) {
    const url = `${environment.apiURL}/delchans/${id}`;
    return this.http.delete(url);
  }

  consulterChanson(id: number): Observable<Chanson> {
    const url = `${environment.apiURL}/getbyid/${id}`;

    return this.http.get<Chanson>(url);
  }

  updateChanson(chans: Chanson): Observable<Chanson> {
    return this.http.put<Chanson>(environment.apiURL + '/updatechans', chans);
  }

  listeAlbums(): Observable<AlbumWrapper> {
    return this.http.get<AlbumWrapper>(this.aiURLAlbum);
  }

  rechercheParAlbum(idAlb: number): Observable<Chanson[]> {
    const url = `${environment.apiURL}/chansAlb/${idAlb}`;
    return this.http.get<Chanson[]>(url);
  }

  rechercherParNom(nom: string): Observable<Chanson[]> {
    const url = `${environment.apiURL}/chansByName/${nom}`;
    return this.http.get<Chanson[]>(url);
  }

  ajouterAlbum(alb: Album): Observable<Album> {
    return this.http.post<Album>(this.aiURLAlbum, alb, httpOptions);
  }

  updateAlbum(alb: Album): Observable<Album> {
    return this.http.put<Album>(this.aiURLAlbum, alb, httpOptions);
  }
}
