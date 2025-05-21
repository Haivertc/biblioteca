package com.example.biblioteca.controller;

import com.example.biblioteca.dtos.PrestamoDTO;
import com.example.biblioteca.logic.Prestamo;
import com.example.biblioteca.logic.RecursoBibliografico;
import com.example.biblioteca.logic.Usuario;
import com.example.biblioteca.response.ResponseHandler;
import com.example.biblioteca.service.PrestamoService;
import com.example.biblioteca.service.RecursoBibliograficoService;
import com.example.biblioteca.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/prestamos")
@CrossOrigin
public class PrestamoController {

    private final PrestamoService prestamoService;
    private final UsuarioService usuarioService;
    private final RecursoBibliograficoService recursoService;

    public PrestamoController(PrestamoService prestamoService, UsuarioService usuarioService, RecursoBibliograficoService recursoService) {
        this.prestamoService = prestamoService;
        this.usuarioService = usuarioService;
        this.recursoService = recursoService;
    }

    @GetMapping
    public ResponseEntity<Object> obtenerTodos() {
        List<Prestamo> prestamos = prestamoService.obtenerTodos();
        // Si quieres devolver DTOs, debes mapearlos, pero aquí retorno las entidades para simplificar
        return ResponseHandler.generateResponse("Lista de préstamos", HttpStatus.OK, prestamos);
    }

    @PostMapping
    public ResponseEntity<Object> crearPrestamo(@RequestBody PrestamoDTO prestamoDTO) {
        // Buscar usuario y recurso por id
        Usuario usuario = usuarioService.obtenerPorId(prestamoDTO.getUsuarioId()).orElse(null);
        RecursoBibliografico recurso = recursoService.obtenerPorId(prestamoDTO.getRecursoId()).orElse(null);

        if (usuario == null || recurso == null) {
            return ResponseHandler.generateResponse("Usuario o recurso no encontrado", HttpStatus.BAD_REQUEST, null);
        }

        // Crear entidad Prestamo
        Prestamo prestamo = new Prestamo();
        prestamo.setFechaPrestamo(prestamoDTO.getFechaPrestamo());
        prestamo.setFechaDevolucion(prestamoDTO.getFechaDevolucion());
        prestamo.setUsuario(usuario);
        prestamo.setRecurso(recurso);

        // Guardar préstamo
        Prestamo prestamoGuardado = prestamoService.guardar(prestamo);

        return ResponseHandler.generateResponse("Préstamo creado", HttpStatus.CREATED, prestamoGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id) {
        prestamoService.eliminar(id);
        return ResponseHandler.generateResponse("Préstamo eliminado", HttpStatus.OK, null);
    }
}
