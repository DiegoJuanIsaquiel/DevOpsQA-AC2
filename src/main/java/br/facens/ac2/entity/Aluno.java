package br.facens.ac2.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_aluno")

public class Aluno {
	
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private int cursosCompletados;
    private String plano;
    
    @Embedded
    private AlunoEmail email;
    
    // Construtor, getters e setters
    public Aluno() {}

    public Aluno(String nome, int cursosCompletados, String plano) {
        this.nome = nome;
        this.cursosCompletados = cursosCompletados;
        this.plano = plano;
    }

    public Aluno(Long id, String nome, int cursosCompletados, String plano) {
        this.id = id;
    	this.nome = nome;
        this.cursosCompletados = cursosCompletados;
        this.plano = plano;
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

    public int getCursosCompletados() {
        return cursosCompletados;
    }

    public void setCursosCompletados(int cursosCompletados) {
        this.cursosCompletados = cursosCompletados;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }
    
    public AlunoEmail getEmail() {
        return email;
    }

    public void setEmail(AlunoEmail email) {
        this.email = email;
    }
}
