package interfaces;

public interface iGUI {
	void mainMenuShow();
	
	void addItemMenuShow();			//Type check
	void addMagazineMenuShow();		//Add Title
	void addMagazineMenuShow2();	//Add Edition
	void addMagazineMenuShow3();	//Operation confirmation
	void addBookMenuShow();			//Add Title
	void addBookMenuShow2();		//Add Release Year
	void addBookMenuShow3();		//Add ISBN
	void addBookMenuShow4();		//Add Bookshelves Number
	void addBookMenuShow5();		//Operation confirmation
	
	void showItemMenuShow();		//Item search
	
	void modifyItemMenuShow();		//Item search
	void modifyItemMenuShow2();		//Operation confirmation
	
	void deleteItemMenuShow();		//Item search
	void deleteItemMenuShow2();		//Operation confirmation
	
	void addUserMenuShow();			//Add DNI
	void addUserMenuShow2();		//Add Name
	void addUserMenuShow3();		//Add Surname
	void addUserMenuShow4();		//Add Phone Number
	void addUserMenuShow5();		//Add Email
	void addUserMenuShow6();		//Operation confirmation
	
	void showUserMenuShow();		//User search
	
	void modifyUserMenuShow();		//User search
	void modifyUserMenuShow2();		//Operation confirmation
	
	void deleteUserMenuShow();		//User search
	void deleteUserMenuShow2();		//Operation confirmation
	
	
	void lendBookMenuShow();		//User search
	void lendBookMenuShow2();		//User confirmation
	void lendBookMenuShow3();		//Book search
	void lendBookMenuShow4();		//Book confirmation
	void lendBookMenuShow5();		//Operation confirmation
	
	void retrieveBookMenuShow();	//User search
	void retrieveBookMenuShow2();	//User confirmation
	void retrieveBookMenuShow3();	//Operation confirmation
}