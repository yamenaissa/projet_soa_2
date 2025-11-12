import { CommonModule, DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Chanson } from '../model/chanson.model';
import { ChansonService } from '../services/chanson.service';
import { SearchFilterPipe } from '../search-filter.pipe';

@Component({
  selector: 'app-recherche-par-nom',
  imports: [DatePipe, FormsModule, CommonModule, SearchFilterPipe],
  templateUrl: './recherche-par-nom.component.html',
  styles: ``,
})
export class RechercheParNomComponent implements OnInit {
  titre!: string;
  chansons!: Chanson[];
  allChansons!: Chanson[];
  searchTerm!: string;
  constructor(private chansonService: ChansonService) {}

  ngOnInit(): void {
    this.chansonService.listeChansons().subscribe((chans) => {
      this.chansons = chans;
      console.log(chans);
    });
  }

  onKeyUp(filterText: string) {
    if (!this.allChansons) return; // avoid errors if list not loaded yet
    this.chansons = this.allChansons.filter((item) =>
      item.titreChanson?.toLowerCase().includes(filterText.toLowerCase())
    );
  }

  rechercherChans() {
    if (this.titre) {
      if (!this.titre || this.titre.trim() === '') return; // avoid empty searches
      this.chansonService.rechercherParNom(this.titre.trim()).subscribe(
        (chans) => {
          this.chansons = chans;
          console.log(this.chansons);
        },
        (err) => console.error(err)
      );
    } else {
      this.chansonService.listeChansons().subscribe((chans) => {
        this.chansons = chans;
      });
    }
  }
}
