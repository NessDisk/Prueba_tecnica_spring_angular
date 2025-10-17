import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { RecetaService } from '../../services/receta.service';
import { CardComponent } from '../../shared/card/card.component';
@Component({
  selector: 'app-index',
  standalone: true,
  imports: [CommonModule, RouterLink, CardComponent],
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit {
  recetas: any[] = [];

  constructor(private recetaService: RecetaService) {}

  ngOnInit() {
    console.log("llegue a receta");
    this.recetaService.getRecetas().subscribe({
      next: (data) => {this.recetas = data;
        console.log('Recetas cargadas:', this.recetas);

      },
      error: (err) => console.error('Error al cargar recetas', err),
    });
    console.log(this.recetas);

  }
}
