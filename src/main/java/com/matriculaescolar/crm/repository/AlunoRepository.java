package com.matriculaescolar.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matriculaescolar.crm.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long>{

}
