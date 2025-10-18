package controller;

import dto.AdministradorCreateDTO;
import dto.AdministradorResponseDTO;
import dto.AdministradorUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AdministradorService;

import java.util.List;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @GetMapping
    public ResponseEntity<List<AdministradorResponseDTO>>  findAll() {
        List<AdministradorResponseDTO> administrador = administradorService.findAll();
        return ResponseEntity.ok(administrador);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorResponseDTO> findById(@PathVariable int id) {
        AdministradorResponseDTO administrador = administradorService.findById(id);

        if (administrador == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(administrador);
    }

    @PostMapping
    public ResponseEntity<AdministradorResponseDTO> create(@RequestBody @Valid AdministradorCreateDTO novoAdministrador) {
        AdministradorResponseDTO adminstradorCriado = administradorService.create(novoAdministrador);
        return ResponseEntity.status(HttpStatus.CREATED).body(adminstradorCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdministradorResponseDTO> update(@PathVariable int id, @RequestBody @Valid AdministradorUpdateDTO novoAdministrador) {
        AdministradorResponseDTO administradorAtualizado = administradorService.update(id, novoAdministrador);

        if (administradorAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(administradorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AdministradorResponseDTO> delete(@PathVariable int id){
        AdministradorResponseDTO administrador = administradorService.findById(id);

        if (administrador == null) {
            return ResponseEntity.notFound().build();
        }
        administradorService.delete(id);
        return ResponseEntity.ok(administrador);
    }
}