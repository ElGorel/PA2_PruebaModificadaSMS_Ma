import com.edu.uce.negocio.Pedido;
import com.edu.uce.negocio.PedidoService;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Pedido p1 = new Pedido("Josue Bailon", "PS5", 2500, "jb@gmail.com");

        PedidoService service = new PedidoService();

        service.registrar(p1);
    }
}
