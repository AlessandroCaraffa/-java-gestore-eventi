package org.generation.italy.event;

import java.time.LocalDate;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		LocalDate provaa = LocalDate.parse("11/10/1993");
		
		String nomeEvento;
		Evento evento= null;
		do {
			System.out.println("Iseririre nome evento:");
			nomeEvento = scan.nextLine();
			System.out.println("Inserire numero posti disponibili:");
			int postiDisponibili = Integer.parseInt(scan.nextLine());
			System.out.println("Inserire giorno evento:");
			int giornoEvento = Integer.parseInt(scan.nextLine());
			System.out.println("Inserire mese evento:");
			int meseEvento = Integer.parseInt(scan.nextLine());
			System.out.println("Inserire anno evento:");
			int annoEvento = Integer.parseInt(scan.nextLine());
			LocalDate dataEvento;
			dataEvento = LocalDate.of(annoEvento, meseEvento, giornoEvento);
			
			try {
				evento = new Evento(nomeEvento, dataEvento, postiDisponibili);
				System.out.println(evento.toString());

			} catch (Exception e) {

				System.out.println(e.getMessage());;
				
			} 
		}while (evento==null);
		
		
		
		System.out.println("Intende effettuare una prenotazione per:" + nomeEvento + "?(s/n)");
		String vuolePrenotare = scan.nextLine();
		
		if(vuolePrenotare.equals("s")) {
			System.out.println("Per quante persone?");
			int numPrenotazioni = Integer.parseInt(scan.nextLine());
			for (int i = 0; i < numPrenotazioni;i++) {
				try {
					evento.prenota();
					
				} catch (Exception e) {
					
					e.printStackTrace();
					System.exit(1);                    //migliorare
				}
			}
			System.out.println("ha effettuato una prenotazione per : " + numPrenotazioni + " persone.");
		}
		
		System.out.println("Posti prenotati: " +evento.getPostiPrenotati());
		System.out.println("Posti disponibili: " + (evento.getPostiTotali()-evento.getPostiPrenotati()));
		
		System.out.println("Vuole disdire delle prenotazioni?(s/n)");
		String rispDisdire = scan.nextLine();
		if(rispDisdire.equals("s")) {
			System.out.println("Quante prenotazioni vuole disdire?");
			int numDisdette = Integer.parseInt(scan.nextLine());
			for(int i= 0;i<numDisdette;i++)
				try {
					evento.disdici();
				}catch (Exception e) {
					e.printStackTrace();
					System.exit(1);               //milgiorare
				}
		}
		System.out.println("Posti prenotati: " +evento.getPostiPrenotati());
		System.out.println("Posti disponibili: " + (evento.getPostiTotali()-evento.getPostiPrenotati()));
	    
		
//		System.out.println(dataEvento.compareTo(LocalDate.now()));
//		String stampa = evento.toString();
//		System.out.println(stampa);
//		System.out.println(evento.getData());
		scan.close();

	}

}
