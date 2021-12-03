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
		
		
		String vuolePrenotare;
		do {
			System.out.println("Intende effettuare una prenotazione per:" + nomeEvento + "?(s/n)");
			vuolePrenotare = scan.nextLine();
			if (vuolePrenotare.equals("s")) {
				int postiRimanentiOriginal = evento.getPostiRimanenti();
				int numPrenotazioni= 0;
				do {                //postirimanenti da aggiungere se ho tempo
					System.out.println("Per quante persone?");
					numPrenotazioni = Integer.parseInt(scan.nextLine());
					if (numPrenotazioni > 0 && numPrenotazioni <= evento.getPostiTotali()) {
						for (int i = 0; i < numPrenotazioni; i++) {
							try {
								evento.prenota();
								

							} catch (Exception e) {

								System.out.println(e.getMessage());
								break;
							}
						}
						System.out.println("ha effettuato una prenotazione per : " + numPrenotazioni + " persone.");
					}
					
					
				} while (numPrenotazioni<0 || numPrenotazioni > postiRimanentiOriginal);
			} 
		} while (!(vuolePrenotare.equals("s") || vuolePrenotare.equals("n")));
		
		
		
		System.out.println("Posti prenotati: " +evento.getPostiPrenotati());
		System.out.println("Posti disponibili: " + (evento.getPostiRimanenti()));
		
		
		
		
		String vuoleDisdire;
		do {
			System.out.println("Intende effettuare una disdetta per:" + nomeEvento + "?(s/n)");
			vuoleDisdire = scan.nextLine();
			if (vuoleDisdire.equals("s")) {
				
				int numDisdette = 0;
				int postiPrenotatiOriginal = evento.getPostiPrenotati();
				do {
					System.out.println("Per quante persone?");
					numDisdette = Integer.parseInt(scan.nextLine());
					if(numDisdette>0) {
						for (int i = 0; i < numDisdette; i++) {
							try {
								evento.disdici();
								

							} catch (Exception e) {

								System.out.println(e.getMessage());
							}
						} 
						System.out.println("ha disdetto la prenotazione per : " + numDisdette + " persone.");
					}
					
					
				} while (numDisdette<0 || numDisdette> postiPrenotatiOriginal);
			} 
		} while (!(vuoleDisdire.equals("s") || vuoleDisdire.equals("n")));
		
		

		System.out.println("Posti prenotati: " +evento.getPostiPrenotati());
		System.out.println("Posti disponibili: " + (evento.getPostiRimanenti()));
	    
	
		scan.close();

	}

}
