package com.recetas.app.recetas;
import  com.recetas.app.recetas.RecetaModel;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/recetas")
@CrossOrigin(origins = "*") // permite llamadas desde el front (Angular)
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
    public String  crearReceta(@RequestBody RecetaModel receta) {
        recetaService.Post(receta);
        return "receta creada";
    }

    @PutMapping
    public String  actualizarReceta(@RequestBody RecetaModel receta) {
        recetaService.update(receta);
        return "receta creada";
    }

    @DeleteMapping("/{id}")
    public String  EliminarReceta(@PathVariable int id) {
        recetaService.delete(id);
        return "receta fue eleminada";
    }


}