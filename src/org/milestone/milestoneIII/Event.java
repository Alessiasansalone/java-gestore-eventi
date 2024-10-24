package org.milestone.milestoneIII;

import java.time.LocalDate;

public class Event {

	public String title;
	public LocalDate date;
	protected int totalSeatNumber;
	protected int reservedSeatNumber = 0;
	
	protected Event (String title, LocalDate date, int totalSeatNumber) {
		this.title = title;
		this.date = date;
		this.totalSeatNumber = totalSeatNumber;
	}
	
	// Exceptions
	protected LocalDate controlDate() {
		
		LocalDate currentDate = LocalDate.now();
		
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
	
	// Getter e Setter
	public String getTitle() {
		setTitle("Nuovo evento");
		return title;
	}

	private void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		setDate(LocalDate.now());
		return date;
	}

	private void setDate(LocalDate date) {
		this.date = date;
	}

	protected int getTotalSeatNumber() {
		setTotalSeatNumber(0);
		return totalSeatNumber;
	}

	private void setTotalSeatNumber(int totalSeatNumber) {
		this.totalSeatNumber = totalSeatNumber;
	}

	protected int getReservedSeatNumber() {
		setReservedSeatNumber(0);
		return reservedSeatNumber;
	}

	private void setReservedSeatNumber(int reservedSeatNumber) {
		this.reservedSeatNumber = reservedSeatNumber;
	}
	
	// Reservation
	protected int reservationSeat() {
		
		reservedSeatNumber = reservedSeatNumber + 1;
		return reservedSeatNumber;
	}
	
	protected int cancelReservation() {
		
		reservedSeatNumber = reservedSeatNumber - 1;
		return reservedSeatNumber;
	}

	@Override
	public String toString() {
		return "Event [title=" + title + ", date=" + date + "]";
	}
	
	
}
