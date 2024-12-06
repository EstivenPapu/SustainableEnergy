
package com.energiaSostenible.SustainableEnergy.repository;

import com.energiaSostenible.SustainableEnergy.model.ProduccionEnergetica;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProduccionEnergeticaRepository extends JpaRepository<ProduccionEnergetica, Long>{
  
    
    @Query("SELECT p.fuenteDeEnergia.nombre AS fuente, SUM(p.produccion) AS total, p.pais " +
           "FROM ProduccionEnergetica p " +
           "WHERE p.year = :year " +
           "GROUP BY p.fuenteDeEnergia.nombre, p.pais")
    List<Object[]> obtenerProduccionPorFuenteYRegion(@Param("year") String year);

    // 2. Porcentaje de energía renovable en el consumo total de cada región
    @Query("SELECT p.pais, SUM(p.produccion) AS energiaRenovable, " +
           " (SUM(p.produccion) / :consumoTotal) * 100 AS porcentaje " +
           "FROM ProduccionEnergetica p " +
           "WHERE p.year = :year " +
           "GROUP BY p.pais")
    List<Object[]> calcularPorcentajeEnergiaRenovable(@Param("year") String year, @Param("consumoTotal") Double consumoTotal);

    // 3. Tendencia de capacidad instalada de energía solar a lo largo de los años
    @Query("SELECT p.year, SUM(p.produccion) " +
           "FROM ProduccionEnergetica p " +
           "WHERE p.fuenteDeEnergia.nombre = 'Solar' " +
           "GROUP BY p.year ORDER BY p.year ASC")
    List<Object[]> obtenerTendenciaCapacidadSolar();

    // 4. Top 10 países con mayor producción de energía eólica en un año
    @Query("SELECT p.pais, SUM(p.produccion) AS total " +
           "FROM ProduccionEnergetica p " +
           "WHERE p.year = :year AND p.fuenteDeEnergia.nombre = 'Eólica' " +
           "GROUP BY p.pais ORDER BY total DESC")
    List<Object[]> obtenerTop10PaisesEolica(@Param("year") String year);

    // 5. Listar todas las fuentes y su participación global
    @Query("SELECT p.fuenteDeEnergia.nombre, SUM(p.produccion) AS total, " +
           "(SUM(p.produccion) / (SELECT SUM(p2.produccion) FROM ProduccionEnergetica p2)) * 100 AS participacion " +
           "FROM ProduccionEnergetica p " +
           "GROUP BY p.fuenteDeEnergia.nombre")
    List<Object[]> listarFuentesYPaticipacion();
    
}