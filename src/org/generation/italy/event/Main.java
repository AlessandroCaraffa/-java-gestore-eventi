package org.generation.italy.event;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Iseririre nome evento:");
		String nomeEvento = scan.nextLine();
		System.out.println("Inserire numero posti disponibili:");
		int postiDisponibili = scan.nextInt();
		System.out.println("Inserire giorno evento:");
		int giornoEvento = scan.nextInt();
		System.out.println("Inserire mese evento:");
		int meseEvento = scan.nextInt();
		System.out.println("Inserire anno evento:");
		int annoEvento = scan.nextInt();
		
		LocalDate dataEvento = null; 
		dataEvento = LocalDate.of(annoEvento, meseEvento, giornoEvento);
		
		
		
		
		
		
		
		
		try {
			Evento prova = new Evento(nomeEvento, dataEvento, postiDisponibili);
			System.out.println(prova.toString());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		System.out.println(dataEvento.compareTo(LocalDate.now()));
//		String stampa = prova.toString();
//		System.out.println(prova.getData(););
		scan.close();

	}

}
