package br.facens.ac2.dto;

import br.facens.ac2.entity.Aluno;

public class AlunoDTO {
	private Long id;
    private String nome;
    private String email;
    
    public AlunoDTO() {}

    public AlunoDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public static AlunoDTO fromEntity(Aluno aluno) {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setId(aluno.getId());
        alunoDTO.setNome(aluno.getNome());

        if (aluno.getEmail() != null) {
            alunoDTO.setEmail(aluno.getEmail().getEmailAddress());
        }

        return alunoDTO;
    }
}
