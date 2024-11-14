package br.facens.ac2.controller.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import br.facens.ac2.controller.AlunoController;
import br.facens.ac2.dto.AlunoDTO;
import br.facens.ac2.entity.Aluno;
import br.facens.ac2.service.AlunoService;

@WebMvcTest(AlunoController.class) 
public class AlunoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlunoService alunoService; 

    @Test
    public void testGetAlunos() throws Exception {
        
    	AlunoDTO mockUser = new AlunoDTO();
        mockUser.setId(1L);
        mockUser.setNome("Felipe Smith");
        mockUser.setEmail("felipe@example.com");
        
        List<AlunoDTO> mockAluno = List.of(mockUser);
        Mockito.when(alunoService.getAllAlunos()).thenReturn(mockAluno);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/alunos/ver") 
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Felipe Smith"))
                .andExpect(jsonPath("$[0].email").value("felipe@example.com"));
    }
    
    @Test
    public void testVerificarAtualizarPlano() throws Exception {
        Aluno mockAluno = new Aluno(1L, "Carlos Silva", 12, "Premium");
        Mockito.when(alunoService.verificarAtualizarPlano(1L)).thenReturn(mockAluno);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/alunos/1/verificarPlano")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nome").value("Carlos Silva"))
                .andExpect(jsonPath("$.plano").value("Premium"));
    }
    
    @Test
    public void testCreateAluno() throws Exception {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("João da Silva");
        alunoDTO.setEmail("joao@example.com");

        Aluno mockAluno = new Aluno(1L, "João da Silva", 0, "Básico");
        Mockito.when(alunoService.createAluno(Mockito.any(AlunoDTO.class))).thenReturn(mockAluno);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/alunos/criar")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"João da Silva\", \"email\":\"joao@example.com\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nome").value("João da Silva"))
                .andExpect(jsonPath("$.plano").value("Básico"));
    }
}