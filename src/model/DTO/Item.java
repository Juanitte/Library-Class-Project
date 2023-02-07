package model.DTO;

import java.io.Serializable;

public class Item implements Serializable {

	protected static int autoCode = 0;
	protected int code;
	protected String title;
	
	
	public Item() {
		this.code = Item.autoCode++;
		this.title = "";
	}
	
	public Item(String title) {
		this.code = Item.autoCode++;
		this.title = title;
	}

	public int getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "CODE: " + code + "\n\tTitle: " + title;
	}
	
	
	
	/**
	 * Method that checks if an Item is a book or not.
	 * @param item , the item to check.
	 * @return a boolean true if it's a book or false if it's not.
	 */
	
	public boolean isBook(Item item) {
		boolean isBook = false;
		
		if(item.getClass().getTypeName().contains("BookCopy")) {
			isBook = true;
		}
		
		return isBook;
		
	}
	
}