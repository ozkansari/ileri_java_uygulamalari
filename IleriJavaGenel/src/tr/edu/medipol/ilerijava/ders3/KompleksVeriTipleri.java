package tr.edu.medipol.ilerijava.ders3;

public class KompleksVeriTipleri {

	public static void main(String[] args) {
		
		/*1*/ KompleksVeriTipleri ornek1 = new KompleksVeriTipleri();
		
		// kompleks degiskende = deger olarak adres depolaniyor
		/*2*/ Sinav sinavNotu = new Sinav(50);
		
		// kompleks veri tipleri - call by reference :  
		// metoda nesnenin adresi/referansi (bir nevi kendisi) geciliyor
		/*3*/ ornek1.sinavNotuDuzelt(sinavNotu);
		
		/*5*/ System.out.println(sinavNotu.sinavNotu);
	}
	
	public void sinavNotuDuzelt(Sinav sinav) {
		/*4*/ sinav.sinavNotu = 100;
	}
	
	private static class Sinav {
		int sinavNotu;
		String dersAdi;
		
		public Sinav(int sinavNotu) {
			this.sinavNotu = sinavNotu;
		}
	}
	
}
