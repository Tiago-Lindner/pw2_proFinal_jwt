package dev.ifrs.control;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import dev.ifrs.model.Administrador;

@Path("/adm")
@Transactional
public class AdmWS {

    @POST
    @Path("/adicionar")
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({ "Admin" })
    public void addAdmin(@RequestBody IncluirAdm admin){
        Administrador adm = new Administrador();
        adm.setNome(admin.getNome());
        adm.setSenha(admin.getSenha());
        adm.persist();
    }
    
    @GET
    @Path("/listar/admins")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Administrador> listarAdm() {
        // 3 - O método `listAll` recupera todos os objetos da classe User.
        return Administrador.listAll(); 
    }

    private static final Logger LOGGER = Logger.getLogger(AdmWS.class.getName());

    /* Recuperando uma informação do token */
    @Inject
    @Claim(standard = Claims.full_name)
    String fullName;

     /* Rest client */
     @Inject
     @RestClient
     BackendLogin backend;

    @GET
    @Path("/login/{nome}/{senha}")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed({ "Admin" })
    public String loginAdm(@PathParam("nome") String nome, @PathParam("senha") String senha){
        if(Administrador.findByCredentials(nome, senha).isEmpty() == false){
            LOGGER.log(Level.INFO, "LoginAdmin: {0}", fullName);
            return backend.login(nome, senha);
        }
        else {
            return "Credenciais incorretas";
        }
    }
}
