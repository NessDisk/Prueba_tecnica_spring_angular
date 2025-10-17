package com.recetas.app.recetas;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/recetas")
@CrossOrigin(origins = "*") // permite llamadas desde el front (Angular)
public class RecetaController {

    private List<Map<String, Object>> recetas = new ArrayList<>();

    // CREATE - POST
    @PostMapping
    public Map<String, Object> crearReceta(@RequestBody Map<String, Object> nuevaReceta) {
        nuevaReceta.put("id", recetas.size() + 1);
        recetas.add(nuevaReceta);
        return nuevaReceta;
    }

    // READ ALL - GET
    @GetMapping
    public List<Map<String, Object>> obtenerTodasLasRecetas() {
        return recetas;
    }

    // READ ONE - GET by ID
    @GetMapping("/{id}")
    public Map<String, Object> obtenerRecetaPorId(@PathVariable int id) {
        return recetas.stream()
                .filter(r -> (int) r.get("id") == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));
    }

    // UPDATE - PUT
    @PutMapping("/{id}")
    public Map<String, Object> actualizarReceta(
            @PathVariable int id,
            @RequestBody Map<String, Object> recetaActualizada) {
        Map<String, Object> receta = recetas.stream()
                .filter(r -> (int) r.get("id") == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));

        receta.putAll(recetaActualizada);
        receta.put("id", id);
        return receta;
    }

    // DELETE - DELETE
    @DeleteMapping("/{id}")
    public String eliminarReceta(@PathVariable int id) {
        boolean eliminada = recetas.removeIf(r -> (int) r.get("id") == id);
        if (!eliminada) {
            throw new RuntimeException("Receta no encontrada");
        }
        return "Receta eliminada correctamente";
    }
}