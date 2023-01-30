package interfaces;

import model.DTO.BookCopy;
import model.DTO.Item;
import model.DTO.Magazine;
import model.DTO.User;

public interface iRepo{
	Item[] getItems();
	User[] getUsers();
	void setItems(Item[] items);
	void setUsers(User[] users);
	
	boolean itemAdd(Item item);
	
	int itemSearchByCode(int code);
	int itemSearchByTitle(String title);
	
	boolean itemIsDuplicate(Item item);
	
	boolean itemShow(int pos);
	void libraryShow();
	
	boolean isBook(int pos);
	boolean bookModify(BookCopy book, int pos);
	boolean magazineModify(Magazine magazine, int pos);
	
	boolean itemDelete(int pos);
	boolean itemOrganize(int pos);
	
	
	boolean userAdd(User user);
	User[] usersEnlarger();
	
	int userSearch(String dni);
	
	boolean userIsDuplicate(User user);
	
	boolean userShow(int pos);
	void userShowAll();
	
	boolean userModify(int pos, User user);
	
	boolean userDelete(int pos);
	boolean userOrganize(int pos);
	
	boolean lendBook(int userPos, int bookPos);
	
	boolean retrieveBook(int userPos, int bookPos);
	
	boolean checkUser(int userPos);
	boolean checkBook(int bookPos);
}