package util;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import interfaces.iRepo;
import model.RepoLibrary;
import model.DTO.Item;

public class LocalStorage {

	/**
	 * Method that serializes an iRepo in a file.
	 * @param library , the iRepo to save.
	 * @return a boolean true if it was done successfully or false if it's not.
	 */
	
	public static boolean write(iRepo library) {
		boolean result = false;
		
		try {
	         FileOutputStream fileOut =
	         new FileOutputStream("src/library.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(library);
	         out.close();
	         fileOut.close();
	         System.out.printf("Data Saved");
	      } catch (IOException i) {
	         
	      }
		
		return result;
	}
	
	/**
	 * Method that deserializes an iRepo from a file.
	 * @return the deserialized iRepo.
	 */
	
	public static iRepo read() {
		
		iRepo library = new RepoLibrary();
		
		try {
	         FileInputStream fileIn = new FileInputStream("src/library.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         library = (iRepo) in.readObject();
	         in.close();
	         fileIn.close();
	         return library;
	      } catch (IOException i) {
	         
	         return null;
	      } catch (ClassNotFoundException c) {
	         
	         return null;
	      }
		
	}
	
	/**
	 * Method that serializes an Integer in a file.
	 * @param item, the Integer to save.
	 * @return a boolean true if it was done successfully or false if it's not.
	 */
	
	public static boolean write2(Integer code) {
		boolean result = false;
		
		try {
	         FileOutputStream fileOut =
	         new FileOutputStream("src/item.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(code);
	         out.close();
	         fileOut.close();
	         System.out.printf("Data Saved");
	      } catch (IOException i) {
	         
	      }
		
		return result;
	}
	
	/**
	 * Method that deserializes an Integer from a file.
	 * @return the deserialized Integer.
	 */
	
	public static Integer read2() {
		
		Integer code = 0;
		
		try {
	         FileInputStream fileIn = new FileInputStream("src/item.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         code = (Integer) in.readObject();
	         in.close();
	         fileIn.close();
	         return code;
	      } catch (IOException i) {
	         
	         return null;
	      } catch (ClassNotFoundException c) {
	         
	         return null;
	      }
		
	}
}