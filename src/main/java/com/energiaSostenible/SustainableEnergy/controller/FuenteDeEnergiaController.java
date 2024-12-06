
package com.energiaSostenible.SustainableEnergy.controller;

import com.energiaSostenible.SustainableEnergy.model.FuenteDeEnergia;
import com.energiaSostenible.SustainableEnergy.service.FuenteDeEnergiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fuentes")
public class FuenteDeEnergiaController {

    @Autowired
    private FuenteDeEnergiaService fuenteDeEnergiaService;

    // Obtener todas las fuentes de energía
    @GetMapping
    public List<FuenteDeEnergia> getAllFuentes() {
        return fuenteDeEnergiaService.getAllFuentesDeEnergia();
    }

    // Obtener una fuente de energía por ID
    @GetMapping("/{id}")
    public ResponseEntity<FuenteDeEnergia> getFuenteById(@PathVariable Long id) {
        return fuenteDeEnergiaService.getFuenteDeEnergiaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
