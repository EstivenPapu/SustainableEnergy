
package com.energiaSostenible.SustainableEnergy.service;

import com.energiaSostenible.SustainableEnergy.model.FuenteDeEnergia;
import com.energiaSostenible.SustainableEnergy.repository.FuenteDeEnergiaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuenteDeEnergiaService {
    
    @Autowired
    private FuenteDeEnergiaRepository fuenteDeEnergiaRepository;
    
    public List<FuenteDeEnergia> getAllFuentesDeEnergia() {
        return fuenteDeEnergiaRepository.findAll();
    }

    public Optional<FuenteDeEnergia> getFuenteDeEnergiaById(Long id) {
        return fuenteDeEnergiaRepository.findById(id);
    }

}
