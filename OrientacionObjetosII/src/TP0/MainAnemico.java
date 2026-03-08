package TP0;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MainAnemico {
    public static void main(String[] args) {
        LocalDate hoy = LocalDate.now();
        TiempoAnemico tiempo = new TiempoAnemico(hoy.getDayOfMonth(), hoy.getMonthValue(), hoy.getYear());

        DateTimeFormatter largo = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        DateTimeFormatter corto = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        LocalDate fecha = LocalDate.of(tiempo.getAnio(), tiempo.getMes(), tiempo.getDia());
        System.out.println(fecha.format(largo));
        System.out.println(fecha.format(corto));
    }
}

//En el caso anemico la logica esta separada de la clase Tiempo