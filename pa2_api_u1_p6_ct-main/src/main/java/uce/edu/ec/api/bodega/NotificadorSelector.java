package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class NotificadorSelector {

    @Inject
    private NotificadorMail mail;
    @Inject
    private NotificadorSms sms;

    public Notificador selecionar(double total) {

        if (total > 100) {
            // Lógica para enviar notificación por email
            return mail;
        } else {
            // Lógica para enviar notificación por SMS (cuando es menor o igual a 100)
            return sms;
        }
    }

}
