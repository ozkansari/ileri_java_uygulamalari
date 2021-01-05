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
		
	}

	private static void ogrenciEkleKomutu() {
		
		Route ogrenciEklePOST = new Route("/ogrenci/ekle") {
			@Override
			public Object handle(Request request, Response response) {
				String ogrenciAd = request.queryParams("ogrenci_ad");
				Ogrenciler.ogrenciEkle(ogrenciAd);
				response.redirect(OGRENCILER_URI);
				return null;
			}
		};
		post(ogrenciEklePOST);
	}

	private static void ogrenciSilKomutu() {
		Route ogrenciSilGET = new Route("/ogrenci/sil") {
			@Override
			public Object handle(Request request, Response response) {
				int idx = Integer.parseInt( request.queryParams("id") );
				Ogrenciler.ogrenciSil(idx);
				response.redirect(OGRENCILER_URI);
				return null;
			}
		};
		get(ogrenciSilGET);
	}

	private static void ogretmenSilKomutu() {
		// TODO
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

				List<String> ogrenciler = Ogrenciler.ogrencileriGetir();

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
				return new ModelAndView(null, "ogretmenler.html");
			}
		};
		get(ogretmenlerGET);
	}


}
