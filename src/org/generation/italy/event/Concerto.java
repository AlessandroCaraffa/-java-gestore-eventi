package org.generation.italy.event;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento {
	LocalTime ora;
	BigDecimal prezzo;
	
	
	
	public Concerto(String titolo,LocalDate data,int postiTotali,LocalTime ora,BigDecimal prezzo) throws Exception{
		super(titolo,data,postiTotali);
		this.ora= ora;
		this.prezzo = prezzo;
		
	}

}
