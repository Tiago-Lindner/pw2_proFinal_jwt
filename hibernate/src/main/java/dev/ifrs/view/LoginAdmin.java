package dev.ifrs.view;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import dev.ifrs.control.BackendLogin;

@Path("/login")
public class LoginAdmin {

    private static final Logger LOGGER = Logger.getLogger(LoginAdmin.class.getName());

    /* Recuperando uma informação do token */
    @Inject
    @Claim(standard = Claims.full_name)
    String fullName;

    /* Rest client */
    @Inject
    @RestClient
    BackendLogin backend;

    @GET
    @Path("/{nome}/{senha}")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed({ "Admin" })
    public String logAdm(@PathParam("nome") String nome, @PathParam("senha") String senha) {
        LOGGER.log(Level.INFO, "LoginAdmin: {0}", fullName);
        return backend.login(nome, senha);
    }

}
