package entities;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class Cluster {

	public Vector<Long> maskedVector;
	public List<Path> pages;
	public Map<Vector<Long>, Integer> mapV;
	public Vector<Long> getMaskedVector() {
		return maskedVector;
	}
	public void setMaskedVector(Vector<Long> maskedVector) {
		this.maskedVector = maskedVector;
	}
	public List<Path> getPages() {
		return pages;
	}
	public void setPages(List<Path> pages) {
		this.pages = pages;
	}
	public void addPage(Path page){
		if (this.pages==null)
			this.pages = new ArrayList<Path>();
		this.pages.add(page);
	}
	public Map<Vector<Long>, Integer> getMapV() {
		return mapV;
	}
	public void setMapV(Map<Vector<Long>, Integer> mapV) {
		this.mapV = mapV;
	} 
	
	public void addMapVector(Vector<Long> key, Integer value) {
		 mapV = new HashMap<Vector<Long>, Integer>();
		 this.mapV.put(key, value);
	}
	@Override
	public String toString() {
		return "Cluster [maskedVector=" + maskedVector + ", pages=" + pages + ", mapV=" + mapV + "]";
	}
	
}
