package model.DTO;

import java.io.Serializable;

public class Book extends Item implements Serializable {

	protected boolean taken;
	protected int releaseYear;
	protected String isbn;
	protected String takenDate;
	
	
	public Book() {
		super();
		this.taken = false;
		this.releaseYear = 0;
		this.isbn = "";
		this.takenDate = "";
	}
	public Book(String title, int releaseYear, String isbn) {
		super(title);
		this.taken = false;
		this.releaseYear = releaseYear;
		this.isbn = isbn;
		this.takenDate = "";
	}
	
	
	public boolean isTaken() {
		return taken;
	}
	
	public void setTaken(boolean taken) {
		this.taken = taken;
	}
	
	public int getReleaseYear() {
		return releaseYear;
	}
	
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTakenDate() {
		return takenDate;
	}
	
	public void setTakenDate(String takenDate) {
		this.takenDate = takenDate;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n\tISBN: " + isbn + "\n\tRelease year: " + releaseYear + "\n\tTaken: " + taken + "\n\tTaken since: " + takenDate;
	}
	
	
}