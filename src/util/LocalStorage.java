package util;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import interfaces.iRepo;
import model.RepoLibrary;

public class LocalStorage {

	/**
	 * Método que serializa un dato en un archivo.
	 * @param file , nombre del archivo.
	 * @param items , el dato a serializar.
	 * @return un boolean true si ha salido bien y false si no.
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
	 * Método que lee un dato en un archivo.
	 * @return el dato leido.
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
}