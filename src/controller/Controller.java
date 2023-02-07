package controller;

import interfaces.iController;
import interfaces.iGUI;
import interfaces.iRepo;
import model.RepoLibrary;
import model.DTO.BookCopy;
import model.DTO.Item;
import model.DTO.Magazine;
import model.DTO.User;
import util.Utils;
import util.LocalStorage;
import view.GUI;

public class Controller implements iController{
	
	private iGUI myGUI = new GUI();
	private iRepo library = new RepoLibrary();
	
	@Override
	public void start() {
		if(LocalStorage.read() != null) {
			library = LocalStorage.read();
		}
		
		mainMenuRun();		
	}

	@Override
	public void mainMenuRun() {
		int option;
				
		do {
			myGUI.mainMenuShow();;
			option = Utils.intInput("Choose an option: ");
			mainMenuControl(option);	
		}while(option != 0);
	}

	@Override
	public void mainMenuControl(int option) {
		switch(option) {
			case 1:
				addItemMenuRun();
				LocalStorage.write((RepoLibrary)library);
				break;
				
			case 2:
				showItemMenuRun();
				break;
				
			case 3:
				library.libraryShow();
				break;
				
			case 4:
				modifyItemMenuRun();
				LocalStorage.write((RepoLibrary)library);
				break;
				
			case 5:
				deleteItemMenuRun();
				LocalStorage.write((RepoLibrary)library);
				break;
				
			case 6:
				addUserMenuRun();
				LocalStorage.write((RepoLibrary)library);
				break;
				
			case 7:
				showUserMenuRun();
				break;
				
			case 8:
				library.userShowAll();
				break;
				
			case 9:
				modifyUserMenuRun();
				LocalStorage.write((RepoLibrary)library);
				break;
				
			case 10:
				deleteUserMenuRun();
				LocalStorage.write((RepoLibrary)library);
				break;
				
			case 11:
				lendBookMenuRun();
				LocalStorage.write((RepoLibrary)library);
				break;
				
			case 12:
				retrieveBookMenuRun();
				LocalStorage.write((RepoLibrary)library);
				break;
				
			case 0:
				Utils.showMessage("");
				Utils.showMessage("Closing App...");
				LocalStorage.write((RepoLibrary)library);
				break;
				
			default: 
				 Utils.showMessage("Incorrect");
		}
		
	}
	
	@Override
	public void addItemMenuRun() {
		int option = -1;
		do {
			myGUI.addItemMenuShow();
			option = Utils.intInput("Choose an option: ");
			addItemMenuControl(option);
		}while(option < 0 || option > 2);
	}
	
	@Override
	public void addItemMenuControl(int option) {
		switch(option) {
			case 1:
				addBookMenuRun();
				break;
				
			case 2:
				addMagazineMenuRun();
				break;
				
			case 0:
				
				break;
			
			default:
				Utils.showMessage("Incorrect");
		}
	}
	
	@Override
	public void addMagazineMenuRun() {
		int option = -1;
		do {
			myGUI.addMagazineMenuShow();
			option = Utils.intInput("Choose an option: ");
			addMagazineMenuControl(option);
		}while(option < 0 || option > 1);
	}

