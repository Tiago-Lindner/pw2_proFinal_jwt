package dev.ifrs.teste;

import java.util.logging.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.ifrs.model.Paciente;
import dev.ifrs.model.Quiropraxista;
import dev.ifrs.model.Consulta;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 Testes Unitários Paciente
 */
public class TesteUnitConsulta {

    /** Logger. **/
    private static Logger logger = Logger.getLogger("AnnotationsTest");

    private static Paciente pac = new Paciente("Tiago");
    private static Quiropraxista quiro = new Quiropraxista("Rodrigo", "0001", "rodrigom@gmail.com", "12345");

    @Test
    @DisplayName("ve quiro test")
    void quiro() {
        logger.info("ve quiro");
        Consulta cons = new Consulta(null, null, null, pac, quiro);
        assertEquals(quiro, cons.getQuiro());
    }

    @Test
    @DisplayName("ve pac test")
    void pac() {
        logger.info("ve pac");
        Consulta cons = new Consulta(null, null, null, pac, quiro);
        assertEquals(pac, cons.getPaciente());
    }

}
