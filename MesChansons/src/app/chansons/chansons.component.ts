import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Chanson } from '../model/chanson.model';
import { ChansonService } from '../services/chanson.service';
import { RouterLink } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-chansons',
  imports: [CommonModule, RouterLink],
  templateUrl: './chansons.component.html',
  styles: ``,
})
export class ChansonsComponent implements OnInit {
  chansons: Chanson[] = [];

  constructor(
    private chansonService: ChansonService,
    public authService: AuthService
  ) {
    //this.chansons = this.chansonService.listeChansons();
  }
  ngOnInit(): void {
    this.chargerChansons();
  }
  chargerChansons() {
    this.chansonService.listeChansons().subscribe((chanss) => {
      console.log(chanss);
      this.chansons = chanss;
    });
  }
  supprimerChanson(chans: Chanson) {
    let conf = confirm('Etes-vous sûr ?');
    if (conf)
      this.chansonService.supprimerChanson(chans.idChanson).subscribe(() => {
        console.log('Chanson supprimée');
        this.chargerChansons();
      });
  }
}
