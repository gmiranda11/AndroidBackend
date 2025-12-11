package cl.pasteleriamilsabores.backend.dto;

public class RegisterRequest {
    private String nombre;
    private String email;
    private String password;
    private String fechaNacimiento;
    private String telefono;
    private boolean esEstudianteDuoc;
    private boolean recibirNewsletter;

    // Getters y Setters
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