package cl.pasteleriamilsabores.backend.dto;

public class LoginResponse {
    private String id;
    private String nombre;
    private String email;
    private String token;

    public LoginResponse(String id, String nombre, String email, String token) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.token = token;
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getToken() { return token; }
}