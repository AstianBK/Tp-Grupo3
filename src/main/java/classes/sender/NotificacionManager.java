package classes.sender;


import classes.sender.message.NotificacionEmail;
import classes.sender.message.NotificacionMessage;

import javax.mail.Session;
import java.util.Properties;

public class NotificacionManager {

    public NotificacionMessage mail;

    public NotificacionManager(NotificacionMessage email){
        this.mail=email;
    }
    public void sendMail(Channel channel){
        if (channel==Channel.EMAIL){
            NotificacionEmail email=mail.adapterEmail(Session.getDefaultInstance(new Properties()),new Properties());
            EmailSender.sendMessage(email);
        }
    }
    enum Channel{
        WHATAPPS,
        EMAIL;
    }
}