	@Override
	public void addMagazineMenuControl(int option) {
		switch(option) {
		case 1:
			Utils.showMessage("");
			String title = Utils.stringInput("Title: ");
			addMagazineMenuRun2(title);
			break;
			
		case 0:
			
			break;
			
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void addMagazineMenuRun2(String title) {
		int option = -1;
		
		do {
			myGUI.addMagazineMenuShow2();
			option = Utils.intInput("Choose an option: ");
			addMagazineMenuControl2(option, title);
		}while(option < 0 || option > 1);
	}

	@Override
	public void addMagazineMenuControl2(int option, String title) {
		switch(option) {
		case 1:
			Utils.showMessage("");
			String edition = Utils.stringInput("Edition: ");
			addMagazineMenuRun3(title, edition);
			break;
			
		case 0:
			
			break;
			
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void addMagazineMenuRun3(String title, String edition) {
		int option = -1;
		
		do {
			myGUI.addMagazineMenuShow3();
			option = Utils.intInput("Choose an option: ");
			addMagazineMenuControl3(option, title, edition);
		}while(option < 0 || option > 1);
	}

	@Override
	public void addMagazineMenuControl3(int option, String title, String edition) {
		switch(option) {
		case 1:
			Utils.showMessage("");
			Magazine magazine = new Magazine(title, edition);
			if(!library.itemIsDuplicate(magazine)) {
				library.getItems().add(magazine);
				Utils.showMessage("Magazine added succesfully");
				Utils.showMessage("");
			}else {
				Utils.showMessage("This magazine is already listed");
			}
			break;
			
		case 0:
			
			break;
			
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void addBookMenuRun() {
		int option = -1;
		do {
			myGUI.addBookMenuShow();
			option = Utils.intInput("Choose an option: ");
			addBookMenuControl(option);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void addBookMenuControl(int option) {
		switch(option) {
		case 1:
			Utils.showMessage("");
			String title = Utils.stringInput("Title: ");
			addBookMenuRun2(title);
			break;
			
		case 0:
			
			break;
			
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void addBookMenuRun2(String title) {
		int option = -1;
		
		do {
			myGUI.addBookMenuShow2();
			option = Utils.intInput("Choose an option: ");
			addBookMenuControl2(option, title);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void addBookMenuControl2(int option, String title) {
		switch(option) {
		case 1:
			Utils.showMessage("");
			int releaseYear = Utils.intInput("Release Year: ");
			addBookMenuRun3(title, releaseYear);
			break;
			
		case 0:
			
			break;
			
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void addBookMenuRun3(String title, int releaseYear) {
		int option = -1;
		
		do {
			myGUI.addBookMenuShow3();
			option = Utils.intInput("Choose an option: ");
			addBookMenuControl3(option, title, releaseYear);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void addBookMenuControl3(int option, String title, int releaseYear) {
		switch(option) {
		case 1:
			Utils.showMessage("");
			String isbn = Utils.stringInput("ISBN: ");
			addBookMenuRun4(title, releaseYear, isbn);
			break;
			
		case 0:
			
			break;
			
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void addBookMenuRun4(String title, int releaseYear, String isbn) {
		int option = -1;
		
		do {
			myGUI.addBookMenuShow4();
			option = Utils.intInput("Choose an option: ");
			addBookMenuControl4(option, title, releaseYear, isbn);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void addBookMenuControl4(int option, String title, int releaseYear, String isbn) {
		switch(option) {
		case 1:
			Utils.showMessage("");
			int bookshelvesNum = Utils.intInput("Bookshelves Number: ");
			addBookMenuRun5(title, releaseYear, isbn, bookshelvesNum);
			break;
			
		case 0:
			
			break;
			
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void addBookMenuRun5(String title, int releaseYear, String isbn, int bookshelvesNum) {
		int option = -1;
		
		do {
			myGUI.addBookMenuShow5();
			option = Utils.intInput("Choose an option: ");
			addBookMenuControl5(option, title, releaseYear, isbn, bookshelvesNum);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void addBookMenuControl5(int option, String title, int releaseYear, String isbn, int bookshelvesNum) {
		switch(option) {
		case 1:
			Utils.showMessage("");
			BookCopy book = new BookCopy(title, releaseYear, isbn, bookshelvesNum);
			if(!library.itemIsDuplicate(book)) {
				if(library.getItems().add(book)) {					
					Utils.showMessage("Book added succesfully");
					Utils.showMessage("");
				}
			}else {
				Utils.showMessage("This book is already listed");
			}
			break;
			
		case 0:
			
			break;
			
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void showItemMenuRun() {
		int option = -1;
		do {
			myGUI.showItemMenuShow();
			option = Utils.intInput("Choose an option: ");
			showItemMenuControl(option);
		}while(option < 0 || option > 2);
		
	}

	@Override
	public void showItemMenuControl(int option) {
		
		switch(option) {
		case 1:

			Item item = new Item();
			do {
				int code = Utils.intInput("Search Code: ");
				
				if(item == null) {
					Utils.showMessage("");
					Utils.showMessage("Not Found");
					Utils.showMessage("");
				}else {
					item = library.itemSearchByCode(code);
				}
			}while(item == null);
			if(!item.isBook(item)) {
				Utils.showMessage(((Magazine)item).toString());
			}else {
				Utils.showMessage(((BookCopy)item).toString());				
			}
			break;
			
		case 2:

			item = new Item();
			do {
				String title = Utils.stringInput("Search Title: ");
				
				if(item == null) {
					Utils.showMessage("");
					Utils.showMessage("Not Found");
					Utils.showMessage("");
				}else {
					item = library.itemSearchByTitle(title);
				}
			}while(item == null);
			if(!item.isBook(item)) {
				Utils.showMessage(((Magazine)item).toString());
			}else {
				Utils.showMessage(((BookCopy)item).toString());				
			}
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void modifyItemMenuRun() {
		int option = -1;
		do {
			myGUI.modifyItemMenuShow();
			option = Utils.intInput("Choose an option: ");
			modifyItemMenuControl(option);
		}while(option < 0 || option > 2);
		
	}

	@Override
	public void modifyItemMenuControl(int option) {
		boolean isBook = false;
		
		switch(option) {
		case 1:
			
			Item item = new Item();
			do {
				int code = Utils.intInput("Search Code: ");
				item = library.itemSearchByCode(code);
				
				if(item == null) {
					Utils.showMessage("");
					Utils.showMessage("Not Found");
					Utils.showMessage("");
				}
			}while(item == null);
			isBook = item.isBook(item);
			Utils.showMessage("");
			Utils.showMessage(item.toString());
			Utils.showMessage("");
			modifyItemMenuRun2(item, isBook);
			break;
			
		case 2:
			
			do {
				String title = Utils.stringInput("Search Title: ");
				item = library.itemSearchByTitle(title);
				
				if(item == null) {
					Utils.showMessage("");
					Utils.showMessage("Not Found");
					Utils.showMessage("");
				}
			}while(item == null);
			isBook = item.isBook(item);
			Utils.showMessage("");
			Utils.showMessage(item.toString());
			Utils.showMessage("");
			modifyItemMenuRun2(item, isBook);
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void modifyItemMenuRun2(Item item, boolean isBook) {
		int option = -1;
		do {
			myGUI.modifyItemMenuShow2();
			option = Utils.intInput("Choose an option: ");
			modifyItemMenuControl2(option, item, isBook);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void modifyItemMenuControl2(int option, Item item, boolean isBook) {
		
		int pos = library.getItemPos(item);
		
		switch(option) {
		case 1:
			if(isBook) {
				library.bookModify((BookCopy) item, pos);
			}else {
				library.magazineModify((Magazine) item, pos);
			}
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void deleteItemMenuRun() {
		int option = -1;
		do {
			myGUI.deleteItemMenuShow();
			option = Utils.intInput("Choose an option: ");
			deleteItemMenuControl(option);
		}while(option < 0 || option > 2);
		
	}

	@Override
	public void deleteItemMenuControl(int option) {
		
		switch(option) {
		case 1:
			
			Item item = null;
			do {
				int code = Utils.intInput("Search Code: ");
				item = library.itemSearchByCode(code);
				
				if(item == null) {
					Utils.showMessage("");
					Utils.showMessage("Not Found");
					Utils.showMessage("");
				}
			}while(item == null);
			Utils.showMessage("");
			Utils.showMessage(item.toString());
			Utils.showMessage("");
			deleteItemMenuRun2(item);
			break;
			
		case 2:
						
			do {
				String title = Utils.stringInput("Search Title: ");
				item = library.itemSearchByTitle(title);
				
				if(item == null) {
					Utils.showMessage("");
					Utils.showMessage("Not Found");
					Utils.showMessage("");
				}
			}while(item == null);
			Utils.showMessage("");
			Utils.showMessage(item.toString());
			Utils.showMessage("");
			deleteItemMenuRun2(item);
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void deleteItemMenuRun2(Item item) {
		int option = -1;
		do {
			myGUI.deleteItemMenuShow2();
			option = Utils.intInput("Choose an option: ");
			deleteItemMenuControl2(option, item);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void deleteItemMenuControl2(int option, Item item) {
		switch(option) {
			case 1:
				library.getItems().remove(item);
				Utils.showMessage("");
				Utils.showMessage("Item deleted succesfully");
				Utils.showMessage("");
				break;
				
			case 0:
				
				break;
			
			default:
				Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void addUserMenuRun() {
		int option = -1;
		do {
			myGUI.addUserMenuShow();
			option = Utils.intInput("Choose an option: ");
			addUserMenuControl(option);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void addUserMenuControl(int option) {
		String dni;
		
		switch(option) {
		case 1:
			do {
				Utils.showMessage("");
				dni = Utils.stringInput("DNI: ");
			}while(!Utils.dniValidate(dni));
			addUserMenuRun2(dni);
			break;
			
		case 0:
			
			break;
			
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void addUserMenuRun2(String dni) {
		int option = -1;
		do {
			myGUI.addUserMenuShow2();
			option = Utils.intInput("Choose an option: ");
			addUserMenuControl2(option, dni);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void addUserMenuControl2(int option, String dni) {
		switch(option) {
		case 1:
			
			Utils.showMessage("");
			String name = Utils.stringInput("Name: ");
			addUserMenuRun3(dni, name);
			break;
			
		case 0:
			
			break;
			
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void addUserMenuRun3(String dni, String name) {
		int option = -1;
		do {
			myGUI.addUserMenuShow3();
			option = Utils.intInput("Choose an option: ");
			addUserMenuControl3(option, dni, name);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void addUserMenuControl3(int option, String dni, String name) {
		switch(option) {
		case 1:
			
			Utils.showMessage("");
			String surname = Utils.stringInput("Surname: ");
			addUserMenuRun4(dni, name, surname);
			break;
			
		case 0:
			
			break;
			
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void addUserMenuRun4(String dni, String name, String surname) {
		int option = -1;
		do {
			myGUI.addUserMenuShow4();
			option = Utils.intInput("Choose an option: ");
			addUserMenuControl4(option, dni, name, surname);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void addUserMenuControl4(int option, String dni, String name, String surname) {
		switch(option) {
		case 1:
			
			Utils.showMessage("");
			String phoneNum = Utils.stringInput("Phone Number: ");
			addUserMenuRun5(dni, name, surname, phoneNum);
			break;
			
		case 0:
			
			break;
			
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void addUserMenuRun5(String dni, String name, String surname, String phoneNum) {
		int option = -1;
		do {
			myGUI.addUserMenuShow5();
			option = Utils.intInput("Choose an option: ");
			addUserMenuControl5(option, dni, name, surname, phoneNum);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void addUserMenuControl5(int option, String dni, String name, String surname, String phoneNum) {
		switch(option) {
		case 1:
			
			Utils.showMessage("");
			String email = Utils.stringInput("Email: ");
			addUserMenuRun6(dni, name, surname, phoneNum, email);
			break;
			
		case 0:
			
			break;
			
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void addUserMenuRun6(String dni, String name, String surname, String phoneNum, String email) {
		int option = -1;
		do {
			myGUI.addUserMenuShow6();
			option = Utils.intInput("Choose an option: ");
			addUserMenuControl6(option, dni, name, surname, phoneNum, email);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void addUserMenuControl6(int option, String dni, String name, String surname, String phoneNum,
			String email) {
		switch(option) {
		case 1:
			Utils.showMessage("");
			User user = new User(dni, name, surname, phoneNum, email);
			if(!library.userIsDuplicate(user)) {
				library.getUsers().add(user);
				Utils.showMessage("User added succesfully");
				Utils.showMessage("");
			}else {
				Utils.showMessage("This user already exists");
			}
			break;
			
		case 0:
			
			break;
			
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void showUserMenuRun() {
		int option = -1;
		do {
			myGUI.showUserMenuShow();
			option = Utils.intInput("Choose an option: ");
			showUserMenuControl(option);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void showUserMenuControl(int option) {
		
		switch(option) {
		case 1:
			
			User user = null;
			do {
				String dni = Utils.stringInput("Search DNI: ");
				user = library.userSearch(dni);
				
				if(user == null) {
					Utils.showMessage("");
					Utils.showMessage("Not Found");
					Utils.showMessage("");
				}
			}while(user == null);
			Utils.showMessage(user.toString());
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void modifyUserMenuRun() {
		int option = -1;
		do {
			myGUI.modifyUserMenuShow();
			option = Utils.intInput("Choose an option: ");
			modifyUserMenuControl(option);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void modifyUserMenuControl(int option) {
		
		switch(option) {
		case 1:
			
			User user = null;
			do {
				String dni = Utils.stringInput("Search DNI: ");
				user = library.userSearch(dni);
				
				if(user == null) {
					Utils.showMessage("");
					Utils.showMessage("Not Found");
					Utils.showMessage("");
				}
			}while(user == null);
			Utils.showMessage("");
			Utils.showMessage(user.toString());
			Utils.showMessage("");
			modifyUserMenuRun2(user);
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void modifyUserMenuRun2(User user) {
		int option = -1;
		do {
			myGUI.modifyUserMenuShow2();
			option = Utils.intInput("Choose an option: ");
			modifyUserMenuControl2(option, user);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void modifyUserMenuControl2(int option, User user) {
		switch(option) {
		case 1:
			int pos = library.getUserPos(user);
			
			library.userModify(user, pos);
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void deleteUserMenuRun() {
		int option = -1;
		do {
			myGUI.deleteUserMenuShow();
			option = Utils.intInput("Choose an option: ");
			deleteUserMenuControl(option);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void deleteUserMenuControl(int option) {
		
		switch(option) {
		case 1:
			
			User user = null;
			do {
				String dni = Utils.stringInput("Search DNI: ");
				user = library.userSearch(dni);
				
				if(user == null) {
					Utils.showMessage("");
					Utils.showMessage("Not Found");
					Utils.showMessage("");
				}
			}while(user == null);
			Utils.showMessage("");
			Utils.showMessage(user.toString());
			Utils.showMessage("");
			deleteUserMenuRun2(user);
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void deleteUserMenuRun2(User user) {
		int option = -1;
		do {
			myGUI.deleteUserMenuShow2();
			option = Utils.intInput("Choose an option: ");
			deleteUserMenuControl2(option, user);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void deleteUserMenuControl2(int option, User user) {
		switch(option) {
		case 1:
			library.getUsers().remove(user);
			Utils.showMessage("");
			Utils.showMessage("User deleted succesfully");
			Utils.showMessage("");
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void lendBookMenuRun() {
		int option = -1;
		do {
			myGUI.lendBookMenuShow();
			option = Utils.intInput("Choose an option: ");
			lendBookMenuControl(option);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void lendBookMenuControl(int option) {
		
		switch(option) {
		case 1:
			
			User user = null;
			do {
				String dni = Utils.stringInput("Search DNI: ");
				user = library.userSearch(dni);
				
				if(user == null) {
					Utils.showMessage("");
					Utils.showMessage("Not Found");
					Utils.showMessage("");					
				}
			}while(user == null);
			Utils.showMessage("");
			Utils.showMessage(user.toString());
			Utils.showMessage("");
			lendBookMenuRun2(user);
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void lendBookMenuRun2(User user) {
		int option = -1;
		do {
			myGUI.lendBookMenuShow2();
			option = Utils.intInput("Choose an option: ");
			lendBookMenuControl2(option, user);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void lendBookMenuControl2(int option, User user) {
		switch(option) {
		case 1:
			Utils.showMessage("");
			Utils.showMessage("User Selected");
			Utils.showMessage("");
			lendBookMenuRun3(user);
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void lendBookMenuRun3(User user) {
		int option = -1;
		do {
			myGUI.lendBookMenuShow3();
			option = Utils.intInput("Choose an option: ");
			lendBookMenuControl3(option, user);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void lendBookMenuControl3(int option, User user) {
		
		switch(option) {
		case 1:
			
			BookCopy book = null;
			do {
				do {
					int code = Utils.intInput("Search Code: ");
					book = ((BookCopy)library.itemSearchByCode(code));
					
					if(book == null) {
						Utils.showMessage("");
						Utils.showMessage("Not Found");
						Utils.showMessage("");
					}
				}while(book == null);
					if(book.isBook(book)) {
						Utils.showMessage("");
						Utils.showMessage(book.toString());
						Utils.showMessage("");
					}else {
						Utils.showMessage("");
						Utils.showMessage("This is Not a Book");
						Utils.showMessage("");
					}
			}while(!book.isBook(book));
				lendBookMenuRun4(user, book);
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void lendBookMenuRun4(User user, BookCopy book) {
		int option = -1;
		do {
			myGUI.lendBookMenuShow4();
			option = Utils.intInput("Choose an option: ");
			lendBookMenuControl4(option, user, book);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void lendBookMenuControl4(int option, User user, BookCopy book) {
		switch(option) {
		case 1:
			Utils.showMessage("");
			Utils.showMessage("Book Selected");
			Utils.showMessage("");
			lendBookMenuRun5(user, book);
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void lendBookMenuRun5(User user, BookCopy book) {
		int option = -1;
		do {
			myGUI.lendBookMenuShow5();
			option = Utils.intInput("Choose an option: ");
			lendBookMenuControl5(option, user, book);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void lendBookMenuControl5(int option, User user, BookCopy book) {
		switch(option) {
		case 1:
			if(!library.checkUser(user) && !library.checkBook(book)) {
				library.lendBook(user, book);
				Utils.showMessage("");
				Utils.showMessage("Book Lent");
				Utils.showMessage("");
			}else if(library.checkUser(user) && !library.checkBook(book)) {
				Utils.showMessage("");
				Utils.showMessage("Book is already lent");
				Utils.showMessage("");
			}else if(!library.checkUser(user) && library.checkBook(book)) {
				Utils.showMessage("");
				Utils.showMessage("User has a lent book already");
				Utils.showMessage("");
			}else {
				Utils.showMessage("");
				Utils.showMessage("User has a lent book already");
				Utils.showMessage("Book is already lent");
				Utils.showMessage("");
			}
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void retrieveBookMenuRun() {
		int option = -1;
		do {
			myGUI.retrieveBookMenuShow();
			option = Utils.intInput("Choose an option: ");
			retrieveBookMenuControl(option);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void retrieveBookMenuControl(int option) {
		
		switch(option) {
		case 1:
			
			User user = null;
			do {
				String dni = Utils.stringInput("Search DNI: ");
				user = library.userSearch(dni);
				
				if(user != null && user.getLentBook() == null) {
					Utils.showMessage("");
					Utils.showMessage("User does not have any book");
					Utils.showMessage("");
				}
			}while(user == null || user.getLentBook() == null);
			if(user != null) {
				Utils.showMessage("");
				Utils.showMessage(user.toString());
				Utils.showMessage("");
				retrieveBookMenuRun2(user);
			}
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void retrieveBookMenuRun2(User user) {
		int option = -1;
		do {
			myGUI.retrieveBookMenuShow2();
			option = Utils.intInput("Choose an option: ");
			retrieveBookMenuControl2(option, user);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void retrieveBookMenuControl2(int option, User user) {
		switch(option) {
		case 1:
			
				Utils.showMessage("");
				Utils.showMessage("User Selected");
				Utils.showMessage("");
				retrieveBookMenuRun3(user);
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void retrieveBookMenuRun3(User user) {
		int option = -1;
		do {
			myGUI.retrieveBookMenuShow3();
			option = Utils.intInput("Choose an option: ");
			retrieveBookMenuControl3(option, user);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void retrieveBookMenuControl3(int option, User user) {
		switch(option) {
		case 1:
			library.retrieveBook(user, user.getLentBook());

			Utils.showMessage("");
			Utils.showMessage("Operation succesfully finished");
			Utils.showMessage("");
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}
	
	
}