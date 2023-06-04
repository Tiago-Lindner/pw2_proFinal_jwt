package dev.ifrs.control;

import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/testeQ")
public class ClasseSimples {
    

    //Fazer login com nome e senha, e retornar comunicação com o serviço de backend. Está bem simplifica
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String loginAdm(@FormParam("nome") String nome, @FormParam("senha") String senha){
        if(nome.equals("Tiago") && senha.equals("123")){
            return ("Logado");
        }
        else {
            return "Credenciais incorretas";
        }
    }

}
