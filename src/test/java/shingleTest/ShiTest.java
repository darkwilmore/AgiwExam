package shingleTest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import support.HashFactory;
import support.ShinglesFactory;

public class ShiTest {
	
	
	
	public static void main(String[] args) {
		
		List<File> paths = new ArrayList<File>();
		
		paths.add(new File("./data/The Lord Of The Rings Trilogy 6 Blu-Ray Edizione: "
				+ "Regno Unito Edizione: Regno Unito: Amazon.it: Sean.html"));
		paths.add(new File("./data/Revenant - Redivivo (Blu-Ray): Amazon.it: "
				+ "Leonardo DiCaprio, Tom Hardy, Will Poulter, Domhnall Glees.html"));
		paths.add(new File("./data/3 grandi film - Il Signore degli Anelli - La trilogia cinematografica: "
				+ "Amazon.it: varie: Film e TV.html"));
		paths.add(new File("./data/4 grandi film - Harry Potter - Anni 5-7 Volume 02: Amazon.it: vari: Film e TV.html"));
		paths.add(new File("./data/Amazon.it: Il trono di spade. Libro terzo delle "
				+ "Cronache del ghiaccio e del fuoco. Ediz. speciale: 3.html"));
		paths.add(new File("./data/AMD Ryzen 5 1600 3.2GHz: Amazon.it: Informatica.html"));
		paths.add(new File("./data/Game of Thrones: Amazon.it: George R. R. Martin: Libri in altre lingue.html"));
		paths.add(new File("./data/Gigabyte GA-H110M-DS2 Scheda Madre, Nero: Amazon.it: Informatica.html"));
		paths.add(new File("./data/Il Cavaliere Oscuro - La Trilogia Cofanetto 5 Blu-Ray: Amazon.it: "
				+ "Christian Bale, Gary Oldman, Micha.html"));
		paths.add(new File("./data/Intel Core i5-7400 3GHz 6MB Cache intelligente Scatola: Amazon.it: Informatica.html"));
		paths.add(new File("./data/Seagate ST1000DM010 HDD da 1TB 64 MB SataIII 3.5\", Grigio: Amazon.it: Informatica.html"));
		paths.add(new File("./data/Seagate ST1000DM010 HDD da 1TB 64 MB SataIII 3.5\", Grigio: Amazon.it: Informatica.html"));

		//testVector(paths);
		testMaskedVector(paths);
		
	}
	
	public static void testHash() {
		
		File input = new File("./data/The Lord Of The Rings Trilogy 6 Blu-Ray Edizione: "
				+ "Regno Unito Edizione: Regno Unito: Amazon.it: Sean.html");
		
		List<String[]> sset = ShinglesFactory.createSet(input.toPath());
		
		for (String[] arr : sset) {
			
			long hash = HashFactory.h1Hash(arr);
			
			System.out.println(hash);
			
		}
	}
	
	public static void testVector(List<File> paths) {
			
		for(File file : paths) {
		List<String[]> sset = ShinglesFactory.createSet(file.toPath());
		
		Vector<Long> vector = ShinglesFactory.createVector(sset);
		
		System.out.println(file.getName() + " " + vector.get(0) + " " + vector.get(1) + " " + vector.get(2) + " " + vector.get(3) + " " + vector.get(4) + " " + 
				vector.get(5) + " " + vector.get(6) + " " + vector.get(7));
		
		}
	}
	
	public static void testMaskedVector(List<File> paths) {
		
		for(File file : paths) {
		List<String[]> sset = ShinglesFactory.createSet(file.toPath());
		
		Vector<Long> vector = ShinglesFactory.createVector(sset);
		List<Vector<Long>> masked = ShinglesFactory.createMasked(vector);
		
		for(Vector<Long> mask : masked) {
			
			System.out.println(file.getName() + " " + mask.get(0) + " " + mask.get(1) + " " + mask.get(2) + " " + mask.get(3) + " " + mask.get(4) + " " + 
					mask.get(5) + " " + mask.get(6) + " " + mask.get(7));
		}
		
		}
	}

}
