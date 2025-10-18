package controller;

import dto.Referencia_bibliograficaCreateDTO;
import dto.Referencia_bibliograficaResponseDTO;
import dto.Referencia_bibliograficaUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.Referencia_bibliograficaService;

import java.util.List;

@RestController
@RequestMapping("/Referencia_bibliografica")
public class Referencia_bibliograficaController {

    @Autowired
    Referencia_bibliograficaService referencia_bibliograficaService;

    public Referencia_bibliograficaController(Referencia_bibliograficaService referencia_bibliograficaService) {
        this.referencia_bibliograficaService = referencia_bibliograficaService;
    }

    @GetMapping
    public ResponseEntity<List<Referencia_bibliograficaResponseDTO>>  findAll() {
        List<Referencia_bibliograficaResponseDTO> referencia_bibliografica = referencia_bibliograficaService.findAll();
        return ResponseEntity.ok(referencia_bibliografica);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Referencia_bibliograficaResponseDTO> findById(@PathVariable int id) {
        Referencia_bibliograficaResponseDTO referencia_bibliografica = referencia_bibliograficaService.findById(id);

        if (referencia_bibliografica == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(referencia_bibliografica);
    }

    @PostMapping
    public ResponseEntity<Referencia_bibliograficaResponseDTO> create(@RequestBody @Valid Referencia_bibliograficaCreateDTO novoReferencia_bibliografica) {
        Referencia_bibliograficaResponseDTO Referencia_bibliograficaCriado = referencia_bibliograficaService.create(novoReferencia_bibliografica);
        return ResponseEntity.status(HttpStatus.CREATED).body(Referencia_bibliograficaCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Referencia_bibliograficaResponseDTO> update(@PathVariable int id, @RequestBody @Valid Referencia_bibliograficaUpdateDTO novoReferencia_bibliografica) {
        Referencia_bibliograficaResponseDTO referencia_bibliograficaAtualizado = referencia_bibliograficaService.update(id, novoReferencia_bibliografica);

        if (referencia_bibliograficaAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(referencia_bibliograficaAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Referencia_bibliograficaResponseDTO> delete(@PathVariable int id){
        Referencia_bibliograficaResponseDTO referencia_bibliografica = referencia_bibliograficaService.findById(id);

        if (referencia_bibliografica == null) {
            return ResponseEntity.notFound().build();
        }
        referencia_bibliograficaService.delete(id);
        return ResponseEntity.ok(referencia_bibliografica);
    }
}