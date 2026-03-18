package TP1;

public abstract class TarjetaDeCredito {
    public abstract  double calcularDescuento(Pedido pedido);

    public class Visa extends TarjetaDeCredito{
        @Override
        public double calcularDescuento(Pedido pedido){
            return pedido.calcularBebidas() * 0.03;
        }
    }

    public class Mastercard extends TarjetaDeCredito{
        @Override
        public double calcularDescuento(Pedido pedido){
            return pedido.calcularPlatos() * 0.02;

        }
    }

    public class ComarcaPlus extends TarjetaDeCredito{
        @Override
        public double calcularDescuento(Pedido pedido){
            return pedido.calcularTotal() * 0.02;
        }
    }

    public class Viedma extends TarjetaDeCredito{
        @Override
        public double calcularDescuento(Pedido pedido){
            return 0;
        }
    }


}

