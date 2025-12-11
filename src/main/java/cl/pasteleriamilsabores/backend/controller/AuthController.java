package cl.pasteleriamilsabores.backend.controller;

import cl.pasteleriamilsabores.backend.dto.LoginRequest;
import cl.pasteleriamilsabores.backend.dto.LoginResponse;
import cl.pasteleriamilsabores.backend.dto.RegisterRequest;
import cl.pasteleriamilsabores.backend.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // POST /api/auth/login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            LoginResponse response = authService.login(request);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    // POST /api/auth/register
    @PostMapping("/register")
    // CAMBIO: Ahora recibimos RegisterRequest en vez de LoginRequest
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            LoginResponse response = authService.registrar(request);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}