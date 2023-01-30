package model.DTO;

import java.io.Serializable;

public class User implements Serializable {

	private String dni;
	private String name;
	private String surname;
	private String phoneNum;
	private String email;
	private BookCopy lentBook;
	
	
	public User() {
		this.dni = "";
		this.name = "";
		this.surname = "";
		this.phoneNum = "";
		this.email = "";
		this.lentBook = null;
	}
	
	public User(String dni, String name, String surname, String phoneNum, String email) {
		super();
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.phoneNum = phoneNum;
		this.email = email;
		this.lentBook = null;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BookCopy getLentBook() {
		return lentBook;
	}

	public void setLentBook(BookCopy lentBook) {
		this.lentBook = lentBook;
	}

	@Override
	public String toString() {
		if(this.lentBook != null) {
			return "USER:\n\tDNI: " + dni + "\n\tName: " + name + "\n\tSurname: " + surname + "\n\tPhone number: " + phoneNum + "\n\tEmail: " + email + "\n\tLent Book: " + this.getLentBook().getCode() + " - " + this.getLentBook().getTitle();
		}else {
			return "USER:\n\tDNI: " + dni + "\n\tName: " + name + "\n\tSurname: " + surname + "\n\tPhone number: " + phoneNum + "\n\tEmail: " + email + "\n\tLent Book: None";
		}
	}
	
	@Override
	public boolean equals(Object o) {
		boolean isEqual = false;
		User user = (User) o;
		
		if(this == o) {
			isEqual = true;
		}
		
		if(!isEqual) {
			if(this.getClass() == o.getClass()) {
				if(this != null && o != null) {
					if(this.getDni() == user.getDni()) {
						if(this.getName() == user.getName()) {
							if(this.getSurname() == user.getSurname()) {
								if(this.getPhoneNum() == user.getPhoneNum()) {
									if(this.getEmail() == user.getEmail()) {
										if(this.getLentBook() == user.getLentBook()) {
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
		
		return isEqual;
	}
}