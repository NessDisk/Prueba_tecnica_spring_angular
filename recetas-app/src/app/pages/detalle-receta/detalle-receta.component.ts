import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { RecetaService } from '../../services/receta.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-detalle-receta',
  standalone: true,
  imports: [CommonModule, RouterLink, FormsModule],
  templateUrl: './detalle-receta.component.html',
  styleUrls: ['./detalle-receta.component.scss']
})
export class DetalleRecetaComponent implements OnInit {
  receta: any = null; // Aquí guardaremos la receta cargada
  id!: number;
  editMode = false;
  constructor(
    private route: ActivatedRoute,
    private recetaService: RecetaService
  ) {}

  ngOnInit() {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    this.cargarReceta();
  }

  cargarReceta() {
    this.recetaService.getReceta(this.id).subscribe({
      next: (data) => {
        this.receta = data;
        console.log('Receta cargada:', this.receta);
      },
      error: (err) => {
        console.error('Error al obtener receta', err);
      },
    });
  }

  habilitarEdicion() {
    this.editMode = true;
  }

  cancelarEdicion() {
    this.editMode = false;
    this.cargarReceta(); // recarga la receta original por si se cambió algo
  }

  Eliminar() {
    this.recetaService.eliminarReceta(this.id).subscribe({
      next: () => {
        alert('Receta eliminada');
      },
      error: (err) => {
        console.error('Error al eliminar receta', err);
        alert('No se pudo eliminar la receta');
      },
    });
  }

  actualizarReceta() {
    this.recetaService.actualizarReceta(this.id, this.receta).subscribe({
      next: () => {
        alert('Receta actualizada correctamente ✅');
        this.editMode = false;
      },
      error: (err) => {
        console.error('Error al actualizar receta', err);
        alert('No se pudo actualizar la receta');
      },
    });
  }

}
