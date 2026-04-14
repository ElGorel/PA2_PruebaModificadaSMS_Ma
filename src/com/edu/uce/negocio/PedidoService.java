package com.edu.uce.negocio;

public class PedidoService {

    private NotificadorMail n1 = new NotificadorMail();
    private NotificadorSms n2 = new NotificadorSms();

    public void registrar(Pedido pedido) {
        System.out.println("Registrando pedido ");
        System.out.println("Cliente: " + pedido.getCliente());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Guardando en la base de datos");

        if (pedido.getTotal() > 100) {
            // Lógica para enviar notificación por email
            n1.enviar(pedido.getCorreo(), "Se ha creado un pedido para ser atendido");
        } else {
            // Lógica para enviar notificación por SMS (cuando es menor o igual a 100)
            // Asumo que tienes un método enviarSMS y una forma de obtener el número
            n2.enviarSMS(pedido.getCelular(), "Se ha creado un pedido para ser atendido");
        }
    }
}

// cuando el pedido sea mayor a 100$ se envie la notificacion por mail,
// pero cuando es menor o igual a 100 se envie una notificacion por SMS