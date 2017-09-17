package support;

import net.openhft.hashing.LongHashFunction;

public class HashFactory {
	
	public static long h1Hash(String[] shingle) {
		
		long seed = 123L;
		String str = String.join(" ", shingle);
		long hash = LongHashFunction.murmur_3(seed).hashChars(str);
		
		return hash;

	}
	
	public static long h2Hash(String[] shingle) {
		
		long seed = 456L;
		String str = String.join(" ", shingle);
		long hash = LongHashFunction.xx(seed).hashChars(str);
		
		return hash;

	}
	
	public static long h3Hash(String[] shingle) {
		
		long seed = 789L;
		String str = String.join(" ", shingle);
		long hash = LongHashFunction.murmur_3(seed).hashChars(str);
		
		return hash;

	}
	
	public static long h4Hash(String[] shingle) {
		
		long seed = 1357L;
		String str = String.join(" ", shingle);
		long hash = LongHashFunction.murmur_3(seed).hashChars(str);
		
		return hash;

	}
	
	public static long h5Hash(String[] shingle) {
		
		long seed = 2468L;
		String str = String.join(" ", shingle);
		long hash = LongHashFunction.murmur_3(seed).hashChars(str);
		
		return hash;

	}
	
	public static long h6Hash(String[] shingle) {
		
		long seed = 1470L;
		String str = String.join(" ", shingle);
		long hash = LongHashFunction.murmur_3(seed).hashChars(str);
		
		return hash;

	}
	
	public static long h7Hash(String[] shingle) {
		
		long seed = 2581L;
		String str = String.join(" ", shingle);
		long hash = LongHashFunction.murmur_3(seed).hashChars(str);
		
		return hash;

	}
	
	public static long h8Hash(String[] shingle) {
		
		long seed = 3692L;
		String str = String.join(" ", shingle);
		long hash = LongHashFunction.murmur_3(seed).hashChars(str);
		
		return hash;

	}
	
	public static long nHash(String[] shingle, int n) {
		
		
		String str = String.join(" ", shingle);
		long seed;
		long hash = 0L;
		switch(n) {
		
		case 0:
			
			seed = 40134798L;
			hash = LongHashFunction.xx(seed).hashChars(str);
			break;
			
		case 1:
			
			seed = 41304786L;
			hash = LongHashFunction.xx(seed).hashChars(str);
			break;
			
		case 2:
			seed = 394761410L;
			hash = LongHashFunction.xx(seed).hashChars(str);
			break;
			
		case 3:
			seed = 182469345L;
			hash = LongHashFunction.xx(seed).hashChars(str);
			break;
			
		case 4:
			seed = 491863451L;
			hash = LongHashFunction.xx(seed).hashChars(str);
			break;
			
		case 5:
			seed = 987345823L;
			hash = LongHashFunction.xx(seed).hashChars(str);
			break;	
			
		case 6:
			seed = 753483904L;
			hash = LongHashFunction.xx(seed).hashChars(str);
			break;	
			
		case 7:
			seed = 175248435L;
			hash = LongHashFunction.xx(seed).hashChars(str);
			break;			
		}
		
		return hash;
		
	}
	

	

}
