package com.example.biblioteca.controller;

import com.example.biblioteca.dtos.UsuarioDTO;
import com.example.biblioteca.logic.Usuario;
import com.example.biblioteca.response.ResponseHandler;
import com.example.biblioteca.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<Object> obtenerTodos() {
        return ResponseHandler.generateResponse("Lista de usuarios", HttpStatus.OK, usuarioService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obtenerPorId(@PathVariable Long id) {
        return usuarioService.obtenerPorId(id)
                .map(usuario -> ResponseHandler.generateResponse("Usuario encontrado", HttpStatus.OK, usuario))
                .orElse(ResponseHandler.generateResponse("Usuario no encontrado", HttpStatus.NOT_FOUND, null));
    }

    @PostMapping
    public ResponseEntity<Object> guardar(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setCorreo(usuarioDTO.getCorreo());

        return ResponseHandler.generateResponse("Usuario guardado", HttpStatus.CREATED, usuarioService.guardar(usuario));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return ResponseHandler.generateResponse("Usuario eliminado", HttpStatus.OK, null);
    }
}