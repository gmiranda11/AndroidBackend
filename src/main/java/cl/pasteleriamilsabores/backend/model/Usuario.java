package cl.pasteleriamilsabores.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    private String id;
    private String nombre;
    private String email;
    private String password;

    // Nuevos campos para sincronizar con Android
    private String fechaNacimiento;
    private String telefono;
    private boolean esEstudianteDuoc;
    private boolean recibirNewsletter;

    public Usuario() {}

    public Usuario(String id, String nombre, String email, String password, String fechaNacimiento, String telefono, boolean esEstudianteDuoc, boolean recibirNewsletter) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.esEstudianteDuoc = esEstudianteDuoc;
        this.recibirNewsletter = recibirNewsletter;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public boolean isEsEstudianteDuoc() { return esEstudianteDuoc; }
    public void setEsEstudianteDuoc(boolean esEstudianteDuoc) { this.esEstudianteDuoc = esEstudianteDuoc; }

    public boolean isRecibirNewsletter() { return recibirNewsletter; }
    public void setRecibirNewsletter(boolean recibirNewsletter) { this.recibirNewsletter = recibirNewsletter; }
}