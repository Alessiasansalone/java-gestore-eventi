package org.milestone.milestoneIII;

import java.time.LocalDate;
import java.util.Scanner;

public class Event {

	public String title;
	public LocalDate date;
	protected int totalSeatNumber;
	protected int reservedSeatNumber = 0;
	protected int availableSeats = totalSeatNumber;
	
	protected Event (String title, LocalDate date, int totalSeatNumber) {
		this.title = title;
		this.date = date;
		this.totalSeatNumber = totalSeatNumber;
	}
	
	LocalDate currentDate = LocalDate.now();
	
	// Exceptions
	protected LocalDate controlDate() {
		
		if (date.isBefore(currentDate)) {
			throw new IllegalArgumentException("Questa data è già passata! "
					+ "Inseriscine una valida.");
		}
		return currentDate;
	}
	
	protected int controlSeats() {
		
		if (totalSeatNumber < 0) {
			throw new IllegalArgumentException("Non puoi inserire un numero "
					+ "negativo di posti totali!");
		}
		return totalSeatNumber;
			
		}
	
	// Getter and Setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	
	protected int getTotalSeatNumber() {
		return totalSeatNumber;
	}

	private void setTotalSeatNumber(int totalSeatNumber) {
		this.totalSeatNumber = totalSeatNumber;
	}

	
	protected int getReservedSeatNumber() {
		return reservedSeatNumber;
	}

	private void setReservedSeatNumber(int reservedSeatNumber) {
		this.reservedSeatNumber = reservedSeatNumber;
	}
	
	protected int getAvailableSeat() {
		return availableSeats;
	}

	private void setavAilableSeats(int availableSeats) {
		
		this.availableSeats = availableSeats;
	}
	
	// Reservation 
	public int reservation () {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Quanti posti?");
		int seats = scan.nextInt();
		
		setReservedSeatNumber(reservedSeatNumber + seats);		
		setTotalSeatNumber(totalSeatNumber - seats);
		
		if (date.isBefore(currentDate))  {
			
			System.err.println("Ops! La data è già passata. Inseriscine "
					+ "una valida.");
			
		} else if (reservedSeatNumber > totalSeatNumber) {
			
			System.err.println("Ci dispiace, ma non ci sono posti disponibili.");
		}
		
		return reservedSeatNumber;
	}
	
	
	// Cancel reservation
	public int cancelReservation() {
		
		setReservedSeatNumber(reservedSeatNumber -1);
		
		setTotalSeatNumber(totalSeatNumber + 1);
		
		if (date.isBefore(currentDate))  {
			
			System.err.println("Ops! La data è già passata. Inseriscine "
					+ "una valida.");
			
		} else if (reservedSeatNumber > totalSeatNumber) {
			
			System.err.println("Ci dispiace, ma non ci sono posti disponibili.");
		}
		
		return reservedSeatNumber;
	}

	
	
	@Override
	public String toString() {
		return date + " - " + title;
	}
	
	
}
