package controller;

import interfaces.iController;
import interfaces.iGUI;
import interfaces.iRepo;
import model.RepoLibrary;
import model.DTO.BookCopy;
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
				library.itemAdd(magazine);
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
				library.itemAdd(book);
				Utils.showMessage("Book added succesfully");
				Utils.showMessage("");
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
		int pos = -1;
		
		switch(option) {
		case 1:
			do {
				int code = Utils.intInput("Search Code: ");
				pos = library.itemSearchByCode(code);
				
				if(pos == -1) {
					Utils.showMessage("");
					Utils.showMessage("Not Found");
					Utils.showMessage("");
				}
			}while(pos == -1);
			library.itemShow(pos);
			break;
			
		case 2:
			do {
				String title = Utils.stringInput("Search Title: ");
				pos = library.itemSearchByTitle(title);
				
				if(pos == -1) {
					Utils.showMessage("");
					Utils.showMessage("Not Found");
					Utils.showMessage("");
				}
			}while(pos == -1);
			library.itemShow(pos);
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
		int pos = -1;
		boolean isBook = false;
		
		switch(option) {
		case 1:
			do {
				int code = Utils.intInput("Search Code: ");
				pos = library.itemSearchByCode(code);
				
				if(pos == -1) {
					Utils.showMessage("");
					Utils.showMessage("Not Found");
					Utils.showMessage("");
				}
			}while(pos == -1);
			isBook = library.isBook(pos);
			Utils.showMessage("");
			Utils.showMessage(library.getItems()[pos].toString());
			Utils.showMessage("");
			modifyItemMenuRun2(pos, isBook);
			break;
			
		case 2:
			do {
				String title = Utils.stringInput("Search Title: ");
				pos = library.itemSearchByTitle(title);
				
				if(pos == -1) {
					Utils.showMessage("");
					Utils.showMessage("Not Found");
					Utils.showMessage("");
				}
			}while(pos == -1);
			isBook = library.isBook(pos);
			Utils.showMessage("");
			Utils.showMessage(library.getItems()[pos].toString());
			Utils.showMessage("");
			modifyItemMenuRun2(pos, isBook);
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void modifyItemMenuRun2(int pos, boolean isBook) {
		int option = -1;
		do {
			myGUI.modifyItemMenuShow2();
			option = Utils.intInput("Choose an option: ");
			modifyItemMenuControl2(option, pos, isBook);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void modifyItemMenuControl2(int option, int pos, boolean isBook) {
		
		switch(option) {
		case 1:
			if(isBook) {
				library.bookModify((BookCopy) library.getItems()[pos], pos);
			}else {
				library.magazineModify((Magazine) library.getItems()[pos], pos);
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
		int pos = -1;
		
		switch(option) {
		case 1:
			do {
				int code = Utils.intInput("Search Code: ");
				pos = library.itemSearchByCode(code);
				
				if(pos == -1) {
					Utils.showMessage("");
					Utils.showMessage("Not Found");
					Utils.showMessage("");
				}
			}while(pos == -1);
			Utils.showMessage("");
			Utils.showMessage(library.getItems()[pos].toString());
			Utils.showMessage("");
			deleteItemMenuRun2(pos);
			break;
			
		case 2:
			do {
				String title = Utils.stringInput("Search Title: ");
				pos = library.itemSearchByTitle(title);
				
				if(pos == -1) {
					Utils.showMessage("");
					Utils.showMessage("Not Found");
					Utils.showMessage("");
				}
			}while(pos == -1);
			Utils.showMessage("");
			Utils.showMessage(library.getItems()[pos].toString());
			Utils.showMessage("");
			deleteItemMenuRun2(pos);
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void deleteItemMenuRun2(int pos) {
		int option = -1;
		do {
			myGUI.deleteItemMenuShow2();
			option = Utils.intInput("Choose an option: ");
			deleteItemMenuControl2(option, pos);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void deleteItemMenuControl2(int option, int pos) {
		switch(option) {
			case 1:
				library.itemDelete(pos);
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
				library.userAdd(user);
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
		int pos = -1;
		
		switch(option) {
		case 1:
			do {
				String dni = Utils.stringInput("Search DNI: ");
				pos = library.userSearch(dni);
				
				if(pos == -1) {
					Utils.showMessage("");
					Utils.showMessage("Not Found");
					Utils.showMessage("");
				}
			}while(pos == -1);
			library.userShow(pos);
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
		int pos = -1;
		
		switch(option) {
		case 1:
			do {
				String dni = Utils.stringInput("Search dni: ");
				pos = library.userSearch(dni);
				
				if(pos == -1) {
					Utils.showMessage("");
					Utils.showMessage("Not Found");
					Utils.showMessage("");
				}
			}while(pos == -1);
			Utils.showMessage("");
			Utils.showMessage(library.getUsers()[pos].toString());
			Utils.showMessage("");
			modifyUserMenuRun2(pos);
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void modifyUserMenuRun2(int pos) {
		int option = -1;
		do {
			myGUI.modifyUserMenuShow2();
			option = Utils.intInput("Choose an option: ");
			modifyUserMenuControl2(option, pos);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void modifyUserMenuControl2(int option, int pos) {
		switch(option) {
		case 1:
			library.userModify(pos, library.getUsers()[pos]);			
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
		int pos = -1;
		
		switch(option) {
		case 1:
			do {
				String dni = Utils.stringInput("Search DNI: ");
				pos = library.userSearch(dni);
				
				if(pos == -1) {
					Utils.showMessage("");
					Utils.showMessage("Not Found");
					Utils.showMessage("");
				}
			}while(pos == -1);
			Utils.showMessage("");
			Utils.showMessage(library.getUsers()[pos].toString());
			Utils.showMessage("");
			deleteUserMenuRun2(pos);
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void deleteUserMenuRun2(int pos) {
		int option = -1;
		do {
			myGUI.deleteUserMenuShow2();
			option = Utils.intInput("Choose an option: ");
			deleteUserMenuControl2(option, pos);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void deleteUserMenuControl2(int option, int pos) {
		switch(option) {
		case 1:
			library.userDelete(pos);
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
		int pos = -1;
		
		switch(option) {
		case 1:
			do {
				String dni = Utils.stringInput("Search DNI: ");
				pos = library.userSearch(dni);
				
				if(pos == -1) {
					Utils.showMessage("");
					Utils.showMessage("Not Found");
					Utils.showMessage("");					
				}
			}while(pos == -1);
			Utils.showMessage("");
			Utils.showMessage(library.getUsers()[pos].toString());
			Utils.showMessage("");
			lendBookMenuRun2(pos);
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void lendBookMenuRun2(int userPos) {
		int option = -1;
		do {
			myGUI.lendBookMenuShow2();
			option = Utils.intInput("Choose an option: ");
			lendBookMenuControl2(option, userPos);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void lendBookMenuControl2(int option, int userPos) {
		switch(option) {
		case 1:
			Utils.showMessage("");
			Utils.showMessage("User Selected");
			Utils.showMessage("");
			lendBookMenuRun3(userPos);
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void lendBookMenuRun3(int userPos) {
		int option = -1;
		do {
			myGUI.lendBookMenuShow3();
			option = Utils.intInput("Choose an option: ");
			lendBookMenuControl3(option, userPos);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void lendBookMenuControl3(int option, int userPos) {
		int pos = -1;
		
		switch(option) {
		case 1:
			do {
				do {
					int code = Utils.intInput("Search Code: ");
					pos = library.itemSearchByCode(code);
					
					if(pos == -1) {
						Utils.showMessage("");
						Utils.showMessage("Not Found");
						Utils.showMessage("");
					}
				}while(pos == -1);
					if(library.isBook(pos)) {
						Utils.showMessage("");
						Utils.showMessage(library.getItems()[pos].toString());
						Utils.showMessage("");
					}else {
						Utils.showMessage("");
						Utils.showMessage("This is Not a Book");
						Utils.showMessage("");
					}
			}while(!library.isBook(pos));
				lendBookMenuRun4(userPos, pos);
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void lendBookMenuRun4(int userPos, int bookPos) {
		int option = -1;
		do {
			myGUI.lendBookMenuShow4();
			option = Utils.intInput("Choose an option: ");
			lendBookMenuControl4(option, userPos, bookPos);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void lendBookMenuControl4(int option, int userPos, int bookPos) {
		switch(option) {
		case 1:
			Utils.showMessage("");
			Utils.showMessage("Book Selected");
			Utils.showMessage("");
			lendBookMenuRun5(userPos, bookPos);
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void lendBookMenuRun5(int userPos, int bookPos) {
		int option = -1;
		do {
			myGUI.lendBookMenuShow5();
			option = Utils.intInput("Choose an option: ");
			lendBookMenuControl5(option, userPos, bookPos);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void lendBookMenuControl5(int option, int userPos, int bookPos) {
		switch(option) {
		case 1:
			if(!library.checkUser(userPos) && !library.checkBook(bookPos)) {
				library.lendBook(userPos, bookPos);
				Utils.showMessage("");
				Utils.showMessage("Book Lent");
				Utils.showMessage("");
			}else if(library.checkUser(userPos) && !library.checkBook(bookPos)) {
				Utils.showMessage("");
				Utils.showMessage("Book is already lent");
				Utils.showMessage("");
			}else if(!library.checkUser(userPos) && library.checkBook(bookPos)) {
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
		int pos = -1;
		
		switch(option) {
		case 1:
			do {
				String dni = Utils.stringInput("Search DNI: ");
				pos = library.userSearch(dni);
				
				if(pos != -1 && library.getUsers()[pos].getLentBook() == null) {
					Utils.showMessage("");
					Utils.showMessage("User does not have any book");
					Utils.showMessage("");
				}
			}while(pos == -1 || library.getUsers()[pos].getLentBook() == null);
			if(pos != -1) {
				Utils.showMessage("");
				Utils.showMessage(library.getUsers()[pos].toString());
				Utils.showMessage("");
				retrieveBookMenuRun2(pos);
			}else {
				Utils.showMessage("");
				Utils.showMessage("Not Found");
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
	public void retrieveBookMenuRun2(int userPos) {
		int option = -1;
		do {
			myGUI.retrieveBookMenuShow2();
			option = Utils.intInput("Choose an option: ");
			retrieveBookMenuControl2(option, userPos);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void retrieveBookMenuControl2(int option, int userPos) {
		switch(option) {
		case 1:
			
				Utils.showMessage("");
				Utils.showMessage("User Selected");
				Utils.showMessage("");
				retrieveBookMenuRun3(userPos);
			break;
			
		case 0:
			
			break;
		
		default:
			Utils.showMessage("Incorrect");
		}
		
	}

	@Override
	public void retrieveBookMenuRun3(int userPos) {
		int option = -1;
		do {
			myGUI.retrieveBookMenuShow3();
			option = Utils.intInput("Choose an option: ");
			retrieveBookMenuControl3(option, userPos);
		}while(option < 0 || option > 1);
		
	}

	@Override
	public void retrieveBookMenuControl3(int option, int userPos) {
		switch(option) {
		case 1:
			library.retrieveBook(userPos, library.itemSearchByCode(library.getUsers()[userPos].getLentBook().getCode()));

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