package br.facens.ac2.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.facens.ac2.dto.AlunoDTO;
import br.facens.ac2.entity.Aluno;
import br.facens.ac2.entity.AlunoEmail;
import br.facens.ac2.repository.AlunoRepository;
import br.facens.ac2.service.AlunoService;

public class AlunoServiceTest {

	    @Mock
	    private AlunoRepository alunoRepository;

	    @InjectMocks
	    private AlunoService alunoService;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    void testGetAllAluno() {
	        Aluno aluno = new Aluno();
	        aluno.setId(1L);
	        aluno.setNome("Nome do Aluno");
	        aluno.setEmail(new AlunoEmail("aluno@example.com"));

	        Aluno aluno_2 = new Aluno();
	        aluno_2.setId(2L);
	        aluno_2.setNome("aluno_2");
	        aluno_2.setEmail(new AlunoEmail("aluno_2@example.com"));

	        when(alunoRepository.findAll()).thenReturn(Arrays.asList(aluno, aluno_2));

	        List<AlunoDTO> alunos = alunoService.getAllAlunos();

	        assertEquals(2, alunos.size());
	        assertEquals("Nome do Aluno", alunos.get(0).getNome());
	        assertEquals("aluno@example.com", alunos.get(0).getEmail());
	    }
}
