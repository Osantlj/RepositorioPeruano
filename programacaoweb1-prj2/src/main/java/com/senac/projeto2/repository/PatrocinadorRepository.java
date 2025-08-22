package com.senac.projeto2.repository;

import com.senac.projeto2.entity.Patrocinador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatrocinadorRepository extends JpaRepository<Patrocinador, Integer> { }
