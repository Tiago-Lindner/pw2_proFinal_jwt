package dev.ifrs.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.ifrs.model.Administrador;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 Testes Unitários Paciente
 */
public class TesteUnitAdm {

    /** Logger. **/
    private static Logger logger = Logger.getLogger("AnnotationsTest");

    private static List<Administrador> admLista;
    private static Administrador adm1 = new Administrador("Tiago", "123");
    
    @BeforeAll
    static void init() {
        logger.info("init");
        admLista = new ArrayList<Administrador>();
        admLista.add(adm1);
    }

    @Test
    @DisplayName("Add test")
    void addP2() {
        logger.info("add pac2");
        admLista.add(adm1);
        assertEquals(2, admLista.size());
    }

    @Test
    @DisplayName("ve nome test")
    void nome() {
        logger.log(Level.INFO, "name");
        assertEquals("Tiago", admLista.get(0).getNome());
    }

    @Test
    @DisplayName("ve nome 2 test")
    void nome2() {
        logger.log(Level.INFO, "name2");
        admLista.add(adm1);
        assertEquals("Tiago", admLista.get(1).getNome());
    }

    @Test
    @DisplayName("ve senha test")
    void senha() {
        logger.log(Level.INFO, "senha");
        assertEquals("123", admLista.get(0).getSenha());
    }

    @Test
    @DisplayName("adm duplicado test")
    void dup() {
        logger.log(Level.INFO, "duplicado");
        admLista.add(adm1);
        assertEquals("Tiago", admLista.get(1).getNome());
    }

    @Test
    @DisplayName("pac remove test")
    void remove() {
        logger.log(Level.INFO, "remove");
        admLista.remove(adm1);
        assertEquals(true, admLista.isEmpty());
    }
}
