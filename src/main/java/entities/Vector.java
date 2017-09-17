package entities;

public class Vector {
		
	public static final int length = 8;
	
	public Vector(long b1, long b2, long b3, long b4, long b5, long b6, long b7, long b8) {
		super();
		this.b1 = b1;
		this.b2 = b2;
		this.b3 = b3;
		this.b4 = b4;
		this.b5 = b5;
		this.b6 = b6;
		this.b7 = b7;
		this.b8 = b8;
	}
	
	public  long b1;
	public  long b2;
	public  long b3;
	public  long b4;
	public  long b5;
	public  long b6;
	public  long b7;
	public  long b8;
	public long getB1() {
		return b1;
	}
	public void setB1(long b1) {
		this.b1 = b1;
	}
	public long getB2() {
		return b2;
	}
	public void setB2(long b2) {
		this.b2 = b2;
	}
	public long getB3() {
		return b3;
	}
	public void setB3(long b3) {
		this.b3 = b3;
	}
	public long getB4() {
		return b4;
	}
	public void setB4(long b4) {
		this.b4 = b4;
	}
	public long getB5() {
		return b5;
	}
	public void setB5(long b5) {
		this.b5 = b5;
	}
	public long getB6() {
		return b6;
	}
	public void setB6(long b6) {
		this.b6 = b6;
	}
	public long getB7() {
		return b7;
	}
	public void setB7(long b7) {
		this.b7 = b7;
	}
	public long getB8() {
		return b8;
	}
	public void setB8(long b8) {
		this.b8 = b8;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (b1 ^ (b1 >>> 32));
		result = prime * result + (int) (b2 ^ (b2 >>> 32));
		result = prime * result + (int) (b3 ^ (b3 >>> 32));
		result = prime * result + (int) (b4 ^ (b4 >>> 32));
		result = prime * result + (int) (b5 ^ (b5 >>> 32));
		result = prime * result + (int) (b6 ^ (b6 >>> 32));
		result = prime * result + (int) (b7 ^ (b7 >>> 32));
		result = prime * result + (int) (b8 ^ (b8 >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector other = (Vector) obj;
		if (b1 != other.b1)
			return false;
		if (b2 != other.b2)
			return false;
		if (b3 != other.b3)
			return false;
		if (b4 != other.b4)
			return false;
		if (b5 != other.b5)
			return false;
		if (b6 != other.b6)
			return false;
		if (b7 != other.b7)
			return false;
		if (b8 != other.b8)
			return false;
		return true;
	}
	
	public static Vector arrayToVector(long[] arr) {
		
		return new Vector(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]);
		
	}
	
	public static Vector copy(Vector vec) {
		
		return new Vector(vec.getB1(), vec.getB2(), vec.getB3(), vec.getB4(), vec.getB5(), vec.getB6(), vec.getB7(), 
				vec.getB8());
		
	}
	
	public static void setBN(Vector vec) {
		
		
		
	}
	

}
