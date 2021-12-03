package org.generation.italy.event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammEventi {
	
		private String titolo;
		private List<Evento> eventi ;
		
		public ProgrammEventi(String titolo) {
			this.titolo=titolo;
			this.eventi = new ArrayList<Evento>();
		}
		
		public void aggiungiEvento (LocalDate data,String titolo,int postiTotali) {

			try {
				eventi.add(new Evento(titolo,data,postiTotali));
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
//		public String EventiIlGiorno(LocalDate data)throws Exception {
//			if (for (Evento e : eventi) {
//				e.getData().equals(data);
//			})
//			for (Evento e : eventi) {
//				if (e.getData().equals(data)) {
//					return e.getTitolo();
//				}
//			}
//		}
		
		public int numeroEventi () {
			return eventi.size();
		}
		
		
		public void azzeraLista () {
			eventi.clear();
		}
		
		public String mostraLista()  {
			if (eventi.size()> 0) {
				for (Evento e : eventi) {
					return e.toString() + "\n";
				}
				
				return "x";
			}else {
				return "nessun elemento presente nella lista"	;
			}
			
		}
		
		
	

}
