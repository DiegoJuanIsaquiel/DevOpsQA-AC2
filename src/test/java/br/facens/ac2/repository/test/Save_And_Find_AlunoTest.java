package br.facens.ac2.repository.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.facens.ac2.entity.Aluno;
import br.facens.ac2.repository.AlunoRepository;

@DataJpaTest
public class Save_And_Find_AlunoTest {
    @Autowired
    private AlunoRepository alunoRepository;

    @Test
    public void testSaveAndFindAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome("testAluno1");

        Aluno savedAluno = alunoRepository.save(aluno);
        assertNotNull(savedAluno.getId());
        
        Optional<Aluno> retrievedAluno = alunoRepository.findById(savedAluno.getId());
        assertThat(retrievedAluno).isPresent();
        assertThat(retrievedAluno.get().getNome()).isEqualTo("testAluno1");
    }

}