package cl.pasteleriamilsabores.backend.dto;

public class LoginResponse {
    private String id;
    private String nombre;
    private String email;
    private String token;

    // NUEVOS CAMPOS
    private String fechaNacimiento;
    private String telefono;
    private boolean esEstudianteDuoc;
    private boolean recibirNewsletter;

    public LoginResponse(String id, String nombre, String email, String token,
                         String fechaNacimiento, String telefono,
                         boolean esEstudianteDuoc, boolean recibirNewsletter) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.token = token;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.esEstudianteDuoc = esEstudianteDuoc;
        this.recibirNewsletter = recibirNewsletter;
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getToken() { return token; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public String getTelefono() { return telefono; }
    public boolean isEsEstudianteDuoc() { return esEstudianteDuoc; }
    public boolean isRecibirNewsletter() { return recibirNewsletter; }
}