package interfaces;


public interface iController {
	void start();
	
	void mainMenuRun();
	void mainMenuControl(int option);
	
	void addItemMenuRun();
	void addItemMenuControl(int option);
	
	void addMagazineMenuRun();
	void addMagazineMenuControl(int option);
	void addMagazineMenuRun2(String title);
	void addMagazineMenuControl2(int option, String title);
	void addMagazineMenuRun3(String title, String edition);
	void addMagazineMenuControl3(int option, String title, String edition);
	
	void addBookMenuRun();
	void addBookMenuControl(int option);
	void addBookMenuRun2(String title);
	void addBookMenuControl2(int option, String title);
	void addBookMenuRun3(String title, int releaseYear);
	void addBookMenuControl3(int option, String title, int releaseYear);
	void addBookMenuRun4(String title, int releaseYear, String isbn);
	void addBookMenuControl4(int option, String title, int releaseYear, String isbn);
	void addBookMenuRun5(String title, int releaseYear, String isbn, int bookshelvesNum);
	void addBookMenuControl5(int option, String title, int releaseYear, String isbn, int bookshelvesNum);
	
	void showItemMenuRun();
	void showItemMenuControl(int option);
	
	void modifyItemMenuRun();
	void modifyItemMenuControl(int option);
	void modifyItemMenuRun2(int pos, boolean isBook);
	void modifyItemMenuControl2(int option, int pos, boolean isBook);
	
	void deleteItemMenuRun();
	void deleteItemMenuControl(int option);
	void deleteItemMenuRun2(int pos);
	void deleteItemMenuControl2(int option, int pos);
	
	void addUserMenuRun();
	void addUserMenuControl(int option);
	void addUserMenuRun2(String dni);
	void addUserMenuControl2(int option, String dni);
	void addUserMenuRun3(String dni, String name);
	void addUserMenuControl3(int option, String dni, String name);
	void addUserMenuRun4(String dni, String name, String surname);
	void addUserMenuControl4(int option, String dni, String name, String surname);
	void addUserMenuRun5(String dni, String name, String surname, String phoneNum);
	void addUserMenuControl5(int option, String dni, String name, String surname, String phoneNum);
	void addUserMenuRun6(String dni, String name, String surname, String phoneNum, String email);
	void addUserMenuControl6(int option, String dni, String name, String surname, String phoneNum, String email);
	
	void showUserMenuRun();
	void showUserMenuControl(int option);
	
	void modifyUserMenuRun();
	void modifyUserMenuControl(int option);
	void modifyUserMenuRun2(int pos);
	void modifyUserMenuControl2(int option, int pos);
	
	void deleteUserMenuRun();
	void deleteUserMenuControl(int option);
	void deleteUserMenuRun2(int pos);
	void deleteUserMenuControl2(int option, int pos);
	
	void lendBookMenuRun();
	void lendBookMenuControl(int option);
	void lendBookMenuRun2(int userPos);
	void lendBookMenuControl2(int option, int userPos);
	void lendBookMenuRun3(int userPos);
	void lendBookMenuControl3(int option, int userPos);
	void lendBookMenuRun4(int userPos, int bookPos);
	void lendBookMenuControl4(int option, int userPos, int bookPos);
	void lendBookMenuRun5(int userPos, int bookPos);
	void lendBookMenuControl5(int option, int userPos, int bookPos);
	
	void retrieveBookMenuRun();
	void retrieveBookMenuControl(int option);
	void retrieveBookMenuRun2(int userPos);
	void retrieveBookMenuControl2(int option, int userPos);
	void retrieveBookMenuRun3(int userPos);
	void retrieveBookMenuControl3(int option, int userPos);
}