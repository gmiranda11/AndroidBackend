package cl.pasteleriamilsabores.backend;

import cl.pasteleriamilsabores.backend.model.Producto;
import cl.pasteleriamilsabores.backend.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductoRepository productoRepository;

    public DataSeeder(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (productoRepository.count() == 0) {
            productoRepository.saveAll(Arrays.asList(
                    // id, nombre, precio, categoria, descripcion, imagen, personalizable
                    new Producto("1", "Torta de Mil Hojas", 15000, "Tortas", "Clásica torta de hojarasca y manjar", "milhojas", true),
                    new Producto("2", "Cheesecake Frutos Rojos", 18000, "Postres", "Base de galleta y queso crema suave", "cheesecake", false),
                    new Producto("3", "Tiramisú", 14000, "Postres", "Postre italiano con café y mascarpone", "tiramisu", false),
                    new Producto("4", "Pie de Limón", 12000, "Pasteles", "Merengue suizo y crema de limón", "pie_limon", false),
                    new Producto("5", "Torta Chocolate", 16500, "Tortas", "Bizcocho húmedo de chocolate", "mchocolate", true)
            ));
            System.out.println("--- DATOS DE PRUEBA CARGADOS EN MYSQL (SINCRONIZADOS CON ANDROID) ---");
        }
    }
}