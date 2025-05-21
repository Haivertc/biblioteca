package com.example.biblioteca.service;

import com.example.biblioteca.logic.Prestamo;
import com.example.biblioteca.repository.PrestamoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    public List<Prestamo> obtenerTodos() {
        return prestamoRepository.findAll();
    }

    public Optional<Prestamo> obtenerPorId(Long id) {
        return prestamoRepository.findById(id);
    }

    public Prestamo guardar(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    public void eliminar(Long id) {
        prestamoRepository.deleteById(id);
    }

    public List<Prestamo> prestamosVencidos() {
        return prestamoRepository.findByFechaDevolucionBefore(LocalDate.now());
    }

    public List<Prestamo> prestamosPorRecurso(Long recursoId) {
        return prestamoRepository.findByRecursoId(recursoId);
    }
}