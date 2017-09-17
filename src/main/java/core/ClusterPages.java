package core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import java.util.HashMap;

import java.util.Iterator;
import java.util.LinkedHashMap;

import java.util.List;

import java.util.Vector;

import entities.Cluster;
import support.PagesManager;
import support.ShinglesFactory;

public class ClusterPages {
	
	public static void main(String[] args) throws IOException {
		
		Collection<Path> samples = PagesManager.scanFolder("/Users/Mackie/Downloads/us.sitesucker.mac.sitesucker/www.euronics.it");
		
		HashMap<Vector<Long>, Integer> hashT = new HashMap<Vector<Long>, Integer>();
		//8/8 Vectors Map
		HashMap<Vector<Long>,Integer> masked88 = new HashMap<Vector<Long>,Integer>();
		
		for (Path page : samples) {
			
			List<String[]> sSet = ShinglesFactory.createSet(page);
			
			Vector<Long> vector = ShinglesFactory.createVector(sSet);
			

			
			if(masked88.containsKey(vector))
				masked88.put(vector, masked88.get(vector) + 1);
			else
				masked88.put(vector, 1);
			
			List<Vector<Long>> maskedVs = ShinglesFactory.createMasked(vector);
			
			for(Vector<Long> masked : maskedVs ) {				
				
				if(cover(masked, vector)) {
					
					if(hashT.containsKey(masked))
						hashT.put(masked, hashT.get(masked) + 1);
					else
						hashT.put(masked, 1);
				}
				
			}
			
			
		}
		
		
		
		LinkedHashMap<Vector<Long>,Integer> sortedMask = sortHashMapByValuesDes(hashT);
		LinkedHashMap<Vector<Long>,Integer> sorted88 = sortHashMapByValuesAsc(masked88);
		
		/*for(Vector<Long> cover : sortedMask.keySet()) {
			System.out.println(cover.toString() + " " + sortedMask.get(cover));
		}*/
		
		//------------ Second Pass ---------------
		
		for(Vector<Long> v88 : sorted88.keySet()) {
			
			boolean found = false;
			
			for(Vector<Long> vMask : sortedMask.keySet()) {
				
				if(!found) {
					if(cover(v88,vMask))
						found=true;	
				}	
				else {
					if(cover(v88,vMask))
						sortedMask.put(vMask, sortedMask.get(vMask)-1);
				}

			}
			
		}
		
		LinkedHashMap<Vector<Long>,Integer> sortedMask2Pass = sortHashMapByValuesDes(sortedMask);
		
		//----------- Third Pass ------------
		
		HashMap<Path, Vector<Long>> p2v = new HashMap<Path, Vector<Long>>();
		List<Cluster> clusters = new ArrayList<Cluster>();
		
		for (Path page : samples) {
			p2v = ShinglesFactory.pageToVector(page);
		}
		
		
		for (Vector<Long> maskV3 : sortedMask2Pass.keySet() ){
			
			Cluster currCluster = new Cluster();
			currCluster.setMaskedVector(maskV3);
			for(Path page : p2v.keySet()) {
				
				if(cover(p2v.get(page),maskV3)){
					currCluster.addPage(page);
					currCluster.addMapVector(p2v.get(page), sortedMask2Pass.get(maskV3));
					clusters.add(currCluster);
					p2v.remove(page);
				}
				
			}
			
			
		}
				
		
		for(Vector<Long> cover : sortedMask2Pass.keySet()) {
			System.out.println(cover.toString() + " " + sortedMask2Pass.get(cover));
		}
		
		for(Cluster c : clusters) {
			System.out.println(c.toString() + " ");
		}
		
	}
	
	
	private static boolean cover(Vector a, Vector b) {
		
		int cont = 0;
		for(int i=0; i<8; i++){

			if(a.get(i).equals(b.get(i)))
				cont++;
			
		}
		if(cont>=6)
			return true;
		
		return false;
		
	}
	
	private static LinkedHashMap<Vector<Long>,Integer> sortHashMapByValuesAsc(
	        HashMap<Vector<Long>,Integer> passedMap) {
	    List<Vector<Long>> mapKeys = new ArrayList<>(passedMap.keySet());
	    List<Integer> mapValues = new ArrayList<>(passedMap.values());
	    Collections.sort(mapValues);
	    

	    LinkedHashMap<Vector<Long>,Integer> sortedMap =
	        new LinkedHashMap<>();

	    Iterator<Integer> valueIt = mapValues.iterator();
	    while (valueIt.hasNext()) {
	        Integer val = valueIt.next();
	        Iterator<Vector<Long>> keyIt = mapKeys.iterator();

	        while (keyIt.hasNext()) {
	            Vector<Long> key = keyIt.next();
	            Integer comp1 = passedMap.get(key);
	            Integer comp2 = val;

	            if (comp1.equals(comp2)) {
	                keyIt.remove();
	                sortedMap.put(key, val);
	                break;
	            }
	        }
	    }
	    return sortedMap;
	}
	
	private static LinkedHashMap<Vector<Long>,Integer> sortHashMapByValuesDes(
	        HashMap<Vector<Long>,Integer> passedMap) {
	    List<Vector<Long>> mapKeys = new ArrayList<>(passedMap.keySet());
	    List<Integer> mapValues = new ArrayList<>(passedMap.values());
	    Collections.sort(mapValues, Collections.reverseOrder());
	    

	    LinkedHashMap<Vector<Long>,Integer> sortedMap =
	        new LinkedHashMap<>();

	    Iterator<Integer> valueIt = mapValues.iterator();
	    while (valueIt.hasNext()) {
	        Integer val = valueIt.next();
	        Iterator<Vector<Long>> keyIt = mapKeys.iterator();

	        while (keyIt.hasNext()) {
	            Vector<Long> key = keyIt.next();
	            Integer comp1 = passedMap.get(key);
	            Integer comp2 = val;

	            if (comp1.equals(comp2)) {
	                keyIt.remove();
	                sortedMap.put(key, val);
	                break;
	            }
	        }
	    }
	    return sortedMap;
	}

}
