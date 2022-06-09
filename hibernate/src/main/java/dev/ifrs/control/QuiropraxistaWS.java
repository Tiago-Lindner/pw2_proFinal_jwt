package dev.ifrs.control;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import dev.ifrs.model.Quiropraxista;

@Path("/quiro")
@Transactional
public class QuiropraxistaWS {
    

    @GET
    @Path("/salvar/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public Quiropraxista salvar(@PathParam("nome") String nome) {
        Quiropraxista pac = new Quiropraxista();
        pac.setNome(nome);
        pac.persist();
        return pac;
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Quiropraxista> list() {
        // 3 - O método `listAll` recupera todos os objetos da classe User.
        return Quiropraxista.listAll();
        //ver se tem como editar o metodo para mostrar so o nome do quiro e pac
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addQuiro(@RequestBody IncluirQuiro qui){
        Quiropraxista quiro = new Quiropraxista();
        quiro.setNome(qui.getNome());
        quiro.setCpf(qui.getCpf());
        quiro.setEmail(qui.getEmail());
        quiro.setCrm(qui.getCrm());
        quiro.persist();
    }

    @GET
    @Path("/excluir/{idQuiro}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public void excluir(@PathParam("idQuiro") Long idQuiro){
        Quiropraxista quiro = Quiropraxista.findById(idQuiro);
        if (quiro == null)
            throw new BadRequestException("Quiropraxista não encontrado");
        quiro.delete();
    }

}
