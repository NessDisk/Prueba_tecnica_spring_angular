import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { RecetaService } from '../../services/receta.service';

@Component({
  selector: 'app-index',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit {
  recetas: any[] = [];

  constructor(private recetaService: RecetaService) {}

  ngOnInit() {
    console.log("llegue a receta");
    this.recetaService.getRecetas().subscribe({
      next: (data) => (this.recetas = data),
      error: (err) => console.error('Error al cargar recetas', err),
    });
  }
}
