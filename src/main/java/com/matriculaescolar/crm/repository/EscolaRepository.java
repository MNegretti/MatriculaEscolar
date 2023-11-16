package com.matriculaescolar.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matriculaescolar.crm.model.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long>{

}
