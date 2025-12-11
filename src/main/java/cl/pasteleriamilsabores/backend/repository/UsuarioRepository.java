package cl.pasteleriamilsabores.backend.repository;

import cl.pasteleriamilsabores.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    // Método mágico: Spring crea la consulta SQL basado en el nombre
    Optional<Usuario> findByEmail(String email);
}