package ClassAndObject;

public class Constructor {
	
	abstract static class Animal {
		public Animal() {
			System.out.println("Animal constructor is called");
		}
	}
	
	static class Horse extends Animal{
		public Horse() {
			System.out.println("Horse constructor is called");
		}
	}
	
	static class Mustang extends Horse{
		public Mustang() {
			System.out.println("Mustang constructor is called");
		}
	}

	public static void main(String[] args) {
		
		Mustang m1 = new Mustang();
	}
}
