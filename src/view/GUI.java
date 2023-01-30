package view;

import interfaces.iGUI;

public class GUI implements iGUI{

	@Override
	public void mainMenuShow() {
		System.out.println("");
		System.out.println("|--------------------------------------------|");
		System.out.println("|------------------LIBRARY-------------------|");
		System.out.println("|--------------------------------------------|");
		System.out.println("|  1. Add item        |   6. Add user        |");
		System.out.println("|  2. Show item       |   7. Show user       |");
		System.out.println("|  3. Show ALL items  |   8. Show ALL users  |");
		System.out.println("|  4. Modify item     |   9. Modify user     |");
		System.out.println("|  5. Delete item     |  10. Delete user     |");
		System.out.println("|--------------------------------------------|");
		System.out.println("|     11. Lend Book    12. Retrieve Book     |");
		System.out.println("|                                            |");
		System.out.println("|                 0. Exit                    |");
		System.out.println("|--------------------------------------------|");
		System.out.println("");
	}
	
	@Override
	public void addItemMenuShow() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Add Item                              |");
		System.out.println("|---------------------------------------|");
		System.out.println("|   1. Book    2. Magazine    0. Back   |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
	}
	


	@Override
	public void addMagazineMenuShow() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Add Magazine                          |");
		System.out.println("|---------------------------------------|");
		System.out.println("|  1. Add Title       0. Main Menu      |");
		System.out.println("|---------------------------------------|");
		System.out.println("");

	}

	@Override
	public void addMagazineMenuShow2() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Add Magazine                          |");
		System.out.println("|---------------------------------------|");
		System.out.println("|  1. Add Edition     0. Main Menu      |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}
	
	@Override
	public void addMagazineMenuShow3() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Add this magazine?                    |");
		System.out.println("|---------------------------------------|");
		System.out.println("|        1. YES         0. NO           |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void addBookMenuShow() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Add Book                              |");
		System.out.println("|---------------------------------------|");
		System.out.println("|  1. Add Title       0. Main Menu      |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void addBookMenuShow2() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Add Book                              |");
		System.out.println("|---------------------------------------|");
		System.out.println("|  1. Add Release Year    0. Main Menu  |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void addBookMenuShow3() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Add Book                              |");
		System.out.println("|---------------------------------------|");
		System.out.println("|  1. Add ISBN        0. Main Menu      |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void addBookMenuShow4() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Add Book                              |");
		System.out.println("|---------------------------------------|");
		System.out.println("|1. Add Bookshelves Number  0. Main Menu|");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}
	
	@Override
	public void addBookMenuShow5() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Add this book?                        |");
		System.out.println("|---------------------------------------|");
		System.out.println("|        1. YES         0. NO           |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void showItemMenuShow() {
		System.out.println("");
		System.out.println("|-------------------------------------------------|");
		System.out.println("| Show Item                                       |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("| 1. Search by code   2. Search by name   0. Back |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void modifyItemMenuShow() {
		System.out.println("");
		System.out.println("|-------------------------------------------------|");
		System.out.println("| Modify Item                                     |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("| 1. Search by code   2. Search by name   0. Back |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void modifyItemMenuShow2() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Modify this item?                     |");
		System.out.println("|---------------------------------------|");
		System.out.println("|        1. YES         0. NO           |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void deleteItemMenuShow() {
		System.out.println("");
		System.out.println("|-------------------------------------------------|");
		System.out.println("| Delete Item                                     |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("| 1. Search by code   2. Search by name   0. Back |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void deleteItemMenuShow2() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Delete this item?                     |");
		System.out.println("|---------------------------------------|");
		System.out.println("|        1. YES         0. NO           |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void addUserMenuShow() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Add User                              |");
		System.out.println("|---------------------------------------|");
		System.out.println("|    1. Add DNI       0. Main Menu      |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void addUserMenuShow2() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Add User                              |");
		System.out.println("|---------------------------------------|");
		System.out.println("|    1. Add Name       0. Main Menu     |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void addUserMenuShow3() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Add User                              |");
		System.out.println("|---------------------------------------|");
		System.out.println("|    1. Add Surname     0. Main Menu    |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void addUserMenuShow4() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Add User                              |");
		System.out.println("|---------------------------------------|");
		System.out.println("|  1. Add Phone Number    0. Main Menu  |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void addUserMenuShow5() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Add User                              |");
		System.out.println("|---------------------------------------|");
		System.out.println("|    1. Add Email       0. Main Menu    |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void addUserMenuShow6() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Add this user?                        |");
		System.out.println("|---------------------------------------|");
		System.out.println("|        1. YES         0. NO           |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void showUserMenuShow() {
		System.out.println("");
		System.out.println("|-------------------------------------------------|");
		System.out.println("| Show User                                       |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("|      1. Search by dni          0. Back          |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void modifyUserMenuShow() {
		System.out.println("");
		System.out.println("|-------------------------------------------------|");
		System.out.println("| Modify User                                     |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("|      1. Search by dni          0. Back          |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void modifyUserMenuShow2() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Modify this user?                     |");
		System.out.println("|---------------------------------------|");
		System.out.println("|        1. YES         0. NO           |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void deleteUserMenuShow() {
		System.out.println("");
		System.out.println("|-------------------------------------------------|");
		System.out.println("| Delete User                                     |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("|      1. Search by dni          0. Back          |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void deleteUserMenuShow2() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Delete this user?                     |");
		System.out.println("|---------------------------------------|");
		System.out.println("|        1. YES         0. NO           |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void lendBookMenuShow() {
		System.out.println("");
		System.out.println("|-------------------------------------------------|");
		System.out.println("| Lend Book Menu                                  |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("|   1. Search User by DNI          0. Back        |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void lendBookMenuShow2() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Lend a Book to this user?             |");
		System.out.println("|---------------------------------------|");
		System.out.println("|        1. YES         0. NO           |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void lendBookMenuShow3() {
		System.out.println("");
		System.out.println("|-------------------------------------------------|");
		System.out.println("| Lend Book Menu                                  |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("|   1. Search Book by code          0. Back       |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void lendBookMenuShow4() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Lend this Book?                       |");
		System.out.println("|---------------------------------------|");
		System.out.println("|        1. YES         0. NO           |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void lendBookMenuShow5() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Confirm Operation                     |");
		System.out.println("|---------------------------------------|");
		System.out.println("|        1. YES         0. NO           |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void retrieveBookMenuShow() {
		System.out.println("");
		System.out.println("|-------------------------------------------------|");
		System.out.println("| Retrieve Book Menu                              |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("|   1. Search User by DNI          0. Back        |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void retrieveBookMenuShow2() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Is this user correct?                 |");
		System.out.println("|---------------------------------------|");
		System.out.println("|        1. YES         0. NO           |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}

	@Override
	public void retrieveBookMenuShow3() {
		System.out.println("");
		System.out.println("|---------------------------------------|");
		System.out.println("| Confirm Operation                     |");
		System.out.println("|---------------------------------------|");
		System.out.println("|        1. YES         0. NO           |");
		System.out.println("|---------------------------------------|");
		System.out.println("");
		
	}

	
}