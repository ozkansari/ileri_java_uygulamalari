package tr.edu.medipol.ilerijava.ders1.ogrenciapp;

import java.math.BigDecimal;

import tr.edu.medipol.ilerijava.ders1.ogrenciapp.model.Ogrenci;
import tr.edu.medipol.ilerijava.ders1.ogrenciapp.model.Ogretmen;

public class OgrenciUygulamasi {

	public static void main(String[] args) {
		
		// sinif (class), nesne (object) farki
		// sinif (class) bir seyin ozelliklerinin tanimlanmasi
		// nesne (object) bir seyin somut olarak olusturulmasi - new ya da instance olusturma
		
		Ogrenci mucahit = new Ogrenci("Mucahit", "Dincer", 24);
		Ogrenci ahmet = new Ogrenci("Ahmet", "Yilmaz", 22);
		
		// System.out.println(mucahit.toString() + ", " + mucahit.hashCode());
		bilgiVer(mucahit);

		// System.out.println(ahmet.toString() + ", " + ahmet.hashCode());
		bilgiVer(ahmet);
		
		Ogretmen ali = new Ogretmen("Ali", "Demir", new BigDecimal("1000") );
		bilgiVer(ali);
		
		// polymorphism = cok yuzluluk
		// Ogrenci ayni zamanda bir Object'dir
	}
	
	private static void bilgiVer(Object nesne) {
		System.out.print(nesne.toString() + ", " + nesne.hashCode() + " ");
		
		if( nesne instanceof Ogrenci) {
			Ogrenci ogrenciNesnesi = (Ogrenci) nesne;
			System.out.print( ogrenciNesnesi.getIsim() );
		} else if( nesne instanceof Ogretmen) {
			Ogretmen ogretmenNesnesi = (Ogretmen) nesne;
			System.out.print( ogretmenNesnesi.getMaas() );
		}
		
		System.out.println();
	}

}
