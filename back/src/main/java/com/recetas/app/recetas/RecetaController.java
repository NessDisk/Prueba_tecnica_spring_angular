package com.recetas.app.recetas;
import  com.recetas.app.recetas.RecetaModel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/recetas")
@CrossOrigin(origins = "http://localhost:4200")
public class RecetaController {

    private final RecetaService recetaService;

    public RecetaController(RecetaService recetaService) {
        this.recetaService = recetaService;
    }

    @GetMapping
    public List<RecetaModel> obtenerTodasLasRecetas() {
        return recetaService.getAllRecetas();
    }

    @GetMapping("/{id}")
    public Optional<RecetaModel> obtenerRecetaPorId(@PathVariable int id) {
        return recetaService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>>  crearReceta(@RequestBody RecetaModel receta) {
        recetaService.Post(receta);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Receta creada correctamente");

        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>>  actualizarReceta(@RequestBody RecetaModel receta) {
        recetaService.update(receta);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Receta actualizada correctamente");

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>>  EliminarReceta(@PathVariable int id) {
        recetaService.delete(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Receta eliminada correctamente");

        return ResponseEntity.ok(response);
    }


}