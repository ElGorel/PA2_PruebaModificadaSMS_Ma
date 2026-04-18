package uce.edu.ec.api.bodega;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {

    public static void main(String[] args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private PedidoService pedidoService;

        @Inject
        private PagoTarjetaCredito pagoc;
        
        @Inject
        private PagoEfectivo pagoe;

        @Override
        public int run(String... args) {

            // CASO 1: Tiene destino registrado -> Debería generar factura PDF
            System.out.println("\n--- PRUEBA 1: CLIENTE CON EMAIL ---");
            Pedido pedido1 = new Pedido("Marco Andrade", "Ps5", 1200, "maandradeq1@uce.edu.ec");
            pedidoService.registrar(pedido1, pagoe);

            // CASO 2: NO tiene destino (null) -> Debería generar comprobante FÍSICO
            System.out.println("\n--- PRUEBA 2: CLIENTE SIN EMAIL ---");
            // Pasamos null en el destino para activar la lógica de comprobante físico
            Pedido pedido2 = new Pedido("Juan Perez", "Pilsener 3 Javas", 80, null);
            pedidoService.registrar(pedido2, pagoc);

            // CASO 3: Tiene destino pero es una cadena vacía "" -> Debería generar comprobante FÍSICO
            System.out.println("\n--- PRUEBA 3: CLIENTE CON EMAIL VACÍO ---");
            Pedido pedido3 = new Pedido("Ana Gomez", "Pilsener Java", 40, "");
            pedidoService.registrar(pedido3, pagoe);

            return 0;
        }
    }
}


