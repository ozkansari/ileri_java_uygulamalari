package tr.edu.medipol.ilerijava.ders2.ogrenciapp;

import java.math.BigDecimal;

import tr.edu.medipol.ilerijava.ders1.ogrenciapp.model.Birey;
import tr.edu.medipol.ilerijava.ders1.ogrenciapp.model.Ogrenci;
import tr.edu.medipol.ilerijava.ders1.ogrenciapp.model.Ogretmen;

public class OgrenciUygulamasi {

	public static void main(String[] args) {
		
		// foreach
		for (String a : args) {
			System.out.println(a);
		}
		
		// normal for
		for (
			int i = 0;       // ilklendirme - initialization - tek bir kere dongu baslarken calisir
			i < args.length; // dongunun devam etme kosulu, her bir donusde kontrol edilir
			i++				 // her bir dongude cagrilir, her bir donuste calistirilir
		) {
			String a = args[i];
			System.out.println(a);
		}
	
		// while
		int i = 0;
		while (i < args.length) {
			String a = args[i];
			System.out.println(a);
			i++;
		}
		

		// sinif (class), nesne (object) farki
		// sinif (class) bir seyin ozelliklerinin tanimlanmasi
		// nesne (object) bir seyin somut olarak olusturulmasi - new ya da instance olusturma
		
		Ogrenci mucahit = new Ogrenci("Mucahit", "Dincer", 24, "12345");
		Ogrenci ahmet = new Ogrenci("Ahmet", "Yilmaz", 22, "45436546");
		
		// System.out.println(mucahit.toString() + ", " + mucahit.hashCode());
		bilgiVer(mucahit);

		// System.out.println(ahmet.toString() + ", " + ahmet.hashCode());
		bilgiVer(ahmet);
		
		Ogretmen ali = new Ogretmen("Ali", "Demir", new BigDecimal("1000") );
		bilgiVer(ali);
		
		bireyDizisiOrnek(mucahit, ahmet, ali);
		
		
		// polymorphism = cok yuzluluk
		// Ogrenci ayni zamanda bir Object'dir
	}

	private static void bireyDizisiOrnek(Ogrenci mucahit, Ogrenci ahmet, Ogretmen ali) {
		Birey [] bireyler = new Birey[3];
		bireyler[0] = mucahit;
		bireyler[1] = ahmet;
		bireyler[2] = ali;
		
		// Bir sonraki satir hata verir: ArrayIndexOutOfBoundsException
		// bireyler[3] = new Ogrenci("Selim", "Seker", 18, "12214321");
		
		for (Birey birey : bireyler) {
			System.out.println(birey);
		}
	}
	
	private static void bilgiVer(Birey nesne) {
		System.out.print(nesne.toString() + ", " + nesne.hashCode() + " ");
		
		if( nesne instanceof Ogrenci) {
			Ogrenci ogrenciNesnesi = (Ogrenci) nesne;
			System.out.print( ogrenciNesnesi.getYas() );
		} else if( nesne instanceof Ogretmen) {
			Ogretmen ogretmenNesnesi = (Ogretmen) nesne;
			System.out.print( ogretmenNesnesi.getMaas() );
		}
		
		System.out.println();
	}

}
