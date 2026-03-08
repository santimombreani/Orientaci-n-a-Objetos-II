package TP0;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.LocalDate;

public class TiempoNoAnemico {
	private LocalDate fecha;
	
	public TiempoNoAnemico() {
		this.fecha = LocalDate.now();
	}
	
	public String fechaLarga() {
		 DateTimeFormatter largo = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
		 return fecha.format(largo);
	}
	
	public String fechaCorta() {
		DateTimeFormatter corto = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return fecha.format(corto);
	}
}



