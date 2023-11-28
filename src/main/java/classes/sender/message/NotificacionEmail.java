package classes.sender.message;

import classes.Incidente;

import javax.mail.Session;
import java.util.Properties;

public class NotificacionEmail extends NotificacionMessage{
    public Session session;
    public Properties props;
    public NotificacionEmail(String titulo, String message, boolean isSend, Incidente incidente, Session session, Properties prop) {
        super(titulo, message, isSend, incidente);
        this.session=session;
        this.props=prop;
    }
    public String build(){
        String s1="\n"+this.getTitulo()+"\n"+this.getMessage();
        return s1;
    }
}
