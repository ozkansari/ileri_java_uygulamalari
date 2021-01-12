package tr.edu.medipol.ilerijava.webmebis;

import spark.*;
import spark.template.freemarker.*;
import static spark.Spark.*;

import java.util.*;

public class WebMebisMain {

	private static final String OGRETMENLER_URI = "/ogretmenler";
	private static final String OGRENCILER_URI = "/ogrenciler";

	public static void main(String[] args) {
		anasayfaTanim();
		ogrencilerSayfasiTanim();
		ogretmenlerSayfasiTanimla();
		
		ogrenciSilKomutu();
		ogretmenSilKomutu();
	
		ogrenciEkleKomutu();
		ogretmenEkleKomutu();
	}

	private static class OgrenciEkleKomutu extends Route {		
		protected OgrenciEkleKomutu() {
			super("/ogrenci/ekle");
		}
		@Override
		public Object handle(Request request, Response response) {
			String ogrenciAd = request.queryParams("ogrenci_ad");
			Ogrenciler.ekle(ogrenciAd);
			response.redirect(OGRENCILER_URI);
			return null;
		}
	}
	
	private static void ogrenciEkleKomutu() {
		
		/*--
		Route ogrenciEklePOST = new Route("/ogrenci/ekle") {
			@Override
			public Object handle(Request request, Response response) {
				String ogrenciAd = request.queryParams("ogrenci_ad");
				Ogrenciler.ekle(ogrenciAd);
				response.redirect(OGRENCILER_URI);
				return null;
			}
		};
		*/
		Route ogrenciEklePOST = new OgrenciEkleKomutu();
		post(ogrenciEklePOST);
	}
	
	private static void ogretmenEkleKomutu() {
		Route ogretmenEklePOST = new Route("/ogretmen/ekle") {
			@Override
			public Object handle(Request request, Response response) {
				String ad = request.queryParams("ogretmen_ad");
				Ogretmenler.ekle(ad);
				response.redirect(OGRETMENLER_URI);
				return null;
			}
		};
		post(ogretmenEklePOST);
	}


	private static void ogrenciSilKomutu() {
		Route ogrenciSilGET = new Route("/ogrenci/sil") {
			@Override
			public Object handle(Request request, Response response) {
				int idx = Integer.parseInt( request.queryParams("id") );
				Ogrenciler.sil(idx);
				response.redirect(OGRENCILER_URI);
				return null;
			}
		};
		get(ogrenciSilGET);
	}

	private static void ogretmenSilKomutu() {
		Route ogretmenSilGET = new Route("/ogretmen/sil") {
			@Override
			public Object handle(Request request, Response response) {
				int idx = Integer.parseInt( request.queryParams("id") );
				Ogretmenler.sil(idx);
				response.redirect(OGRETMENLER_URI);
				return null;
			}
		};
		get(ogretmenSilGET);
	}

	private static void anasayfaTanim() {
		// ANASAYFA - GET - http://localhost:4567/
		Route anasayfaGET = new FreeMarkerRoute("/") {
			public Object handle(Request request, Response response) {
				return new ModelAndView(null, "anasayfa.html");
			}
		};
		get(anasayfaGET);
	}

	private static void ogrencilerSayfasiTanim() {
		// OGRENCILER SAYFASI - GET - http://localhost:4567/ogrenciler
		Route ogrencilerGET = new FreeMarkerRoute(OGRENCILER_URI) {
			@Override
			public Object handle(Request request, Response response) {

				List<String> ogrenciler = Ogrenciler.getir();

				Map<String, Object> sayfaVerisi = new HashMap<>();
				sayfaVerisi.put("OGRENCI_LST", ogrenciler);

				return new ModelAndView(sayfaVerisi, "ogrenciler.html");
			}
		};
		get(ogrencilerGET);
	}

	private static void ogretmenlerSayfasiTanimla() {
		// OGRETMENLER SAYFASI - GET - http://localhost:4567/ogretmenler
		Route ogretmenlerGET = new FreeMarkerRoute(OGRETMENLER_URI) {
			@Override
			public Object handle(Request request, Response response) {
				
				List<String> ogretmenler = Ogretmenler.getir();
				
				Map<String, Object> sayfaVerisi = new HashMap<>();
				sayfaVerisi.put("OGRETMEN_LST", ogretmenler);
				
				return new ModelAndView(sayfaVerisi, "ogretmenler.html");
			}
		};
		get(ogretmenlerGET);
	}


}
