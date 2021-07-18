
package facade;

import entity.Persons;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class PersonsFacade extends AbstractFacade<Persons> implements PersonsFacadeLocal {

    @PersistenceContext(unitName = "shopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonsFacade() {
        super(Persons.class);
    }
    
    @Override
    public Persons findByUsername(String username) {
        Query query = em.createNamedQuery("Persons.findByUsername");
        query.setParameter("username", username);
        List resultList = query.getResultList();
        return resultList.isEmpty() ? null : (Persons) resultList.iterator().next();
    }
    
    
}
