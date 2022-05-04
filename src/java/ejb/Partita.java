
package ejb;

import static ejb.Partita.TROVA_CONCLUSE;
import static ejb.Partita.TROVA_G1;
import static ejb.Partita.TROVA_G2;
import static ejb.Partita.TROVA_ID;
import static ejb.Partita.TROVA_MOSSE;
import static ejb.Partita.TROVA_RISULTATO;
import static ejb.Partita.TROVA_SOMMA_RATING;
import static ejb.Partita.TROVA_TIPO;
import static ejb.Partita.TROVA_TUTTI;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_TUTTI, query = "SELECT p FROM Partita p"),
    @NamedQuery(name = TROVA_ID, query = "SELECT p FROM Partita p"
            + " WHERE p.id = :id"),
    @NamedQuery(name = TROVA_TIPO, query = "SELECT p FROM Partita p "
            + "WHERE p.tipoPartita = :tipo"),
    @NamedQuery(name = TROVA_G1, query = "SELECT p FROM Partita p WHERE"
            + " p.nomeGiocatore1 = :nome"),
    @NamedQuery(name = TROVA_G2, query = "SELECT p FROM Partita p WHERE"
            + " p.nomeGiocatore2 = :nome"),
    @NamedQuery(name = TROVA_RISULTATO, query = "SELECT p FROM Partita p "
            + "WHERE p.risultato = :risultato"),
    @NamedQuery(name = TROVA_MOSSE, query = "SELECT p FROM Partita p "
            + "WHERE p.mossePartita = :mosse"),
    @NamedQuery(name = TROVA_SOMMA_RATING, query = "SELECT p FROM Partita p "
            + "WHERE (p.ratingG1 + p.ratingG2) > 2300"),
    @NamedQuery(name = TROVA_CONCLUSE, query = "SELECT p FROM Partita p "
            + "WHERE p.partitaConclusa = true")
})
@XmlRootElement
public class Partita implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final String TROVA_TUTTI = "Partita.trovaTutti";
    public static final String TROVA_ID = "Partita.trovaPerId";
    public static final String TROVA_TIPO = "Partita.trovaPerTipo";
    public static final String TROVA_G1 = "Partita.trovaPerGiocatore1";
    public static final String TROVA_G2 = "Partita.trovaPerGiocatore2";
    public static final String TROVA_RISULTATO = "Partita.trovaPerRisultato";
    public static final String TROVA_MOSSE = "Partita.trovaPerMosse";
    public static final String TROVA_SOMMA_RATING = "Partita.trovaPerSommaRating";
    public static final String TROVA_CONCLUSE = "Partita.trovaPartiteConcluse";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String tipoPartita;
    private String nomeGiocatore1;
    private String nomeGiocatore2;
    private String mossePartita;
    private Integer ratingG1;
    private Integer ratingG2;
    private String risultato;
    private Boolean partitaConclusa;

    public Partita() {
    }

    public Partita(String p, String nome1, String nome2, int rating1, int rating2,
            String mosse, String risultato, Boolean conclusa) {

        this.tipoPartita = p;
        this.nomeGiocatore1 = nome1;
        this.nomeGiocatore2 = nome2;
        this.mossePartita = mosse;
        this.ratingG1 = rating1;
        this.ratingG2 = rating2;
        this.risultato = risultato;
        this.partitaConclusa = conclusa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoPartita() {
        return tipoPartita;
    }

    public void setTipoPartita(String tipoPartita) {
        this.tipoPartita = tipoPartita;
    }

    public String getNomeGiocatore1() {
        return nomeGiocatore1;
    }

    public void setNomeGiocatore1(String nomeGiocatore1) {
        this.nomeGiocatore1 = nomeGiocatore1;
    }

    public String getNomeGiocatore2() {
        return nomeGiocatore2;
    }

    public void setNomeGiocatore2(String nomeGiocatore2) {
        this.nomeGiocatore2 = nomeGiocatore2;
    }

    public String getMossePartita() {
        return mossePartita;
    }

    public void setMossePartita(String mossePartita) {
        this.mossePartita = mossePartita;
    }

    public Integer getRatingG1() {
        return ratingG1;
    }

    public void setRatingG1(Integer ratingG1) {
        this.ratingG1 = ratingG1;
    }

    public Integer getRatingG2() {
        return ratingG2;
    }

    public void setRatingG2(Integer ratingG2) {
        this.ratingG2 = ratingG2;
    }

    public String getRisultato() {
        return risultato;
    }

    public void setRisultato(String risultato) {
        this.risultato = risultato;
    }

    public Boolean getPartitaConclusa() {
        return partitaConclusa;
    }

    public void setPartitaConclusa(Boolean partitaConclusa) {
        this.partitaConclusa = partitaConclusa;
    }

    @Override
    public String toString() {
        return "Partita{" + "id=" + id + ", tipoPartita=" + tipoPartita + ", nomeGiocatore1=" + nomeGiocatore1 + ", nomeGiocatore2=" + nomeGiocatore2 + ", mossePartita=" + mossePartita + ", ratingG1=" + ratingG1 + ", ratingG2=" + ratingG2 + ", risultato=" + risultato + ", partitaConclusa=" + partitaConclusa + '}';
    }

}
