package dev.ifrs.teste;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.ws.rs.core.*;

@QuarkusTest
public class TestQuarkus {

    /* 
    @Test
    public void testCupom10() {
        given()
          .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED)
          .body("valor=1150,23&cupom=CUPOM10")
          .when() .post("/cupom") .then()
             .statusCode(200)
             .body(is("1035,21"));
    }

    @Test
    public void testCupom15() {
        given()
          .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED)
          .body("valor=1150,23&cupom=CUPOM15")
          .when() .post("/cupom") .then()
             .statusCode(200)
             .body(is("977,70"));
    }
*/
    @Test
    public void testLogin() {
        given()
          .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED)
          .body("nome=Tiago&senha=123")
          .when() .post("/testeQ") .then()
             .statusCode(200)
             .body(is("Logado"));
    }

    @Test
    public void testLogin2() {
        given()
          .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED)
          .body("nome=Tiago&senha=123")
          .when() .post("/testeQ") .then()
             .statusCode(405)
             .body(is(""));
    }
}
