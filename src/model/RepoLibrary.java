package model;


import java.io.Serializable;

import interfaces.iRepo;
import model.DTO.BookCopy;
import model.DTO.Item;
import model.DTO.Magazine;
import model.DTO.User;
import util.Utils;

public class RepoLibrary implements iRepo, Serializable{
	
	private Item[] items;
	private User[] users;
	
	
	public RepoLibrary() {
		this.items  = new Item[200];
		this.users = new User[0];
	}
	
	public RepoLibrary(Item[] items, User[] users) {
		super();
		this.items = items;
		this.users = users;
	}

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}	

	@Override
	public boolean itemAdd(Item item) {
		boolean isDone = false;
		
		for(int i = 0; i < items.length && !isDone; i++) {
			if(items[i] == null) {
				items[i] = item;
				isDone = true;
			}
		}
		
		if(!isDone) {
			Utils.showMessage("There's no room for more items");
		}
		
		return isDone;
	}
	
	@Override
	public int itemSearchByCode(int code) {
		boolean isDone = false;
		int pos = -1;
		
		for(int i = 0; i < items.length && !isDone; i++) {
			if(items[i] != null) {
				if(items[i].getCode() == code) {
					isDone = true;
					pos = i;
				}
			}else {
				isDone = true;
			}
		}
		
		return pos;
	}
	
	@Override
	public int itemSearchByTitle(String title) {
		boolean isDone = false;
		int pos = -1;
		
		for(int i = 0; i < items.length && !isDone; i++) {
			if(items[i] != null) {
				if(items[i].getTitle().contentEquals(title)) {
					isDone = true;
					pos = i;
				}
			}else {
				isDone = true;
			}
		}
		
		return pos;
	}
	
	@Override
	public boolean itemIsDuplicate(Item item) {
		boolean isDuplicate = false;
		
		for(int i = 0; i < items.length && !isDuplicate; i++) {
			if(items[i] != null) {
				isDuplicate = items[i].equals(item);
			}
		}
		
		return isDuplicate;
	}
	
	@Override
	public boolean itemShow(int pos) {
		boolean isDone = false;
		
			Utils.showMessage("");
			Utils.showMessage(items[pos].toString());
			Utils.showMessage("");
			isDone = true;
		
		return isDone;
	}
	
	@Override
	public void libraryShow() {
		boolean isDone = false;
		
		Utils.showMessage("");
		
		for(int i = 0; i < items.length && !isDone; i++) {
			if(items[i] != null) {
				Utils.showMessage(items[i].toString());
				Utils.showMessage("");
			}else {
				isDone = true;
			}
		}
		
		Utils.showMessage("");
		
	}
	
	@Override
	public boolean isBook(int pos) {
		boolean isBook = false;
		
		if(pos != -1) {
			if(items[pos].getClass().getTypeName().contains("BookCopy")) {
				isBook = true;
			}
		}
		
		return isBook;
		
	}
	
	@Override
	public boolean bookModify(BookCopy book, int pos) {
		boolean isDone = false;
		
		String title = Utils.stringInput("New Title: ");
		int releaseYear = Utils.intInput("New Release Year: ");
		String isbn = Utils.stringInput("New ISBN: ");
		int bookshelvesNum = Utils.intInput("New Bookshelves Number: ");
		
		book.setTitle(title);
		book.setReleaseYear(releaseYear);
		book.setIsbn(isbn);
		book.setBookshelvesNum(bookshelvesNum);
		if(book.isTaken()) {
			String takenDate = Utils.stringInput("New Taken Date: ");
			book.setTakenDate(takenDate);
		}
		
		items[pos] = book;

		Utils.showMessage("");
		Utils.showMessage("Book modified succesfully");
		Utils.showMessage("");
		
		return isDone;
	}
	
	@Override
	public boolean magazineModify(Magazine magazine, int pos) {
		boolean isDone = false;
		
		String title = Utils.stringInput("New Title: ");
		String edition = Utils.stringInput("New Edition: ");
		
		magazine.setTitle(title);
		magazine.setEdition(edition);
		
		items[pos] = magazine;
		
		Utils.showMessage("");
		Utils.showMessage("Magazine modified succesfully");
		Utils.showMessage("");
		
		return isDone;
	}
	
	@Override
	public boolean itemDelete(int pos) {
		boolean isDone = false;
		
		items[pos] = null;
		this.itemOrganize(pos);
		isDone = true;
		
		return isDone;
		
	}
	
	@Override
	public boolean itemOrganize(int pos) {
		boolean isDone = false;
		
		if(pos != 0) {
			for(int i = pos + 1; i < items.length && !isDone; i++) {
				if(items[i] == null) {
					items[pos] = items[i - 1];
					items[i - 1] = null;
					isDone = true;
				}else if(i == items.length - 1) {
					items[pos] = items[items.length - 1];
					items[items.length - 1] = null;
					isDone = true;
				}
			}
		}else {
			isDone = true;
		}
		
		return isDone;
	}
	
	@Override
	public boolean userAdd(User user) {
		boolean isDone = false;
		
		users = usersEnlarger();
		
		users[users.length - 1] = user;
		isDone = true;
		
		return isDone;
		
	}
	
	@Override
	public User[] usersEnlarger() {
		User[] newUsers = new User[this.users.length + 1];
		
		for(int i = 0; i < users.length; i++) {
			newUsers[i] = users[i];
		}
		
		return newUsers;
	}
	
	@Override
	public int userSearch(String dni) {
		boolean isDone = false;
		int pos = -1;
		
		for(int i = 0; i < users.length && !isDone; i++) {
			if(users[i] != null) {
				if(users[i].getDni().contentEquals(dni)) {
					isDone = true;
					pos = i;
				}
			}else {
				isDone = true;
			}
		}
		
		return pos;
	}
	
	@Override
	public boolean userShow(int pos) {
		boolean isDone = false;
			Utils.showMessage("");
			Utils.showMessage(users[pos].toString());
			Utils.showMessage("");
			isDone = true;
		
		return isDone;
		
	}
	
	@Override
	public boolean userIsDuplicate(User user) {
		boolean isDuplicate = false;
		
		for(int i = 0; i < users.length && !isDuplicate; i++) {
			if(users[i] != null) {
				isDuplicate = users[i].equals(user);
			}
		}
		
		return isDuplicate;
	}
	
	@Override
	public void userShowAll() {
		boolean isDone = false;
		
		Utils.showMessage("");
		
		for(int i = 0; i < users.length && !isDone; i++) {
			if(users[i] != null) {
				Utils.showMessage(users[i].toString());
				Utils.showMessage("");
			}else {
				isDone = true;
			}
		}
		
		Utils.showMessage("");
		
	}
	
	@Override
	public boolean userModify(int pos, User user) {
		boolean isDone = false;
		
		String dni = Utils.stringInput("New DNI: ");
		String name = Utils.stringInput("New Name: ");
		String surname = Utils.stringInput("New Surname: ");
		String phoneNum = Utils.stringInput("New Phone Number: ");
		String email = Utils.stringInput("New Email: ");
		
		user.setDni(dni);
		user.setName(name);
		user.setSurname(surname);
		user.setPhoneNum(phoneNum);
		user.setEmail(email);
		
		users[pos] = user;

		Utils.showMessage("");
		Utils.showMessage("User modified succesfully");
		Utils.showMessage("");
		isDone = true;
		
		return isDone;
		
	}
	
	@Override
	public boolean userDelete(int pos) {
		boolean isDone = false;
		
		users[pos] = null;
		this.userOrganize(pos);
		isDone = true;
		
		return isDone;
		
	}

	@Override
	public boolean userOrganize(int pos) {
		boolean isDone = false;
		User[] newUsers = new User[users.length -1];
		
		if(users.length -1 != 0) {
			users[pos] = users[users.length - 1];
			users[users.length - 1] = null;
			for(int i = 0; i < newUsers.length; i++) {
				if(users[i] != null) {
					newUsers[i] = users[i];
				}
			}
			isDone = true;
		}else {
			users = newUsers;
			isDone = true;
		}
		
		return isDone;
	}

	@Override
	public boolean lendBook(int userPos, int bookPos) {
		users[userPos].setLentBook((BookCopy) items[bookPos]);
		
		((BookCopy) items[bookPos]).setTaken(true);
		((BookCopy) items[bookPos]).setTakenDate(Utils.stringInput("Current date: "));
		((BookCopy) items[bookPos]).setHolder(users[userPos]);
		
		return true;
	}

	@Override
	public boolean retrieveBook(int userPos, int bookPos) {
		users[userPos].setLentBook(null);
		((BookCopy) items[bookPos]).setHolder(null);
		((BookCopy) items[bookPos]).setTaken(false);
		((BookCopy) items[bookPos]).setTakenDate(null);
		
		return true;
	}

	@Override
	public boolean checkUser(int userPos) {
		boolean isLent = false;
		
		if(users[userPos].getLentBook() != null) {
			isLent = true;
		}
		
		return isLent;
	}

	@Override
	public boolean checkBook(int bookPos) {
		boolean isLent = false;
		
		if(((BookCopy) items[bookPos]).getHolder() != null) {
			isLent = true;
		}
		
		return isLent;
	}
}