package dev.ifrs.control;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import dev.ifrs.model.Administrador;

@Path("/adm")
@Transactional
public class AdmWS {

    @POST
    @Path("/adicionar")
    @Consumes(MediaType.APPLICATION_JSON)
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
}
