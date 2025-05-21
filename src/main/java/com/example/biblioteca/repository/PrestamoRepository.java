package com.example.biblioteca.repository;

import com.example.biblioteca.logic.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    // Usuarios con préstamos vencidos
    List<Prestamo> findByFechaDevolucionBefore(LocalDate fecha);

    // Filtrar préstamos por recurso
    List<Prestamo> findByRecursoId(Long recursoId);
}
