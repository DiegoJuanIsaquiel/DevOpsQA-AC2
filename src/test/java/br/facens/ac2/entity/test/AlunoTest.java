package br.facens.ac2.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.facens.ac2.entity.Aluno;
import br.facens.ac2.entity.AlunoEmail;

public class AlunoTest {

    @Test
    void testSetAndGetValidEmail() {
        Aluno aluno = new Aluno();
        AlunoEmail email = new AlunoEmail("test@example.com");
        aluno.setEmail(email);

        assertEquals(email, aluno.getEmail());
    }

    @Test
    void testInvalidEmailThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new AlunoEmail("invalid-email");
        });
    }
}
