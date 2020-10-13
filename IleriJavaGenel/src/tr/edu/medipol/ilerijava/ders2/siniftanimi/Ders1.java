package tr.edu.medipol.ilerijava.ders2.siniftanimi;

// Bir dosya icinde tek bir ana java public class olabilir ve dosya adiyla ayni isme sahip olmalidir
// Ancak inner class'lar da public olabilir

// public - her paketten erisim
public class Ders1 {

	public static void main(String[] args) {
		System.out.println("Ders1.main calismaya basladi");
	}
	
	
	// Inner (ic/icerideki) class tanimi
	public static class Ders1a {
		public static void main(String[] args) {
			System.out.println("Ders1a.main calismaya basladi");
		}
	}
	
}

//paket erisimi - ayni paketten erisilebilir
class Ders2 {
	
	public static void main(String[] args) {
		System.out.println("Ders2.main calismaya basladi");
	}
}

class Ders3 {
	
}