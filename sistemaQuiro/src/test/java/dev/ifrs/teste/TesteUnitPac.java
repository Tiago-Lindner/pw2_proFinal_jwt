package dev.ifrs.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.ifrs.model.Paciente;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 Testes Unitários Paciente
 */
public class TesteUnitPac {

    /** Logger. **/
    private static Logger logger = Logger.getLogger("AnnotationsTest");

    private static List<Paciente> pacLista;
    private static Paciente pac1 = new Paciente("Tiago");
    private static Paciente pac2 = new Paciente("Rodrigo", "0001", "rodrigom@gmail.com", "Rodrigo Machado", "vvs123", "Rua 1");

    @BeforeAll
    static void init() {
        logger.info("init");
        pacLista = new ArrayList<Paciente>();
        pacLista.add(pac1);
    }

    @Test
    @DisplayName("Add test")
    void addP2() {
        logger.info("add pac2");
        pacLista.add(pac2);
        assertEquals(2, pacLista.size());
    }

    @Test
    @DisplayName("ve nome pac test")
    void nome() {
        logger.log(Level.INFO, "name");
        assertEquals("Tiago", pacLista.get(0).getNome());
    }

    @Test
    @DisplayName("ve nome pac2 test")
    void nome2() {
        logger.log(Level.INFO, "name2");
        pacLista.add(pac2);
        assertEquals("Rodrigo", pacLista.get(1).getNome());
    }

    @Test
    @DisplayName("ve cpf pac test")
    void cpf() {
        logger.log(Level.INFO, "cpf");
        assertEquals(null, pacLista.get(0).getCpf());
    }

    @Test
    @DisplayName("pac duplicado test")
    void dup() {
        logger.log(Level.INFO, "duplicado");
        pacLista.add(pac1);
        assertEquals("Tiago", pacLista.get(1).getNome());
    }

    @Test
    @DisplayName("pac remove test")
    void remove() {
        logger.log(Level.INFO, "remove");
        pacLista.remove(pac1);
        assertEquals(true, pacLista.isEmpty());
    }
}
