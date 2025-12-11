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

        return new LoginResponse(usuario.getId(), usuario.getNombre(), usuario.getEmail(), "token_dummy_123");
    }

    public LoginResponse registrar(LoginRequest request) {
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("El email ya está registrado");
        }

        String nuevoId = UUID.randomUUID().toString();

        // Creamos el usuario con datos por defecto para los campos que no vienen en el LoginRequest básico
        // (O si quieres enviarlos desde Android, tendrías que actualizar el LoginRequest también)
        Usuario nuevoUsuario = new Usuario(
                nuevoId,
                "Nuevo Usuario",
                request.getEmail(),
                request.getPassword(),
                "", // fecha nacimiento vacía por defecto
                "", // teléfono vacío
                false, // no estudiante
                true   // newsletter sí
        );

        usuarioRepository.save(nuevoUsuario);

        return new LoginResponse(nuevoId, nuevoUsuario.getNombre(), nuevoUsuario.getEmail(), "token_nuevo_456");
    }
}