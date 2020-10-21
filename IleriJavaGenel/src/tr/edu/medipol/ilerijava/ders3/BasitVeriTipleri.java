package tr.edu.medipol.ilerijava.ders3;

public class BasitVeriTipleri {

	public static void main(String[] args) {
		
		/*1*/ BasitVeriTipleri ornek1 = new BasitVeriTipleri();
		
		// basit degiskende = deger olarak kendisi depolaniyor
		// basit degiskende = adres yok
		/*2*/ long sinavNotu = 50L; 
		
		// basit veri tipleri - call by value : degerin kopyasi metoda gecirilir
		/*3*/ ornek1.sinavNotuDuzelt(sinavNotu); // KOPYASI GECILIYOR - call by
		
		/*5*/ System.out.println(sinavNotu);
		
		/*6*/ sinavNotu = ornek1.sinavNotuDuzelt2(sinavNotu); 
		/*7*/ System.out.println(sinavNotu);
		
		
		int i; long l; float f; char a; double d;
		String s; Long l2 = 50L; Double d2; Integer i2 = new Integer(5);
		
	}
	
	public void sinavNotuDuzelt(long sinavNotu) {
		/*4*/ sinavNotu = 100L;
	}
	
	public Long sinavNotuDuzelt2(long sinavNotu) {
		/*4*/ sinavNotu = 100L;
		return sinavNotu;
	}
}
