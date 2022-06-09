package dev.ifrs.control;

import java.util.List;
import java.util.Set;

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

import dev.ifrs.model.Consulta;
import dev.ifrs.model.Paciente;

@Path("/pac")
@Transactional
public class PacienteWS {
    
    @GET
    @Path("/salvar/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public Paciente salvar(@PathParam("nome") String nome) {
        Paciente pac = new Paciente();
        pac.setNome(nome);
        pac.persist();
        return pac;
    }

    @GET
    @Path("/listar/pacientes")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Paciente> listarPac() {
        // 3 - O método `listAll` recupera todos os objetos da classe User.
        return Paciente.listAll(); 
    }
    
    @GET
    @Path("/listar/consultas/{idPac}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Set<Consulta> listarCons(@PathParam("idPac") Long idPac) {
        Paciente pac = Paciente.findById(idPac);
        if (pac == null)
            throw new BadRequestException("Paciente não encontrado"); 
        
        return pac.getConsultas(); 
    }

    @POST
    @Path("/adicionar")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPaciente(@RequestBody IncluirPaciente paci){
        Paciente pac = new Paciente();
        pac.setNome(paci.getNome());
        pac.setCpf(paci.getCpf());
        pac.setEmail(paci.getEmail());
        pac.setUserLogin(paci.getUserLogin());
        pac.setUserSenha(paci.getUserSenha());
        pac.setTelefone(paci.getTelefone());
        pac.setEndereco(paci.getEndereco());
        pac.persist();
    }

    @GET
    @Path("/excluir/{idPac}")
    @Produces(MediaType.APPLICATION_JSON)
    //@Transactional
    public void excluir(@PathParam("idPac") Long idPac){
        Paciente pac = Paciente.findById(idPac);
        if (pac == null)
            throw new BadRequestException("Paciente não encontrado");
        pac.delete();
    }

    

}
