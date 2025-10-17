import { Routes } from '@angular/router';
import { IndexComponent } from './pages/index/index.component';
import { CrearRecetaComponent } from './pages/crear-receta/crear-receta.component';
import { DetalleRecetaComponent } from './pages/detalle-receta/detalle-receta.component';

export const routes: Routes = [
  { path: '', component: IndexComponent },
  { path: 'crear', component: CrearRecetaComponent },
  { path: 'receta/:id', component: DetalleRecetaComponent },
                              ];
