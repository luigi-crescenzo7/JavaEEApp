
package ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.inject.Inject;

@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "java:global/jdbc/TorneoDataSource",
        user = "ok",
        password = "ok",
        databaseName = "db_torneo",
        properties = {"connectionAttributes=;create=true"}
)
@Singleton
@Startup
@LocalBean
public class DatabasePopulator {

    @Inject
    private TorneoEJB service;
    private Partita p1, p2, p3, p4;

    @PostConstruct
    private void insert() {
        p1 = new Partita("Classic", "Pap", "Furman", 2431, 2114, "e4 c5 Nf3 Nc6 Nc3 Nf6 e5 Nd5 Bc4 Nb6 Bb3 d5", "G1", true);
        p2 = new Partita("Rapid", "Caruana", "Nepomniachtchi", 2770, 2798, "e4 e5 Nf3 Nf6 Nc3 Nc6 Bb5 Nd4 Nxd4 exd4 e5 dxc3", "Patta", true);
        p3 = new Partita("Classic", "Carlsen", "Maghsoodloo", 2892, 2655, "e4 e6 d4 d5 e5 c5 c3 Qb6 Nf3", "In corso", false);
        p4 = new Partita("Blitz", "Nepomniachtchi", "Nakamura", 2798, 2836, "e4 e5 Nf3 Nc6 Bb5 Nf6 0-0 Nxe4 Re1"
                + " Nd6 Nxe5 Be7 Bf1 Nf5 Nf3 d5 d4 0-0 Nc3 Bb4 h3 Nd6 a3 Bxc3 bxc3 Re8 Rxe8+", "Patta", true);

        service.creaPartita(p1);
        service.creaPartita(p2);
        service.creaPartita(p3);
        service.creaPartita(p4);
    }

    @PreDestroy
    private void destroy() {
        service.rimuoviPartita(p1);
        service.rimuoviPartita(p2);
        service.rimuoviPartita(p3);
        service.rimuoviPartita(p4);
    }
}
