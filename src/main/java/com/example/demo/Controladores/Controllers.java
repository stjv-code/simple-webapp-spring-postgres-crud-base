package com.example.demo.Controladores;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api")
public class Controllers {

    @PostMapping("/")
    public ResponseEntity<?> Post(@RequestBody DTOUser entity) {
        if (entity.getName() == null || entity.getName().trim().isEmpty() || entity.getName().length() > 20) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: El usuario no debe estar vacio ni ser mayor a 20 caracteres.");
        }
        if (entity.getPassword() == null || entity.getPassword().trim().isEmpty() || entity.getPassword().length() > 12) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: la contraseña no debe estar vacia ni ser mayor a 12 caracteres");
        }
        return ResponseEntity.ok("Guardado");
    }

    @GetMapping("/")
    public ResponseEntity<?> GetAll() {
        return ResponseEntity.ok("Todos los usuarios");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> Get(@PathVariable Long id) {
        return ResponseEntity.ok("Usuario independiente");
    }
    
}
