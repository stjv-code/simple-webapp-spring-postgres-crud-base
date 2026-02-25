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
