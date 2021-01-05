package tr.edu.medipol.ilerijava.webmebis;

import java.util.*;

public class Ogrenciler {

	public static List<String> ogrenciler = new ArrayList<>();
	static {
		ogrenciler.add("Ali");
		ogrenciler.add("Fatma");
	}

	public static List<String> ogrencileriGetir() {
		return ogrenciler;
	}
	
	public static void ogrenciEkle(String ogrenciAd) {
		ogrenciler.add(ogrenciAd);
	}
	
	public static void ogrenciSil(int idx) {
		ogrenciler.remove(idx);
	}
	
}
