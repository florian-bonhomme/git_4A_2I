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

    public HelloServlet() {
        this.pm = new PokemonManager();
    }

    @GET
    @Path("sayHello")
    public String sayHello() {
        return "hello";
    }

    @GET
    @Path("/pokemon")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pokemon> getPokemon(){
        return this.pm.getAll();
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

    private static List<Pokemon> pokemons;
    static {
        pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(1,"Pikachu", 25));
        pokemons.add(new Pokemon(2,"Magicarpe", 19));
    }

    // Méthode qui permet d'ajouter un Pokemon
    @POST
    @Path("pokemon2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPokemon2(Pokemon pokemon) {
        pokemons.add(pokemon);
        return Response.ok().entity(pokemon).build();
    }

    // Méthode qui permet d'afficher la liste pokemons
    @GET
    @Path("pokemon2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPokemon2() {
        return Response.ok().entity(pokemons).build();
    }

    // Méthode qui permet de supprimer un pokemon
    @DELETE
    @Path("supprimerpokemon/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Pokemon deletePokemon2(@PathParam("id") int id) {
        Pokemon pokemon = new Pokemon();
       for(int i=0; i<pokemons.size();i++){
           if(id==pokemons.get(i).getId()){
               pokemon = pokemons.get(i);
               pokemons.remove(i);
           }
       }
        return pokemon;
    }

    /*
    @PUT
    @Path("pokemon2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putPokemon2(Pokemon pokemon) {
        return Response.ok().entity(pokemons).build();
    }
    */


}
