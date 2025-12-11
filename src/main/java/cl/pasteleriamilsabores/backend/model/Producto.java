package cl.pasteleriamilsabores.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    private String id;
    private String nombre;
    private int precio;
    private String categoria;     // Nuevo campo
    private String descripcion;
    private String imagen;        // Coincide con Android (pero debe ser String)
    private boolean personalizable; // Nuevo campo (coincide con Android)

    public Producto() {}

    public Producto(String id, String nombre, int precio, String categoria, String descripcion, String imagen, boolean personalizable) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.personalizable = personalizable;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }

    public boolean isPersonalizable() { return personalizable; }
    public void setPersonalizable(boolean personalizable) { this.personalizable = personalizable; }
}