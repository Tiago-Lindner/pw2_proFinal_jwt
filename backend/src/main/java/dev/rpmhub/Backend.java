/**
 * PW2 by Rodrigo Prestes Machado
 *
 * PW2 is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
*/
package dev.rpmhub;

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

@Path("/login")
public class Backend {

    private static final Logger LOGGER = Logger.getLogger(Backend.class.getName());

    /* Recuperando uma informação do token */
    @Inject
    @Claim(standard = Claims.email)
    String email;

    @GET
    @Path("/{nome}")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed({ "Admin" })
    public String login(@PathParam("nome") String nome) {
        LOGGER.log(Level.INFO, "Backend: {0}", email);
        return "Login aprovado para o Admin: " + nome;
    }

}
