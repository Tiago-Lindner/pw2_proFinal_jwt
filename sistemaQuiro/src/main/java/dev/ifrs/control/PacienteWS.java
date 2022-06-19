package dev.ifrs.control;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import dev.ifrs.model.Consulta;
import dev.ifrs.model.Paciente;

@Path("/pac")
@Transactional
public class PacienteWS {

    //Adicionar um paciente. Requer Role de User
    @POST
    @Path("/adicionar")
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({ "Admin", "Pac" })
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

    //Listar todos os pacientes. Não mostra as consultas
    @GET
    @Path("/listar/pacientes")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Paciente> listarPac() {
        // 3 - O método `listAll` recupera todos os objetos da classe User.
        return Paciente.listAll(); 
    }
    
    //Listar as consultas do paciente com o Id informado
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

    //Excluir o paciente com o Id informado. Não funciona se possuir consultas.
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

    private static final Logger LOGGER = Logger.getLogger(AdmWS.class.getName());

    /* Recuperando uma informação do token */
    @Inject
    @Claim(standard = Claims.full_name)
    String fullName;

     /* Rest client */
     @Inject
     @RestClient
     BackendLogin backend;

    //Fazer login com nome e senha, e retornar comunicação com o serviço de backend. Está bem simplifica
    @GET
    @Path("/login/{nome}/{senha}")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed({ "Pac" })
    public String loginPac(@PathParam("nome") String nome, @PathParam("senha") String senha){
        if(Paciente.findByCredentials(nome, senha).isEmpty() == false){
            LOGGER.log(Level.INFO, "LoginPac: {0}", fullName);
            return backend.login(nome);
        }
        else {
            return "Credenciais incorretas";
        }
    }

}
