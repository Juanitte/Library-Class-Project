package model.DTO;

import java.io.Serializable;

public class Magazine extends Item implements Serializable {

	private String edition;

	public Magazine() {
		super();
		this.edition = "";
	}

	public Magazine(String title, String edition) {
		super(title);
		this.edition = edition;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\tEdition: " + edition;
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
					Magazine magazine = (Magazine) o;
					if(this.getEdition() == magazine.getEdition()){
						if(this.getTitle() == magazine.getTitle()) {
							isEqual = true;
						}
					}
				}
			}
		}
			
		return isEqual;
	}
	
	
}