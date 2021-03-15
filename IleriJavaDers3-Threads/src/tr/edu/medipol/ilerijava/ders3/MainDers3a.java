package tr.edu.medipol.ilerijava.ders3;

public class MainDers3a {

	public static void main(String[] args) {
		
		Thread t1 = new DosyaOkumaIslemi();
		Thread t2 = new MesajGondermeIslemi();
		Thread t3 = new Thread(new HesaplamaIslemi());
		
		t1.start();
		t2.start();
		t3.start();
		
		for (int i = 1; i <= 500; i++) {
			System.out.println(i+" - Program calismaya devam ediyor ....");
		}
	}
	
	private static class DosyaOkumaIslemi extends Thread {
		@Override
		public void run() {
			for (int i = 1; i <= 100; i++) {
				System.out.println(i+" - Dosya okunuyor...");
			}
		}
	}
	
	private static class MesajGondermeIslemi extends Thread {
		@Override
		public void run() {
			for (int i = 1; i <= 100; i++) {
				System.out.println(i+" - Mesaj gonderiliyor...");
			}
		}
	}
	
	private static class HesaplamaIslemi implements Runnable {
		@Override
		public void run() {
			for (int i = 1; i <= 100; i++) {
				System.out.println(i+" - Hesaplama yapiliyor...");
			}
		}
	}
}
