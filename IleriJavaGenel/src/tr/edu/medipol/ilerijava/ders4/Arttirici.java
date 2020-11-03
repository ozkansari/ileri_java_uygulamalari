package tr.edu.medipol.ilerijava.ders4;

public class Arttirici {

	public int TOTAL_COUNT = 0; 
	
	// bu metodun icine yanlizca tek bir thread girebilir
	// bir anda bu netodun icinde tek bir thread calisabilir
	public synchronized void atomikIslem(String isim) {
		// ++ operasyonu 3 parcadan olusur
		// 1 memoryye yukle
		// degeri arttir
		// degeri degiskene geri yaz
		TOTAL_COUNT++;
		
		System.out.println(
			isim +" sayac calisiyor " + TOTAL_COUNT
		);
	}
	
	
}
