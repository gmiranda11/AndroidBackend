package cl.pasteleriamilsabores.backend.service;

import cl.pasteleriamilsabores.backend.dto.*;
import cl.pasteleriamilsabores.backend.model.Usuario;
import cl.pasteleriamilsabores.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public LoginResponse login(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!usuario.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        // CAMBIO: Ahora enviamos todos los datos de vuelta
        return new LoginResponse(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                "token_dummy_123",
                usuario.getFechaNacimiento(), // Dato real
                usuario.getTelefono(),        // Dato real
                usuario.isEsEstudianteDuoc(), // Dato real
                usuario.isRecibirNewsletter() // Dato real
        );
    }

    // En AuthService.java
    // CAMBIO: El parámetro ahora es RegisterRequest
    public LoginResponse registrar(RegisterRequest request) {
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("El email ya está registrado");
        }

        String nuevoId = UUID.randomUUID().toString();

        // AHORA SÍ: Usamos los datos reales que vienen del objeto 'request'
        Usuario nuevoUsuario = new Usuario(
                nuevoId,
                request.getNombre(),          // Nombre real
                request.getEmail(),
                request.getPassword(),
                request.getFechaNacimiento(), // Fecha real
                request.getTelefono(),        // Teléfono real
                request.isEsEstudianteDuoc(), // Boolean real
                request.isRecibirNewsletter() // Boolean real
        );

        usuarioRepository.save(nuevoUsuario);

        return new LoginResponse(
                nuevoId,
                nuevoUsuario.getNombre(),
                nuevoUsuario.getEmail(),
                "token_nuevo_456",
                nuevoUsuario.getFechaNacimiento(),
                nuevoUsuario.getTelefono(),
                nuevoUsuario.isEsEstudianteDuoc(),
                nuevoUsuario.isRecibirNewsletter()
        );
    }
}