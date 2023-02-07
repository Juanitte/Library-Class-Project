package interfaces;

import java.util.ArrayList;

import model.DTO.BookCopy;
import model.DTO.Item;
import model.DTO.Magazine;
import model.DTO.User;

public interface iRepo{
	ArrayList<Item> getItems();
	ArrayList<User> getUsers();
	void setItems(ArrayList<Item> items);
	void setUsers(ArrayList<User> users);
	
	boolean itemAdd(Item item);
	
	Item itemSearchByCode(int code);
	Item itemSearchByTitle(String title);
	
	boolean itemIsDuplicate(Item item);
	
	void itemShow(Item item);
	void libraryShow();
	
	int getItemPos(Item item);
	int getUserPos(User user);
	
	boolean bookModify(BookCopy book, int pos);
	boolean magazineModify(Magazine magazine, int pos);
	
	
	User userSearch(String dni);
	
	boolean userIsDuplicate(User user);
	
	void userShow(User user);
	void userShowAll();
	
	boolean userModify(User user, int pos);
	
	void lendBook(User user, BookCopy book);
	
	boolean retrieveBook(User user, BookCopy book);
	
	boolean checkUser(User user);
	boolean checkBook(BookCopy book);
}