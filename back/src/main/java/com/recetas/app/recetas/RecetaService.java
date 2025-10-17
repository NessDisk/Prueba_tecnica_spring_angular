package com.recetas.app.recetas;
import  com.recetas.app.recetas.RecetaModel;
import  org.springframework.stereotype.Service;
import  java.util.List;
import  java.util.Optional;

@Service
public class RecetaService {

    private final RecetaRepository recetaRepository;

    // Se usa la inyeccion de dependencias para captar el repositorio
    public RecetaService(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }

    public List<RecetaModel> getAllRecetas() {
        return recetaRepository.findAll();
    }
    public Optional<RecetaModel> getById(long id) {
        return recetaRepository.findById(id);
    }
    
    public void Post(RecetaModel recetaModel) {
            recetaRepository.save(recetaModel);
            return ;
    }
    
    public RecetaModel update( RecetaModel recetaActualizada) {
        // consigue la receta
        RecetaModel receta = recetaRepository.findById(recetaActualizada.getId())
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));
        // setea los datos
        receta.setNombre(recetaActualizada.getNombre());
        receta.setDescripcion(recetaActualizada.getDescripcion());
        receta.setCategoria(recetaActualizada.getCategoria());
        receta.setTiempoPreparacion(recetaActualizada.getTiempoPreparacion());
        // elemento actualizado 
        return recetaRepository.save(receta);    
    }

    
    public String delete( long id) {
        recetaRepository.deleteById(id);
        return "la receta fue  eliminada";
    }

}