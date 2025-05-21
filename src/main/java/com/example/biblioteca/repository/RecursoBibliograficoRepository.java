package com.example.biblioteca.repository;

import com.example.biblioteca.logic.RecursoBibliografico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecursoBibliograficoRepository extends JpaRepository<RecursoBibliografico, Long> {
}