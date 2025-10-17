package com.recetas.app.recetas;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
// import java.util.List;
// import java.util.Optional;

@Repository
public interface RecetaRepository extends JpaRepository<RecetaModel, Long> {

    // Optional<RecetaModel> PostMapping(RecetaModel recetaModel);

    // Optional<RecetaModel> Post(RecetaModel recetaModel);

    //  // 🔹 find
    //  @Query(value = "SELECT * FROM RECETAS ", nativeQuery = true)
    //  List<RecetaModel> findAll();

    // 🔹 Buscar por nombre (SQL real)
    // @Query(value = "SELECT * FROM RECETAS WHERE NOMBRE LIKE %:nombre%", nativeQuery = true)
    // List<RecetaModel> buscarPorNombre(@Param("nombre") String nombre);

    // // 🔹 Buscar por categoría exacta
    // @Query(value = "SELECT * FROM RECETAS WHERE CATEGORIA = :categoria", nativeQuery = true)
    // List<RecetaModel> buscarPorCategoria(@Param("categoria") String categoria);

    // // 🔹 Buscar recetas con tiempo menor a cierto valor
    // @Query(value = "SELECT * FROM RECETAS WHERE TIEMPO_PREPARACION < :minutos", nativeQuery = true)
    // List<RecetaModel> buscarPorTiempo(@Param("minutos") int minutos);

    // // 🔹 Buscar recetas con varias condiciones (nombre, categoría, tiempo)
    // @Query(value = """
    //     SELECT * FROM RECETAS
    //     WHERE (:nombre IS NULL OR NOMBRE LIKE %:nombre%)
    //     AND (:categoria IS NULL OR CATEGORIA = :categoria)
    //     AND (:maxTiempo IS NULL OR TIEMPO_PREPARACION <= :maxTiempo)
    //     ORDER BY TIEMPO_PREPARACION ASC
    //     """, nativeQuery = true)
    // List<RecetaModel> buscarAvanzado(
    //     @Param("nombre") String nombre,
    //     @Param("categoria") String categoria,
    //     @Param("maxTiempo") Integer maxTiempo
    // );
}
