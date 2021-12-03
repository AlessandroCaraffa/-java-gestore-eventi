package org.generation.italy.event;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Evento {
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati;
	
	
	Evento(String titolo,LocalDate data,int postiTotali)throws Exception{
		
		if (LocalDate.now().isBefore(data)) {
			if (postiTotali > 0) {
				this.titolo = titolo;
				this.data = data;
				this.postiTotali = postiTotali;
				this.postiPrenotati = 0;
			}else {
				throw new IllegalArgumentException("Numero posti errato");			
			}
		}else {
			throw new IllegalArgumentException("Data errata");			
		}
		
		
	}
	
	public void prenota ()throws Exception {
		
		if (LocalDate.now().isBefore(data) ) {
			if (postiPrenotati < postiTotali) {
				postiPrenotati++;
			}else {
				throw new IllegalArgumentException("Posti esauriti");
			}
		}else {
			throw new IllegalArgumentException("Evento passato");
		}
		
	}

	public void disdici() {
		
		if (LocalDate.now().isBefore(data)) {
			if (postiPrenotati < postiTotali) {
				postiPrenotati--;
			} else {
				throw new IllegalArgumentException("Nessuna prenotazione");
			}
		} else {
			throw new IllegalArgumentException("Evento passato");
		}
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/uuuu");
		String dataFormattata = data.format(formatter);
		return dataFormattata + " - " + titolo;
	}


	
	
	
	
	
	
	
	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}
	public int getPostiTotali() {
		return postiTotali;
	}
	public int getPostiPrenotati() {
		return postiPrenotati;
	}

}
