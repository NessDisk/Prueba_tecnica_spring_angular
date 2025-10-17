import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { RecetaService } from '../../services/receta.service';

@Component({
  selector: 'app-crear-receta',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './crear-receta.component.html',
  styleUrls: ['./crear-receta.component.scss']
})
export class CrearRecetaComponent {
  receta = {
    nombre: '',
    creatorName:'',
    urlImg:'',
    descripcion: '',
    categoria: '',
    tiempoPreparacion: 0
  };

  constructor(private recetaService: RecetaService, private router: Router) {}

  crearReceta() {
    if (!this.receta.nombre ||
       !this.receta.descripcion ||
        !this.receta.categoria ||
        !this.receta.creatorName ||
        !this.receta.urlImg

      ) {
      alert('Por favor, completa todos los campos');
      return;
    }

    this.recetaService.crearReceta(this.receta).subscribe({
      next: () => {
        alert('Receta creada con éxito 🍳');
        this.router.navigate(['/']);
      },
      error: (err) => {
        console.error('Error al crear la receta:', err);
        alert('Hubo un error al crear la receta');
      }
    });
  }
}
