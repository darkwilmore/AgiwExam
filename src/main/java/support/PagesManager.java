package support;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PagesManager {
	
	public static List<File> givePages() {
		
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
		
		return paths;

	}
	
	public static Collection<Path> scanFolder(String path) throws IOException {
		
		Collection<Path> all = new ArrayList<Path>();
	    addTree(Paths.get(path), all);
	    //System.out.println(all.toString() + "\n" + all.size());
	    
		return all;
		
	}

	private static void addTree(Path directory, final Collection<Path> all)
	        throws IOException {
	    Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
	        @Override
	        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
	                throws IOException {
	        	if(getExtensionOfFile(file).equals("html"))
	        		all.add(file);
	            return FileVisitResult.CONTINUE;
	        }
	    });
	}
	
	
	public static String getExtensionOfFile(Path path)
	{
		String fileExtension="";
		File file = path.toFile();
		// Get file Name first
		String fileName=file.getName();
		
		// If fileName do not contain "." or starts with "." then it is not a valid file
		if(fileName.contains(".") && fileName.lastIndexOf(".")!= 0)
		{
			fileExtension=fileName.substring(fileName.lastIndexOf(".")+1);
		}
		
		return fileExtension;
	}
	
	public static void main(String[] args) throws IOException {
		
		//scanFolder("/Volumes/MACINTOSH HD/AMZhtml");
		Collection<Path> samples = PagesManager.scanFolder("/Users/Mackie/Downloads/us.sitesucker.mac.sitesucker/www.euronics.it");
		for (Path page : samples) {
			List<String[]> sSet = ShinglesFactory.createSet(page);
			if(sSet.isEmpty()) {
				page.toFile().delete();
				System.out.println("deleted");
			}
			
		}
		
	}

}
