import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("jwt")
public class JwtResource {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getJwt() {
    System.out.println("hola");
    return "Hello World!";
  }
}
