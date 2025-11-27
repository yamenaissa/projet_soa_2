import { Component, OnInit } from '@angular/core';
import { Chanson } from '../../model/chanson.model';
import { ActivatedRoute, Router } from '@angular/router';
import { ChansonService } from '../chanson.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Album } from '../../model/album.model';

@Component({
  selector: 'app-update-chanson',
  imports: [FormsModule, CommonModule],
  templateUrl: './update-chanson.component.html',
  styles: ``,
})
export class UpdateChansonComponent implements OnInit {
  currentChanson = new Chanson();
  albums!: Album[];
  updatedAlbId!: number;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private chansonService: ChansonService
  ) {}

  ngOnInit(): void {
  this.chansonService.listeAlbums().subscribe((albs: any) => {
    // ✅ L'API retourne directement un tableau!
    if (Array.isArray(albs)) {
      this.albums = albs;
    } else if (albs._embedded?.albums) {
      this.albums = albs._embedded.albums;
    }
    
    console.log('✅ Albums chargés:', this.albums);
    
    // Charger la chanson
    this.chansonService
      .consulterChanson(this.activatedRoute.snapshot.params['id'])
      .subscribe((chans) => {
        this.currentChanson = chans;
        this.updatedAlbId = this.currentChanson.album?.idAlb;
      });
  });
}

  updateChanson() {
    this.currentChanson.album = this.albums.find(
      (alb) => alb.idAlb == this.updatedAlbId
    )!;
    this.chansonService
      .updateChanson(this.currentChanson)
      .subscribe(chans => {
        this.router.navigate(['chansons']);
      });
  }
}
