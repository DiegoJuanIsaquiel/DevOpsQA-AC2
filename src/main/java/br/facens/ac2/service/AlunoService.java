package br.facens.ac2.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facens.ac2.dto.AlunoDTO;
import br.facens.ac2.entity.Aluno;
import br.facens.ac2.entity.AlunoEmail;
import br.facens.ac2.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    // Verifica se o aluno completou 12 cursos e atualiza o plano para Premium
    public Aluno verificarAtualizarPlano(Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            
            // Se o aluno completou 12 ou mais cursos, atualizamos o plano para Premium
            if (aluno.getCursosCompletados() >= 12) {
                aluno.setPlano("Premium");
                alunoRepository.save(aluno); // Persistir a mudança
            }
            return aluno;
        } else {
            throw new RuntimeException("Aluno não encontrado");
        }
    }
    
    // Método para encontrar o aluno por ID
    public Aluno findById(Long id) {
        Optional<Aluno> alunoOpt = alunoRepository.findById(id);
        return alunoOpt.orElse(null); // Retorna null se o aluno não for encontrado
    }
    
    public Aluno createAluno(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(new AlunoEmail(alunoDTO.getEmail()));
        return alunoRepository.save(aluno);
    }

    public List<AlunoDTO> getAllAlunos() {
        return alunoRepository.findAll().stream()
                .map(aluno -> {
                    AlunoDTO dto = new AlunoDTO();
                    dto.setNome(aluno.getNome());
                    dto.setEmail(aluno.getEmail().getEmailAddress());
                    return dto;
                })
                .collect(Collectors.toList());	
    }
}
