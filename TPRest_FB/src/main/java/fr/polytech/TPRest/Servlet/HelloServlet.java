package fr.polytech.TPRest.Servlet;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;


@Path("/hello")
public class HelloServlet extends HttpServlet {

    @GET
    @Path("sayHello")
    public String sayHello() {
        return "hello";
    }

    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person) {
        return Response.ok().entity(person).cookie(new NewCookie("person", person.toString())).build();
    }

    @GET
    @Path("get")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson() {
        Person perso1 = new Person("Florian","Bonhomme");
        return Response.ok().entity(perso1).build();
    }

    @PUT // modifie une donnée dans la bdd
    @Path("put")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putPerson(Person person) {
        return Response.ok().entity(person).cookie(new NewCookie("person", person.toString())).build();
    }

    @DELETE // supprime une donnée dans la bdd
    @Path("delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePerson(Person person) {
        return Response.ok().entity(person).cookie(new NewCookie("person", person.toString())).build();
    }

    //POKEMON

    //List<Pokemon> pokemons = Arrays.asList(new Pokemon(1,"Pikachu", 25), new Pokemon(2,"Magicarpe", 19));

    private static List<Pokemon> pokemons;
    static {
        pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(1,"Pikachu", 25));
        pokemons.add(new Pokemon(2,"Magicarpe", 19));
    }

    @POST
    @Path("pokemon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return Response.ok().entity(pokemon).build();
    }

    @GET
    @Path("pokemon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPokemon() {
        return Response.ok().entity(pokemons).build();
    }

/*
    @PUT
    @Path("pokemon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putPokemon(Pokemon pokemon) {
        return Response.ok().entity(pokemons).build();
    }
 */

    /*
    @DELETE
    @Path("pokemon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePokemon(Pokemon pokemon2) {
        for (pokemon:pokemons) {

        }
    }
     */

}
