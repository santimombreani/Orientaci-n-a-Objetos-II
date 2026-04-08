package Test;

import TP1PUNTO2.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestauranteTest {
    @Test
    public void testDescuentoVisa(){
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
        AlmacenDeCosto almacen = new AlmacenDeCosto("pedido.txt");


        Pedido pedido1 = new Pedido(listaPlato, listaBebida,almacen);
        pedido1.calcularTotal();
        TarjetaDeCredito visa = new TarjetaDeCredito.Visa();
        assertEquals(1.2, visa.calcularDescuento(pedido1));//40 * 0.03 = 1.2

    }

    @Test
    public void testDescuentoMastercard() {
        ItemMenu bebida = new ItemMenu("Pepsi", 20, "bebida");
        ItemMenu plato = new ItemMenu("Pizza", 30, "plato");

        LineaDePedido pedidoBebida = new LineaDePedido(bebida, 2);
        LineaDePedido pedidoPlato = new LineaDePedido(plato, 1);

        List<LineaDePedido> listaBebida = new ArrayList<>();
        listaBebida.add(pedidoBebida);
        List<LineaDePedido> listaPlato = new ArrayList<>();
        listaPlato.add(pedidoPlato);
        AlmacenDeCosto almacen = new AlmacenDeCosto("pedido.txt");

        Pedido pedido = new Pedido(listaPlato, listaBebida,almacen);
        pedido.calcularTotal();

        TarjetaDeCredito mastercard = new TarjetaDeCredito.Mastercard();
        assertEquals(0.6, mastercard.calcularDescuento(pedido)); // 30 * 0.02 = 0.6
    }

    @Test
    public void testDescuentoComarcaPlus() {
        ItemMenu bebida = new ItemMenu("Pepsi", 20, "bebida");
        ItemMenu plato = new ItemMenu("Pizza", 30, "plato");

        LineaDePedido pedidoBebida = new LineaDePedido(bebida, 2);
        LineaDePedido pedidoPlato = new LineaDePedido(plato, 1);

        List<LineaDePedido> listaBebida = new ArrayList<>();
        listaBebida.add(pedidoBebida);
        List<LineaDePedido> listaPlato = new ArrayList<>();
        listaPlato.add(pedidoPlato);
        AlmacenDeCosto almacen = new AlmacenDeCosto("pedido.txt");

        Pedido pedido = new Pedido(listaPlato, listaBebida,almacen);
        pedido.calcularTotal();

        TarjetaDeCredito comarcaPlus = new TarjetaDeCredito.ComarcaPlus();
        assertEquals(1.4, comarcaPlus.calcularDescuento(pedido), 0.00001); // 70 * 0.02 = 1.4
    }

    @Test
    public void testDescuentoViedma() {
        ItemMenu bebida = new ItemMenu("Pepsi", 20, "bebida");
        ItemMenu plato = new ItemMenu("Pizza", 30, "plato");

        LineaDePedido pedidoBebida = new LineaDePedido(bebida, 2);
        LineaDePedido pedidoPlato = new LineaDePedido(plato, 1);

        List<LineaDePedido> listaBebida = new ArrayList<>();
        listaBebida.add(pedidoBebida);
        List<LineaDePedido> listaPlato = new ArrayList<>();
        listaPlato.add(pedidoPlato);
        AlmacenDeCosto almacen = new AlmacenDeCosto("pedido.txt");

        Pedido pedido = new Pedido(listaPlato, listaBebida,almacen);

        TarjetaDeCredito viedma = new TarjetaDeCredito.Viedma();
        assertEquals(0, viedma.calcularDescuento(pedido)); // 0
    }

}
