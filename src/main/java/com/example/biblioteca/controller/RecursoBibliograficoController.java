package com.example.biblioteca.controller;

import com.example.biblioteca.logic.RecursoBibliografico;
import com.example.biblioteca.response.ResponseHandler;
import com.example.biblioteca.service.RecursoBibliograficoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recursos")
@CrossOrigin
public class RecursoBibliograficoController {

    private final RecursoBibliograficoService recursoService;

    public RecursoBibliograficoController(RecursoBibliograficoService recursoService) {
        this.recursoService = recursoService;
    }

    @GetMapping
    public ResponseEntity<Object> obtenerTodos() {
        return ResponseHandler.generateResponse("Lista de recursos", HttpStatus.OK, recursoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obtenerPorId(@PathVariable Long id) {
        return recursoService.obtenerPorId(id)
                .map(recurso -> ResponseHandler.generateResponse("Recurso encontrado", HttpStatus.OK, recurso))
                .orElse(ResponseHandler.generateResponse("Recurso no encontrado", HttpStatus.NOT_FOUND, null));
    }

    @PostMapping
    public ResponseEntity<Object> guardar(@RequestBody RecursoBibliografico recurso) {
        recurso.setId(null); // Forzar nuevo ID para creación
        return ResponseHandler.generateResponse("Recurso guardado", HttpStatus.CREATED, recursoService.guardar(recurso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id) {
        recursoService.eliminar(id);
        return ResponseHandler.generateResponse("Recurso eliminado", HttpStatus.OK, null);
    }
}
