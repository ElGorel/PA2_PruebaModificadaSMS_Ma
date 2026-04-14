package com.edu.uce.negocio;

public class NotificadorMail {

    public void enviar(String correo, String mensaje) {
        System.out.println("Se envia el mail al correo: " + correo);
        System.out.println("Con el mensaje: " + mensaje);
    }

}
