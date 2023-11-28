package classes.sender.message;

import classes.Incidente;
import lombok.Data;

import javax.mail.Session;
import java.util.Properties;

@Data
public class NotificacionMessage {
    private String message;
    private boolean isSend;
    private Incidente incidente;
    private String titulo;
    public NotificacionMessage(String titulo, String message, boolean isSend, Incidente incidente){
        this.message=message;
        this.isSend=isSend;
        this.incidente=incidente;
        this.titulo=titulo;
    }
    public NotificacionEmail adapterEmail(Session session, Properties props){
        return new NotificacionEmail(titulo,message,isSend,incidente,session,props);
    }
}
