package tr.edu.medipol.ilerijava.ders3;

public class MainDers3b {

	// Paylasilan ortak kaynak
	private static int SAYAC = 0;
	
	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Islem("t1", 1000);
		Thread t2 = new Islem("t2", 500);
		Thread t3 = new Islem("t3", 1500);
		Thread t4 = new Islem("t4", 1500);
		Thread t5 = new Islem("t5", 1000);
		Thread t6 = new Islem("t6", 1000);
		Thread t7 = new Islem("t7", 1000);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		t6.join();
		t7.join();
		
		System.out.println(SAYAC + " adet islem tamamlandi."); // 7500
	}
	
	private static class Islem extends Thread {
		
		private int calismaSayisi;
		
		public Islem(String threadIsmi, int calismaSayisi) {
			super(threadIsmi);
			this.calismaSayisi = calismaSayisi;
		}
		
		// t1 basladi
		// t1 degerini okudu : 0
		// t1 degeri arttirdi : 0 + 1 = 1
		
		// t2 basladi
		// t2 degerini okudu : 0
		// t2 degeri arttirdi : 0 + 1 = 1
		
		// t1 degeri yazdi --> SAYAC = 1
		// t2 degeri yazdi --> SAYAC = 1
		
		@Override
		public void run() {
			for (int i = 0; i < calismaSayisi; i++) {
				System.out.println(getName() + " : calisiyor");
				
				SAYAC++; // bolunemez tek bir operasyon olarak calismali
				
				// SAYAC degerini oku : OKU
				// SAYAC degerine bir ekle : EKLE
				// SAYAC degerini geri yaz : YAZ
			}
			
		}
	}
}
