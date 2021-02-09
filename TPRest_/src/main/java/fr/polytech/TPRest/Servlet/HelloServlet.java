package fr.polytech.TPRest.Servlet;


import fr.polytech.TPRest.Servlet.DBManager.PokemonManager;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.servlet.http.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;


@Path("/hello")
public class HelloServlet extends HttpServlet {
    private PokemonManager pm;

    //Partie Pokemon avec BBD et Hibernate

    public HelloServlet() {
        this.pm = new PokemonManager();
    }

    //Méthode POST qui permet de créer un pokemon
    @POST
    @Path("/pokemon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Pokemon createPokemon(Pokemon pokemon)
    {
        PokemonManager pm = new PokemonManager();
        return pm.create(pokemon);
    }

    //Méthode GET qui permet de récupérer les pokemon
    @GET
    @Path("/pokemon")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pokemon> getPokemon(){
        return this.pm.getAll();
    }

    //Méthode GET qui permet de récupérer un pokemon à partir de son ID
    @GET
    @Path("/pokemon/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pokemon getPokemonById(@PathParam("id") int id)
    {
        PokemonManager pm = new PokemonManager();
        return pm.getById(id);
    }

    //Méthode PUT qui permet la modification d'un pokemon dans la BDD
    @PUT
    @Path("/pokemon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Pokemon updatePokemon(Pokemon pokemon){
        PokemonManager pm = new PokemonManager();
        return pm.update(pokemon);
    }

    //Méthode qui permet la suppresion d'un pokemon dans la BDD
    @DELETE
    @Path("/pokemon")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePokemon(Pokemon pokemon)
    {
        PokemonManager pm = new PokemonManager();
        return pm.delete(pokemon);
    }

    @POST
    @Path("/attaque/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Pokemon createAttaque(Attaque attaque,@PathParam("id") int id)
    {
        PokemonManager pm = new PokemonManager();
        return pm.addAttaque(attaque,id);
    }
}
