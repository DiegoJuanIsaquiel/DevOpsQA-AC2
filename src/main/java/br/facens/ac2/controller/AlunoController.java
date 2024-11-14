package br.facens.ac2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facens.ac2.dto.AlunoDTO;
import br.facens.ac2.entity.Aluno;
import br.facens.ac2.service.AlunoService;


@RestController
@RequestMapping("/api/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @PutMapping("/{id}/verificarPlano")
    public ResponseEntity<Aluno> verificarAtualizarPlano(@PathVariable Long id) {
        Aluno alunoAtualizado = alunoService.verificarAtualizarPlano(id);
        return ResponseEntity.ok(alunoAtualizado);
    }
    
    @PostMapping("/criar")
    public ResponseEntity<Aluno> createAluno(@RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = alunoService.createAluno(alunoDTO);
        return new ResponseEntity<>(aluno, HttpStatus.CREATED);
    }
    
    @GetMapping("/ver")
    public ResponseEntity<List<AlunoDTO>> getAllAlunos() {
    	List<AlunoDTO> alunos = alunoService.getAllAlunos();
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }
}
