import { Component, OnInit } from '@angular/core';
import { Album } from '../model/album.model';
import { ChansonService } from '../services/chanson.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UpdateAlbumComponent } from '../update-album/update-album.component';

@Component({
  selector: 'app-liste-albums',
  imports: [CommonModule, FormsModule, UpdateAlbumComponent],
  templateUrl: './liste-albums.component.html',
  styles: ``,
})
export class ListeAlbumsComponent implements OnInit {
  albums!: Album[];

  updatedAlb: Album = { idAlb: 0, nomAlb: '', descriptionAlb: '' };

  ajout: boolean = true;

  constructor(private chansonService: ChansonService) {}

  ngOnInit(): void {
    this.chargerAlbums();
  }

  chargerAlbums() {
    this.chansonService.listeAlbums().subscribe((albs: any) => {
      if (albs._embedded && albs._embedded.albums) {
        this.albums = albs._embedded.albums;
      } else {
        this.albums = albs;
      }
      console.log('Albums:', this.albums);
    });
  }

  updateAlb(alb: Album) {
    this.updatedAlb = alb;
    this.ajout = false;
  }
  albumUpdated(alb: Album) {
  if (this.ajout) {
    // ✅ AJOUT
    const albumToAdd = {
      nomAlb: alb.nomAlb,
      descriptionAlb: alb.descriptionAlb || '',
    };
    this.chansonService.ajouterAlbum(albumToAdd as Album).subscribe({
      next: () => {
        this.chargerAlbums();
        this.updatedAlb = { idAlb: 0, nomAlb: '', descriptionAlb: '' };
      },
      error: (err) => console.error('❌', err),
    });
  } else {
    // ✅ MODIFICATION - Corriger le nom de la méthode
    this.chansonService.updateAlbum(alb).subscribe({  // ← ICI!
      next: () => {
        this.chargerAlbums();
        this.updatedAlb = { idAlb: 0, nomAlb: '', descriptionAlb: '' };
        this.ajout = true;
      },
      error: (err: any) => console.error('❌', err),
    });
  }
}
}
