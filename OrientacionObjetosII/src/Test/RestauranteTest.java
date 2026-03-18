package Test;

import TP1.ItemMenu;
import TP1.LineaDePedido;
import TP1.Pedido;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RestauranteTest {
    @Test
    public void testCalculoTarjeta(){
        //Creo items
        ItemMenu bebida = new ItemMenu("Pepsi", 20,"bebida");
        ItemMenu plato = new ItemMenu("Pizza", 30, "plato");

        //Creo Pedido
        LineaDePedido pedidoBebida = new LineaDePedido(bebida, 2);
        LineaDePedido pedidoPlato = new LineaDePedido(plato, 1);

        List<LineaDePedido> listaBebida = new ArrayList<>();
        listaBebida.add(pedidoBebida);
        List<LineaDePedido> listaPlato = new ArrayList<>();
        listaPlato.add(pedidoPlato);

        Pedido pedido1 = new Pedido(listaPlato, listaBebida);
        System.out.println("Total Pedido: " + pedido1.calcularTotal());

    }


}
