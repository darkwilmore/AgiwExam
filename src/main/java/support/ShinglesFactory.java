package support;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class ShinglesFactory {
	
	static final int L = 10;
	
	public static void main(String[] args) {
			
		
	}
	
	public static HashMap<Path, Vector<Long>> pageToVector(Path input) {
		
		List<String[]> shingles = createSet(input);
		Vector<Long> vector = createVector(shingles);
		
		HashMap<Path, Vector<Long>> res = new HashMap<Path, Vector<Long>>();
		res.put(input, vector);
		
		return res;
		
	}
	
	public static List<String[]> createSet(Path input){
		
		
		List<String[]> shingles = new ArrayList<String[]>();
		
		try {
			Document doc = Jsoup.parse(input.toFile(), "UTF-8");
			Elements eles = doc.getAllElements();

			
		while(eles.size() > L)	{
			String[] shingle = new String[L];
			for(int n=0; n<L; n++) {
				
				shingle[n] = eles.get(n).tagName();
			}
			
			shingles.add(shingle);
			eles.remove(0);
		}
				

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return shingles;
		
		
	}
	
	public static Vector<Long> createVector(List<String[]> sSet) {
		
		Vector<Long> vector = new Vector<Long>(8);
		
		for(int i=0; i<8; i++) {
			
			vector.add(i, min(i, sSet));
			
		}
		
		//Vector vect = Vector.arrayToVector(vector);
		
		return vector;
		

	
	}

	private static long min(int i, List<String[]> sSet) {

		List<Long> hashValues = new ArrayList<Long>();
		
		for (String[] shin : sSet) {
			
			hashValues.add(HashFactory.nHash(shin, i));
			
		}
		
		return Collections.min(hashValues);
		
	}
	
	@SuppressWarnings("unchecked")
	public static List<Vector<Long>> createMasked(Vector<Long> vector) {
		
		List<Vector<Long>> maskedList = new ArrayList<Vector<Long>>();
		
		// 8/8 v'
		//maskedList.add(vector);
		
		// 7/8 v'
		for(int i=0; i<8; i++ ) {
			
			Vector<Long> vect78 = (Vector<Long>) vector.clone();	
			vect78.set(i, 0L);
			maskedList.add(vect78);
			
		}
		
		//6/8 v'
		for(int i=0; i<7; i++ ) {
			
			for(int j=i+1; j<8; j++ ) {
				
				Vector<Long> vect68 = (Vector<Long>) vector.clone();	
				vect68.set(i, 0L);
				vect68.set(j, 0L);
				maskedList.add(vect68);
			}
			
		}
		
		return maskedList;
		
		
	}

}
