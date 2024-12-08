
package com.energiaSostenible.SustainableEnergy.controller;

import com.energiaSostenible.SustainableEnergy.model.Usuario;
import com.energiaSostenible.SustainableEnergy.service.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

     @GetMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Verifica si el usuario existe y la contraseña es correcta
        Usuario usuario = usuarioService.verificarUsuario(username, password);
        if (usuario != null) {
            // Si existe el usuario, devolvemos la información completa del usuario en formato JSON
            return "{ \"status\": \"Y\", \"Id\": " + usuario.getId() + " }";
        } else {
            // Si no existe el usuario o la contraseña no es válida, devolvemos "N"
            return "{ \"status\": \"N\" }";
        }
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping
    public Usuario saveUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveOrUpdateUsuario(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuarioParcial(@PathVariable Long id, @RequestBody Map<String, Object> actualizaciones) {
        Usuario usuarioActualizado = usuarioService.updateUsuario(id, actualizaciones);
        return ResponseEntity.ok(usuarioActualizado);
    }
    
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }
}
