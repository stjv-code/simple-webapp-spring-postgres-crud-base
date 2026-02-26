package com.example.demo.Controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    private final UserRepository Repository;
    public Controllers(UserRepository Repository) {
        this.Repository = Repository;
    }

    @PostMapping("/")
    public ResponseEntity<?> Post(@RequestBody DTOUser entity) {

        if (Repository.existsByName(entity.getName())) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("Error: El nombre de usuario " + entity.getName() + " ya existe.");
        }

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

        User db = new User();
        db.setName(entity.getName());
        db.setPassword(entity.getPassword());

        User id = Repository.save(db);
        return ResponseEntity.ok("Guardado con ID: " + id.getId());
    }

    @GetMapping("/")
    public ResponseEntity<?> GetAll() {
        return ResponseEntity.ok(Repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> Get(@PathVariable Long id) {
        return Repository.findById(id)
            .map(user -> ResponseEntity.ok(user))
            .orElse(ResponseEntity.notFound().build());
    }
    
}
