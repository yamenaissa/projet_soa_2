import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Chanson } from '../model/chanson.model';
import { ChansonService } from '../services/chanson.service';
import { Album } from '../model/album.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-chanson',
  imports: [FormsModule],
  templateUrl: './add-chanson.component.html',
})
export class AddChansonComponent implements OnInit {
  newChanson = new Chanson();

  albums!: Album[];
  newAlbum!: Album;
  newIdAlb!: number;

  constructor(private chansonService: ChansonService, private router: Router) {}

  ngOnInit(): void {
  this.chansonService.listeAlbums().subscribe((albs: any) => {
    if (Array.isArray(albs)) {
      this.albums = albs;
    } else if (albs._embedded?.albums) {
      this.albums = albs._embedded.albums;
    }
    console.log('Albums:', this.albums);
  });
}

  addChanson() {
    this.newChanson.album = this.albums.find(alb => alb.idAlb == this.newIdAlb)!;
    this.chansonService.ajouterChanson(this.newChanson).subscribe((chans) => {
      console.log(chans);
      this.router.navigate(['chansons']);
    });
  }
}
