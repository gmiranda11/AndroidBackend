package cl.pasteleriamilsabores.backend.service;

import cl.pasteleriamilsabores.backend.model.Producto;
import cl.pasteleriamilsabores.backend.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    
    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> obtenerTodos() {
        return repository.findAll(); // SELECT * FROM productos
    }

    public Producto obtenerPorId(String id) {
        return repository.findById(id).orElse(null); // SELECT * FROM productos WHERE id = ?
    }
}