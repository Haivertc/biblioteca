package com.example.biblioteca.repository;

import com.example.biblioteca.logic.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
