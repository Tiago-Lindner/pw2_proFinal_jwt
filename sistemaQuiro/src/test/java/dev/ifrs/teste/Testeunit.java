package dev.ifrs.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.ifrs.model.Paciente;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 Testes Unitários
 */
public class Testeunit {

    /** Logger. **/
    private static Logger logger = Logger.getLogger("AnnotationsTest");

    private static List<Paciente> pacLista;
    private static Paciente pac1 = new Paciente("Tiago");
    private static Paciente pac2 = new Paciente("Rodrigo");

    @BeforeAll
    public static void init() {
        logger.info("init");
        pacLista = new ArrayList<Paciente>();
        pacLista.add(pac1);
    }

    @BeforeEach
    public void add() {
        logger.info("add");
        pacLista.add(pac2);
    }

    @Test
    @DisplayName("Length test")
    public void length() {
        logger.info("length");
        assertEquals(2, pacLista.size());
    }

    @Test
    @DisplayName("Remove Paciente test")
    public void remove() {
        logger.log(Level.INFO, "remove");
        pacLista.remove(0);
        assertEquals(2, pacLista.size());
    }

}
