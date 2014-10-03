
public class Equality {
	private final int value;

	public Equality(int value){
		this.value = value;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof Equality){
			Equality equality = (Equality) obj;
			return equality.value == this.value;
		}
		return false;
	}
	
	public static void main(String[] args){
		final Equality a1 = new Equality(1);
		final Equality b1 = new Equality(1);
		final Equality ca = a1;
		final Equality d2 = new Equality(2);
	}
}
