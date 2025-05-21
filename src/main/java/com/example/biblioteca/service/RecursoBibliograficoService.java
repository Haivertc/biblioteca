package com.example.biblioteca.service;

import com.example.biblioteca.logic.RecursoBibliografico;
import com.example.biblioteca.repository.RecursoBibliograficoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoBibliograficoService {

    private final RecursoBibliograficoRepository recursoRepository;

    public RecursoBibliograficoService(RecursoBibliograficoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    public List<RecursoBibliografico> obtenerTodos() {
        return recursoRepository.findAll();
    }

    public Optional<RecursoBibliografico> obtenerPorId(Long id) {
        return recursoRepository.findById(id);
    }

    public RecursoBibliografico guardar(RecursoBibliografico recurso) {
        return recursoRepository.save(recurso);
    }

    public void eliminar(Long id) {
        recursoRepository.deleteById(id);
    }
}
