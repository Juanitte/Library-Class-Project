package model;
import java.io.Serializable;
import java.util.ArrayList;

import interfaces.iRepo;
import model.DTO.BookCopy;
import model.DTO.Item;
import model.DTO.Magazine;
import model.DTO.User;
import util.Utils;

public class RepoLibrary implements iRepo, Serializable{
	
	private ArrayList<Item> items;
	private ArrayList<User> users;
	
	
	public RepoLibrary() {
		this.items  = new ArrayList<Item>();
		this.users = new ArrayList<User>();
	}
	
	public RepoLibrary(ArrayList<Item> items, ArrayList<User> users) {
		super();
		this.items = items;
		this.users = users;
	}		

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	/**
	 * Method that adds an item (BookCopy or Magazine) to the list.
	 * @param item , BookCopy or Magazine to add.
	 * @return boolean checking whether it's done or not.
	 */
	
	@Override
	public boolean itemAdd(Item item) {
		boolean isDone = false;
				
		if(items.size() > 200) {
			Utils.showMessage("There's no room for more items");
		}else {
			isDone = true;
			items.add(item);
		}
		
		return isDone;
	}
	
	/**
	 * Method that searchs for an item given a code.
	 * @param code , the code to look for.
	 * @return the item or null if it doesn't exists.
	 */
	
	@Override
	public Item itemSearchByCode(int code) {
		
		for(Item i : items) {
			if(i.getCode() == code) {
				return i;
			}
		}
		return null;		
	}
	
	/**
	 * Method that searchs for an item given a title.
	 * @param title , the title to look for.
	 * @return the item or null if it doesn't exists.
	 */
	
	@Override
	public Item itemSearchByTitle(String title) {
		
		for(Item i : items) {
			if(i.getTitle().contentEquals(title)) {
				return i;
			}
		}
		return null;		
	}
	
	/**
	 * Method that checks if the given item is duplicate or not.
	 * @param item , the item to check.
	 * @return a boolean true if it's duplicated or false if it's not.
	 */
	
