package fr.polytech.TPRest.Servlet.DBManager;

import fr.polytech.TPRest.Servlet.Attaque;
import fr.polytech.TPRest.Servlet.Pokemon;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ws.rs.core.Response;
import java.util.List;

import static fr.polytech.TPRest.Servlet.DBManager.HibernateFactory.getSession;

public class PokemonManager {
    /**
     * Permet de récupérer tous les magasins
     *
     * @return liste de tous les magasins
     */
    public Pokemon create(Pokemon pokemon) {
        Session session = getSession();
        session.beginTransaction();
        session.save(pokemon.getType());
        session.getTransaction().commit();
        //Si l'id n'existe pas en base on le crée
        if(pokemon.getDresseur().getId()==0){
            session.beginTransaction();
            session.save(pokemon.getDresseur());
            session.getTransaction().commit();
        }
        session.beginTransaction();
        session.save(pokemon);
        session.getTransaction().commit();
        return pokemon;
    }

    public List<Pokemon> getAll() {
        Session session = getSession();
        Query query = session.createQuery("select pokemon from Pokemon as pokemon");
        return query.getResultList();
    }

    public Pokemon update(Pokemon pokemon) {
        Session session = getSession();
        session.beginTransaction();
        session.update(pokemon);
        session.getTransaction().commit();
        return pokemon;
    }

    public Response delete(Pokemon pokemon) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(pokemon);
        session.getTransaction().commit();
        return Response.ok().build();
    }

    public Pokemon getById(int id) {
        Session session = getSession();
        Query query = session.createQuery("select pokemon from Pokemon as pokemon where pokemon.id=:id");
        query.setParameter("id", id);
        return (Pokemon) query.getSingleResult();
    }

    public Pokemon addAttaque(Attaque attaque,int id){
        Pokemon pokemon = getById(id);
        Session session = getSession();
        session.beginTransaction();
        attaque.addPokemons(pokemon);
        session.save(attaque);
        session.getTransaction().commit();
        session.beginTransaction();
        pokemon.addAttaque(attaque);
        session.merge(pokemon);
        session.getTransaction().commit();

        return pokemon;
    }


}
