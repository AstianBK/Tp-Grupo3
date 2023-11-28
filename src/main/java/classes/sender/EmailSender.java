package classes.sender;

import classes.sender.message.NotificacionEmail;
import classes.sender.message.NotificacionMessage;

public class EmailSender {
    public static void sendMessage(NotificacionEmail message){
        System.out.print("\nSe notifico al tecnico\n"+message.build());
    }
}
