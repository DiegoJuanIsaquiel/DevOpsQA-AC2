package br.facens.ac2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.facens.ac2.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}