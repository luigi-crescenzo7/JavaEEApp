
package ejb;

import static ejb.Partita.TROVA_CONCLUSE;
import static ejb.Partita.TROVA_G1;
import static ejb.Partita.TROVA_G2;
import static ejb.Partita.TROVA_ID;
import static ejb.Partita.TROVA_MOSSE;
import static ejb.Partita.TROVA_RISULTATO;
import static ejb.Partita.TROVA_SOMMA_RATING;
import static ejb.Partita.TROVA_TIPO;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import static ejb.Partita.TROVA_TUTTI;


@WebService
@Stateless
@LocalBean
public class TorneoEJB implements TorneoEJBRemote {

    @Inject
    private EntityManager em;

    @Override
    public void creaPartita(Partita p) {
        em.persist(p);
    }

    @Override
    public Partita aggiornaPartita(Partita p) {
        return em.merge(p);
    }

    @Override
    public void rimuoviPartita(Partita p) {
        em.remove(em.merge(p));
    }

    @Override
    public List<Partita> trovaTutte() {
        return em.createNamedQuery(TROVA_TUTTI, Partita.class).getResultList();
    }

    @Override
    public List<Partita> trovaPerSomma() {
        return em.createNamedQuery(TROVA_SOMMA_RATING, Partita.class).getResultList();
    }

    @Override
    public Partita trovaPerId(int id) {
        return em.createNamedQuery(TROVA_ID, Partita.class).setParameter("id", id).getSingleResult();
    }

    
    @Override
    public List<Partita> trovaPerRisultato(String r) {
        return em.createNamedQuery(TROVA_RISULTATO, Partita.class).setParameter("risultato", r).getResultList();
    }

    @Override
    public List<Partita> trovaPerTipo(String t) {
        return em.createNamedQuery(TROVA_TIPO, Partita.class).setParameter("tipo", t).getResultList();
    }

    @Override
    public List<Partita> trovaPartiteG1(String n) {
        return em.createNamedQuery(TROVA_G1, Partita.class).setParameter("nome", n).getResultList();
    }

    @Override
    public List<Partita> trovaPartiteG2(String n) {
        return em.createNamedQuery(TROVA_G2, Partita.class).setParameter("nome", n).getResultList();
    }

    @Override
    public List<Partita> trovaPerMosse(String m) {
        return em.createNamedQuery(TROVA_MOSSE, Partita.class).setParameter("mosse", m).getResultList();
    }

    @Override
    public List<Partita> trovaConcluse() {
        return em.createNamedQuery(TROVA_CONCLUSE, Partita.class).getResultList();
    }

}
