package com.edu.uce.negocio;

public class NotificadorSms {

    public void enviarSMS(String celular, String mensaje) {
        System.out.println("Se envia el SMS al celular: " + celular);
        System.out.println("Con el mensaje: " + mensaje);
    }

}
