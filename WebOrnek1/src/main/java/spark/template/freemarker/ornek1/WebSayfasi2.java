package spark.template.freemarker.ornek1;

import spark.*;
import java.util.*;

public class WebSayfasi2 extends Route {

	private List<String> dersler = new ArrayList<>();
	private List<String> ogrenciler = new ArrayList<>();
	
	protected WebSayfasi2(String path) {
		super(path);
		
		dersler.add("Ileri Java");
		dersler.add("Veritabani Sistemleri");
		
		ogrenciler.add("Ali Varol");
		ogrenciler.add("Zeynep Zenbilli");
		ogrenciler.add("Tahsin Yargici");
	}

	@Override
	public Object handle(Request istek, Response cevap) {
		
		String path = istek.pathInfo();
		System.out.printf("%s istegi isleniyor", path);
		
		String icerik = "";
		String sayfaBasligi = "";
		if (path.endsWith("/medipol/ogrenciler")) {
			
			sayfaBasligi = "Ogrenciler Sayfasi";
			for (String ogrenci : ogrenciler) {
				icerik += ogrenci + "<br>";
			}
			
		} else if (path.endsWith("/medipol/dersler")) {
			
			sayfaBasligi = "Dersler Sayfasi";
			for (String ders : dersler) {
				icerik += ders + "<br>";
			}

		}
		
		return "<html>"
				+ "<head>"
				+ 	"<title>"
				+ sayfaBasligi
				+ "</title>"
				+ "</head>"
				+ "<body>"
				+ icerik
				+ "</body>"
				+ "</html>";
	}
}
