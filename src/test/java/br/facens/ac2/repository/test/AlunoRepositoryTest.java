package br.facens.ac2.repository.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.facens.ac2.entity.Aluno;
import br.facens.ac2.entity.AlunoEmail;
import br.facens.ac2.repository.AlunoRepository;

@SpringBootTest
public class AlunoRepositoryTest {
	@Autowired
    private AlunoRepository alunoRepository;

    @Test
    void testSaveAndFindAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome("testAluno");
        aluno.setEmail(new AlunoEmail("test@example.com"));

        Aluno savedAluno = alunoRepository.save(aluno);
        assertNotNull(savedAluno.getId());

        Optional<Aluno> retrievedAluno = alunoRepository.findById(savedAluno.getId());
        assertTrue(retrievedAluno.isPresent());
        assertEquals("testAluno", retrievedAluno.get().getNome());
   }

}