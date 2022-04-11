package com.example.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

	Page<Etudiant> findByNomContains(String keyword,Pageable pageable);
}
