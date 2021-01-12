package tr.edu.medipol.ilerijava.webmebis;

import java.util.*;

public class Ogretmenler {

	public static List<String> ogretmenler = new ArrayList<>();
	static {
		ogretmenler.add("Ali");
		ogretmenler.add("Fatma");
	}

	public static List<String> getir() {
		return ogretmenler;
	}
	
	public static void ekle(String ad) {
		ogretmenler.add(ad);
	}
	
	public static void sil(int idx) {
		ogretmenler.remove(idx);
	}
	
}