	@Override
	public boolean itemIsDuplicate(Item item) {
		
		for(Item i : items) {
			if(i.equals(item)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method that shows a given item.
	 * @param item , the item to show.
	 */
	
	@Override
	public void itemShow(Item item) {
		
			Utils.showMessage("");
			Utils.showMessage(item.toString());
			Utils.showMessage("");
	}
	
	/**
	 * Method that shows every item in the library.
	 */
	
	@Override
	public void libraryShow() {
		
		Utils.showMessage("");
		
		for(Item i : items) {
			if(!i.isBook(i)) {
				Utils.showMessage(((Magazine) i).toString());
			}else {
				Utils.showMessage(((BookCopy) i).toString());
			}
			Utils.showMessage("");
		}
		
	}
	
	/**
	 * Method that checks the position of an item in a list.
	 * @param item , the item to find.
	 * @return the item's position in the list.
	 */
	
	@Override
	public int getItemPos(Item item) {
		int pos = 0;
		boolean isDone = false;
		
		for(Item i : items) {
			if(i == item) {
				isDone = true;
			}
			if(!isDone) {
				pos++;
			}
		}
		
		return pos;
	}
	
	/**
	 * Method that checks the position of an item in a list.
	 * @param item , the item to find.
	 * @return the item's position in the list.
	 */
	
	@Override
	public int getUserPos(User user) {
		int pos = 0;
		boolean isDone = false;
		
		for(User i : users) {
			if(i == user) {
				isDone = true;
			}
			if(!isDone) {
				pos++;
			}
		}
		
		return pos;
	}
	
	
	/**
	 * Method that modifies a BookCopy.
	 * @param book , the book to modify.
	 * @return a boolean that checks if it's done or not.
	 */
	
	@Override
	public boolean bookModify(BookCopy book, int pos) {
		boolean isDone = false;
		
		if(!book.isTaken()) {
			String title = Utils.stringInput("New Title: ");
			int releaseYear = Utils.intInput("New Release Year: ");
			String isbn = Utils.stringInput("New ISBN: ");
			int bookshelvesNum = Utils.intInput("New Bookshelves Number: ");
			
			BookCopy newBook = new BookCopy(title, releaseYear, isbn, bookshelvesNum);
			
			items.set(pos, newBook);
			isDone = true;
	
			Utils.showMessage("");
			Utils.showMessage("Book modified succesfully");
			Utils.showMessage("");
		
		}else {
			Utils.showMessage("That book's lent");
		}
		
		return isDone;
	}
	
	/**
	 * Method that modifies a Magazine.
	 * @param magazine , the magazine to modify.
	 * @return a boolean that checks if it's done or not.
	 */
	
	@Override
	public boolean magazineModify(Magazine magazine, int pos) {
		boolean isDone = false;
		
		String title = Utils.stringInput("New Title: ");
		String edition = Utils.stringInput("New Edition: ");
		
		Magazine newMagazine = new Magazine(title, edition);
		
		items.set(pos, newMagazine);
		
		Utils.showMessage("");
		Utils.showMessage("Magazine modified succesfully");
		Utils.showMessage("");
		isDone = true;
		
		return isDone;
	}
	
	/**
	 * Method that searchs for an user in the list.
	 * @param dni , the dni to look for.
	 * @return the user or null if it's not there.
	 */
	
	@Override
	public User userSearch(String dni) {
		
		for(User i : users) {
			if(i.getDni().contentEquals(dni)) {
				return i;
			}
		}
		
		return null;
	}
	
	/**
	 * Method that shows a given user.
	 * @param user , the user to show.
	 */
	
	@Override
	public void userShow(User user) {
		
			Utils.showMessage("");
			Utils.showMessage(user.toString());
			Utils.showMessage("");
	}
	
	/**
	 * Method that checks if the given user is duplicate or not.
	 * @param user , the user to check.
	 * @return a boolean true if it's duplicated or false if it's not.
	 */
	
	@Override
	public boolean userIsDuplicate(User user) {
		
		for(User i : users) {
			if(i.equals(user)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method that shows every user in the library.
	 */
	
	@Override
	public void userShowAll() {
		
		Utils.showMessage("");
		
		for(User i : users) {
			Utils.showMessage(i.toString());
			Utils.showMessage("");
		}
		
	}
	
	/**
	 * Method that modifies a BookCopy.
	 * @param book , the book to modify.
	 * @return a boolean that checks if it's done or not.
	 */
	
	@Override
	public boolean userModify(User user, int pos) {
		boolean isDone = false;

		String dni = Utils.stringInput("New DNI: ");
		String name = Utils.stringInput("New Name: ");
		String surname = Utils.stringInput("New Surname: ");
		String phoneNum = Utils.stringInput("New Phone Number: ");
		String email = Utils.stringInput("New Email: ");
			
		User newUser = new User(dni, name, surname, phoneNum, email);
			
		users.set(pos, newUser);
		isDone = true;
	
		Utils.showMessage("");
		Utils.showMessage("Book modified succesfully");
		Utils.showMessage("");
		
		return isDone;
	}
	
	/**
	 * Method that lends a book to an user.
	 * @param user , the selected user , book , the selected book.
	 */

	@Override
	public void lendBook(User user, BookCopy book) {
		user.setLentBook(book);
		
		book.setTaken(true);
		book.setTakenDate(Utils.stringInput("Current date: "));
		book.setHolder(user);
	}
	
	/**
	 * Method that retrieves a book from an user.
	 * @param 
	 */

	@Override
	public void retrieveBook(User user, BookCopy book) {
		user.setLentBook(null);
		book.setHolder(null);
		book.setTaken(false);
		book.setTakenDate(null);
	}
	
	/**
	 * Method that checks if an user has a lent book already.
	 * @param user , the user to be checked.
	 * @return a boolean checking if the user has a lent book or not.
	 */

	@Override
	public boolean checkUser(User user) {
		boolean isLent = false;
		
		if(user.getLentBook() != null) {
			isLent = true;
		}
		
		return isLent;
	}
	
	/**
	 * Method that checks if book is lent already.
	 * @param user , the user to be checked.
	 * @return a boolean checking if the user has a lent book or not.
	 */

	@Override
	public boolean checkBook(BookCopy book) {
		boolean isLent = false;
		
		if(book.getHolder() != null) {
			isLent = true;
		}
		
		return isLent;
	}
}