package org.fugerit.java.demo.lab.broken.access.control.persistence;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Collection;
import java.util.List;

/**
 * Repository per la entity Person
 */
@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    /**
     * Restituisce l'elenco delle persone ordinate per cognome e nome,
     * filtrate per MIN_ROLE (NULL oppure presente nella collection di ruoli fornita)
     *
     * @param roles Collection dei ruoli dell'utente
     * @return Lista di Person filtrate e ordinate
     */
    public List<Person> findByRolesOrderedByName(Collection<String> roles) {
        return find("order by lastName, firstName").list();
    }

}