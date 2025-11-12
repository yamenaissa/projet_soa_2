import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Album } from '../model/album.model';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-update-album',
  imports: [FormsModule],
  templateUrl: './update-album.component.html',
  styles: ``,
})
export class UpdateAlbumComponent implements OnInit {
  @Input()
  album!: Album;

  @Input()
  ajout!: boolean;

  @Output()
  albumUpdated = new EventEmitter<Album>();

  constructor() {}

  ngOnInit(): void {
    console.log('ngOnInit album =', this.album);
  }

  saveAlbum() {
     if (this.ajout) {
      // Adding new album: remove ID
      const newAlbum: Album = {
        idAlb: 0,
        nomAlb: this.album.nomAlb,
        descriptionAlb: ''
      };
      this.albumUpdated.emit(newAlbum);
    } else {
      // Editing existing album: keep the ID
      this.albumUpdated.emit(this.album);
    }

  }
}
