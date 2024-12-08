
package com.energiaSostenible.SustainableEnergy.service;

import com.energiaSostenible.SustainableEnergy.model.Usuario;
import com.energiaSostenible.SustainableEnergy.repository.UsuarioRepository;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public Optional<Usuario> getUsuarioById(Long id){
        return usuarioRepository.findById(id);
    }
    
    public Usuario saveOrUpdateUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
    
    public Usuario updateUsuario(Long id, Map<String, Object> actualizaciones) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Actualiza solo los campos enviados en el JSON
        if (actualizaciones.containsKey("nombre")) {
            usuario.setNombre((String) actualizaciones.get("nombre"));
        }
        if (actualizaciones.containsKey("email")) {
            usuario.setEmail((String) actualizaciones.get("email"));
        }
        if (actualizaciones.containsKey("password")) {
            usuario.setPassword((String) actualizaciones.get("password"));
        }
         if (actualizaciones.containsKey("username")) {
            usuario.setUsername((String) actualizaciones.get("username"));
        }

        // Guarda los cambios
        return usuarioRepository.save(usuario);
    }
    
     public Usuario verificarUsuario(String username, String password) {
        // Buscar usuario por nombre de usuario
        Usuario usuario = usuarioRepository.findByUsername(username);
        
        // Verificar si la contraseña es correcta
        if (usuario != null && usuario.getPassword().equals(password)) {
            return usuario;
        }
        return null; // Si no se encuentra el usuario o la contraseña es incorrecta
    }
}
