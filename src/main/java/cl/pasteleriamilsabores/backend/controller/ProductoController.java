package cl.pasteleriamilsabores.backend.controller;

import cl.pasteleriamilsabores.backend.model.Producto;
import cl.pasteleriamilsabores.backend.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos") // <-- Esta es la ruta que busca Android
@CrossOrigin(origins = "*")       // <-- Permite que Android (o cualquiera) se conecte
public class ProductoController {

    private final ProductoService service;

    // Inyección de dependencias (Spring le pasa el servicio automáticamente)
    public ProductoController(ProductoService service) {
        this.service = service;
    }

    // GET /api/productos
    @GetMapping
    public List<Producto> listarProductos() {
        return service.obtenerTodos();
    }

    // GET /api/productos/{id}
    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable String id) {
        return service.obtenerPorId(id);
    }
}