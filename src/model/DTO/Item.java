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
}