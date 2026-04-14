import com.edu.uce.negocio.Pedido;
import com.edu.uce.negocio.PedidoService;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Pedido p1 = new Pedido("Marco Andrade", "PS5", 95, "maandradeq1@gmail.com", "099856332547");

        PedidoService service = new PedidoService();

        service.registrar(p1);
    }
}
