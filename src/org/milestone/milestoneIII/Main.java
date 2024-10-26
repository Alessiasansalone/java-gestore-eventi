package org.milestone.milestoneIII;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		
		// Interazione con utente
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Ciao! Inserisci un nuovo evento. \n"
				+ "NOME: ");
		String newName = scan.next();
		
		System.out.println("GIORNO: ");
		int day = scan.nextInt();
		
		System.out.println("MESE (in numeri): ");
		int month = scan.nextInt();
		
		System.out.println("ANNO: ");
		int year = scan.nextInt();
		
		LocalDate newDate = LocalDate.of(year, month, day);
		
		System.out.println("POSTI TOTALI: ");
		int totalSeat = scan.nextInt();
		
		Event newEvent = new Event(newName, newDate, totalSeat);
		
		// Controllo data e creazione evento
		newEvent.controlDate();
		
		System.out.println("Nuovo evento creato, codice: " + newEvent.toString());
		
		// Gestione prenotazioni		
		int availableSeats = newEvent.totalSeatNumber;
		
		System.out.println("Vuoi prenotare uno o più biglietti? \n"
				+ "1) Sì \n"
				+ "2) No");
		
		int choice = scan.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("Quanti posti?");
			int seats = scan.nextInt();
			availableSeats = newEvent.totalSeatNumber - seats;
			break;
		case 2:
			System.out.println("Posti prenotati: " + newEvent.reservedSeatNumber + "\n"
					+ "Posti disponibili " + availableSeats);
		}
		System.out.println("Posti prenotati: " + newEvent.reservedSeatNumber + "\n"
				+ "Posti disponibili " + availableSeats);
	}

}
