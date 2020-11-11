package tr.edu.medipol.ilerijava.ders4;

public class OrnekDers4 {

	public static void main(String[] args) throws InterruptedException {

		Arttirici ortakNesne = new Arttirici();
		
		Thread sayac0 = new Sayac(ortakNesne);
		// sayac1.run(); // normal metod cagrimi 
		sayac0.start(); // run() icindeki islemin yeni bir Thread/akis olarak calisitirilmasi
		
		Thread sayac1 = new Sayac("Sayac-1",ortakNesne);
		sayac1.start();
		
		Thread sayac2 = new Sayac("Sayac-2",ortakNesne);
		sayac2.start();
		
		Thread sayac3 = new Sayac("Sayac-3",ortakNesne);
		sayac3.start();
		
		sayac0.join(); // sayac0'in calismasinin bitmesini bekle
		sayac1.join(); 
		sayac2.join();
		sayac3.join();
		
		System.out.println("Program bitti. " + ortakNesne.TOTAL_COUNT);
	}

}
