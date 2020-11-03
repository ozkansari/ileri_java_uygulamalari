package tr.edu.medipol.ilerijava.ders4;

public class OrnekDers4 {

	public static Arttirici ortakNesne = new Arttirici();
	
	public static void main(String[] args) throws InterruptedException {

		Sayac sayac0 = new Sayac();
		// sayac1.run(); // normal metod cagrimi 
		sayac0.start(); // run() icindeki islemin yeni bir Thread/akis olarak calisitirilmasi
		
		Sayac sayac1 = new Sayac("Sayac-1");
		sayac1.start();
		
		Sayac sayac2 = new Sayac("Sayac-2");
		sayac2.start();
		
		Sayac sayac3 = new Sayac("Sayac-3");
		sayac3.start();
		
		sayac0.join(); // sayac0'in calismasinin bitmesini bekle
		sayac1.join(); 
		sayac2.join();
		sayac3.join();
		
		System.out.println("Program bitti. " + ortakNesne.TOTAL_COUNT);
	}

}
