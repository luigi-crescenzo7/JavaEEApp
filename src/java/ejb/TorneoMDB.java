package ejb;

import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class TorneoMDB implements MessageListener {

    @Inject
    private TorneoEJB service;

    @Inject
    private Event<Partita> event;

    public TorneoMDB() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            PartitaDTO dto = message.getBody(PartitaDTO.class);
            Partita p = service.trovaPerId(dto.getId());
            p.setMossePartita(p.getMossePartita() + " " + dto.getMosse());
            p.setRisultato(dto.getRisultato());

            System.out.println(service.aggiornaPartita(p));

            event.fire(p);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
