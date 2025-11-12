import { Component, OnInit } from '@angular/core';
import { Chanson } from '../model/chanson.model';
import { CommonModule, DatePipe } from '@angular/common';
import { Album } from '../model/album.model';
import { FormsModule } from '@angular/forms';
import { ChansonService } from '../services/chanson.service';

@Component({
  selector: 'app-recherche-par-album',
  imports: [DatePipe,FormsModule,CommonModule],
  templateUrl: './recherche-par-album.component.html',
  styles: ``,
})
export class RechercheParAlbumComponent implements OnInit {
  chansons!: Chanson[];
  IdAlbum!: number;
  albums!: Album[];

  constructor(private chansonService:ChansonService) {}

  ngOnInit(): void {
    this.chansonService.listeAlbums().subscribe(albs => {
      this.albums = albs._embedded?.albums || albs;
    });
  }
  

  onChange() {
    this.chansonService.rechercheParAlbum(this.IdAlbum).subscribe(chanss => {
      this.chansons = chanss;
      console.log(this.chansons);
    });
  }
}
