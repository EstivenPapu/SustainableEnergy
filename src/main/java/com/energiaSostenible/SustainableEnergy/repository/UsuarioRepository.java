
package com.energiaSostenible.SustainableEnergy.repository;

import com.energiaSostenible.SustainableEnergy.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
