package model.DTO;

import java.io.Serializable;

public class BookCopy extends Book implements Serializable {

	private int bookshelvesNum;
	private User holder;
	
	
	public BookCopy() {
		super();
		this.bookshelvesNum = -1;
		this.holder = null;
	}
	
	public BookCopy(String title, int releaseYear, String isbn, int bookshelvesNum) {
		super(title, releaseYear, isbn);
		this.bookshelvesNum = bookshelvesNum;
		this.holder = null;
	}

	public int getBookshelvesNum() {
		return bookshelvesNum;
	}

	public void setBookshelvesNum(int bookshelvesNum) {
		this.bookshelvesNum = bookshelvesNum;
	}

	public User getHolder() {
		return holder;
	}

	public void setHolder(User holder) {
		this.holder = holder;
	}

	@Override
	public String toString() {
		if(holder != null) {
			return super.toString() + "\n\tBookshelves number: " + bookshelvesNum + "\n\tHolder:\n\t\t" + holder.toString();
		}else {
			return super.toString() + "\n\tBookshelves number: " + bookshelvesNum + "\n\tHolder: None";
		}
	}
	
	@Override
	public boolean equals(Object o) {
		boolean isEqual = false;
		
		if(this == o) {
			isEqual = true;
		}
		
		if(!isEqual) {
			if(this.getClass() == o.getClass()) {
				if(this != null && o != null) {
					BookCopy book = (BookCopy) o;
					if(this.getReleaseYear() == book.getReleaseYear()){
						if(this.getTitle() == book.getTitle()) {
							if(this.getIsbn() == book.getIsbn()) {
								if(this.isTaken() == book.isTaken()) {
									if(this.getTakenDate() == book.getTakenDate()) {
										if(this.getHolder() == book.getHolder()) {
											if(this.getBookshelvesNum() == book.getBookshelvesNum()) {
												isEqual = true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
			
		return isEqual;
	}
	
	
	
}