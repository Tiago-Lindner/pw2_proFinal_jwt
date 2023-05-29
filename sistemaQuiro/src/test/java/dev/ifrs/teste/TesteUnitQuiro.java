package dev.ifrs.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.ifrs.model.Quiropraxista;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 Testes Unitários Paciente
 */
public class TesteUnitQuiro {

    /** Logger. **/


    
    private static Logger logger = Logger.getLogger("AnnotationsTest");

private static List<Quiropraxista> quiLista;
    private static Quiropraxista quiro1 = new Quiropraxista("Tiago", "0100", "tiago.f.lindner@gmail.com", "55555");
    private static Quiropraxista quiro2 = new Quiropraxista("Rodrigo", "0001", "rodrigom@gmail.com", "12345");

    @BeforeAll
    static void init() {
        logger.info("init");
        quiLista = new ArrayList<Quiropraxista>();
        quiLista.add(quiro1);
    }

    @Test
    @DisplayName("Add test")
    void addQ2() {
        logger.info("add quiro2");
        quiLista.add(quiro2);
        assertEquals(2, quiLista.size());
    }

    @Test
    @DisplayName("ve nome quiro test")
    void nome() {
        logger.log(Level.INFO, "name");
        assertEquals("Tiago", quiLista.get(0).getNome());
    }

    @Test
    @DisplayName("ve nome quiro2 test")
    void nome2() {
        logger.log(Level.INFO, "name2");
        quiLista.add(quiro2);
        assertEquals("Rodrigo", quiLista.get(1).getNome());
    }

    @Test
    @DisplayName("ve crm quiro test")
    void crm() {
        logger.log(Level.INFO, "crm");
        assertEquals("55555", quiLista.get(0).getCrm());
    }

    @Test
    @DisplayName("pac duplicado test")
    void dup() {
        logger.log(Level.INFO, "duplicado");
        quiLista.add(quiro1);
        assertEquals("Tiago", quiLista.get(1).getNome());
    }

    @Test
    @DisplayName("pac remove test")
    void remove() {
        logger.log(Level.INFO, "remove");
        quiLista.remove(quiro1);
        assertEquals(true, quiLista.isEmpty());
    }
}
