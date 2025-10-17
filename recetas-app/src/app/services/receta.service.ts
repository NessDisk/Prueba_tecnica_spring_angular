import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecetaService {
  private baseUrl = 'http://localhost:8081/api/recetas';

  constructor(private http: HttpClient) {}

  // 🔹 Obtener todas las recetas
  getRecetas(): Observable<any[]> {
    console.log("llegue a receta");
    return this.http.get<any[]>(this.baseUrl);
  }

  // 🔹 Obtener receta por ID
  getReceta(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/${id}`);
  }

  // 🔹 Crear nueva receta
  crearReceta(receta: any): Observable<any> {
    console.log(receta);
    return this.http.post(this.baseUrl, receta);
  }

  // 🔹 Actualizar receta
  actualizarReceta(id: number, receta: any): Observable<any> {
    receta.id
    console.log(receta);
    return this.http.put(this.baseUrl, receta);
  }

  // 🔹 Eliminar receta
  eliminarReceta(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}
