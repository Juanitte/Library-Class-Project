package util;

import java.util.Scanner;

public class Utils {


	public static int intInput(String msg) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		boolean isCorrect = false;
		int number = 0;
		
		do {
			System.out.print(msg);
			try {
				number = sc.nextInt();
				isCorrect = true;
			}catch(Exception InputMismatchException){
				System.out.println("");
				System.out.println("Incorrect input");
				System.out.println("");
				sc.nextLine();
			}
		}while(!isCorrect);
		
		return number;
	}
	
	public static String stringInput(String msg) {
		System.out.print(msg);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public static void showMessage(String msg) {
		System.out.println(msg);
		
	}
	
	public static boolean dniValidate(String dni) {
		boolean isValid = true;
		
		if(dni.length() == 9) {
			for(int i = 0; i < dni.length() - 1; i++) {
				if(dni.charAt(i) >= '0' && dni.charAt(i) <= '9') {
					
				}else {
					isValid = false;
				}
			}
			if(isValid) {
				if(dni.charAt(dni.length() - 1) > 'A' && dni.charAt(dni.length() - 1) < 'Z') {
					
				}else {
					isValid = false;
				}
			}
		}else {
			isValid = false;
		}
		
		return isValid;
	}
}
