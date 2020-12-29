package spark.template.freemarker.ornek2;

import java.util.*;

import spark.*;
import spark.template.freemarker.FreeMarkerRoute;


public class WebOrnek2 {

	private static List<String> ogrenciListesi = new ArrayList<>();
	private static List<String> ogretmenListesi = new ArrayList<>();
	
	public static void main(String[] args) {
		
		ogrenciListesi.add("Ali");
		ogrenciListesi.add("Fatma");
		ogrenciListesi.add("Ahmet");
		ogrenciListesi.add("Zeynep");
		ogrenciListesi.add("Kamil");
		for (String ogr : ogrenciListesi) {
			System.out.println(ogr);
		}
		
		
		ogretmenListesi.add("Mahmut Hoca");
		ogretmenListesi.add("Ayse Hoca");
		
		/*--
		http://localhost:4567/sayfa1
		 */
		Route sayfa1 = new FreeMarkerRoute("/sayfa1") {
			@Override
			public Object handle(Request request, Response response) {
				return new ModelAndView(null, "/ornek2/sayfa1.html"); 
			}
		};
		spark.Spark.get(sayfa1);
		
		
		/*--
		http://localhost:4567/ogrenciler
		 */
		Route ogrencilerSayfasi = new FreeMarkerRoute("/ogrenciler") {
			@Override
			public Object handle(Request request, Response response) {
				
				Map<String,Object> sayfaVerisi = new HashMap<>();
				sayfaVerisi.put("OGRENCI_LST", ogrenciListesi);
				sayfaVerisi.put("OGRETMEN_LST", ogretmenListesi);
				
				return new ModelAndView(sayfaVerisi, "/ornek2/ogrencilerSayfasi.html"); 
			}
		};
		spark.Spark.get(ogrencilerSayfasi);
		
		
		// OGRENCI EKLEME FORMUNU KARSILAR
		Route ogrenciEkleFormAction = new Route("/ornek2/ogrenci/ekle") {
			@Override
			public Object handle(Request request, Response response) {
				String ogrenciAd = request.queryParams("ogrenci_ad");
				ogrenciListesi.add(ogrenciAd);
				response.redirect("/ogrenciler");
				return null;
			}
		};
		spark.Spark.post(ogrenciEkleFormAction);
		
		
		// OGRETMEN EKLEME FORMUNU KARSILAR
		Route ogretmenEkleFormAction = new Route("/ornek2/ogretmen/ekle") {
			@Override
			public Object handle(Request request, Response response) {
				String ogretmenAd = request.queryParams("ogretmen_ad");
				ogretmenListesi.add(ogretmenAd);
				response.redirect("/ogrenciler");
				return null;
			}
		};
		spark.Spark.post(ogretmenEkleFormAction);
		
		
		// OGRENCI SIL ISTEGINI KARSILAR
		Route ogrenciSilIstegi = new Route("/ornek2/ogrenci/sil") {
			@Override
			public Object handle(Request request, Response response) {
				String id = request.queryParams("id");
				ogrenciListesi.remove(Integer.parseInt(id));
				response.redirect("/ogrenciler");
				return null;
			}
		};
		spark.Spark.get(ogrenciSilIstegi);
		
		// OGRETMEN SIL ISTEGINI KARSILAR
		Route ogretmenSilIstegi = new Route("/ornek2/ogretmen/sil") {
			@Override
			public Object handle(Request request, Response response) {
				String id = request.queryParams("id");
				ogretmenListesi.remove(Integer.parseInt(id));
				response.redirect("/ogrenciler");
				return null;
			}
		};
		spark.Spark.get(ogretmenSilIstegi);
		
	}

}
