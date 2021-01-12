package tr.edu.medipol.ilerijava.webmebis;

import java.util.*;

public class Ogrenciler {

	public static List<String> ogrenciler = new ArrayList<>();
	static {
		ogrenciler.add("Ali");
		ogrenciler.add("Fatma");
	}

	public static List<String> getir() {
		return ogrenciler;
	}
	
	public static void ekle(String ogrenciAd) {
		ogrenciler.add(ogrenciAd);
	}
	
	public static void sil(int idx) {
		ogrenciler.remove(idx);
	}
	
}
