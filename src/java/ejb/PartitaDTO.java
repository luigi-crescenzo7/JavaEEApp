
package ejb;

import java.io.Serializable;

public class PartitaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String risultato;
    private String mosse;

    public PartitaDTO(int id, String risultato, String mosse) {
        this.id = id;
        this.risultato = risultato;
        this.mosse = mosse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRisultato() {
        return risultato;
    }

    public void setRisultato(String risultato) {
        this.risultato = risultato;
    }

    public String getMosse() {
        return mosse;
    }

    public void setMosse(String mosse) {
        this.mosse = mosse;
    }
    
    @Override
    public String toString() {
        return "PartitaDTO{" + "id=" + id + ", risultato=" + risultato + ", mosse=" + mosse + '}';
    }
}
