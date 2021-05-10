package tr.edu.medipol.ilerijava.ders10;

import java.util.*;

import spark.*;
import spark.template.freemarker.*;

import static spark.Spark.*;

public class WebOrnek4 {

    private static List<String> ogrenciler = new ArrayList<>();
    
    public static void main(String[] args) {
        
        ogrenciler.add("Ali Kemal");
        ogrenciler.add("Ayse Orta");
        ogrenciler.add("Elif Petek");
        ogrenciler.add("Mehmet Gergin");
        
  
        for (String ogrenci : ogrenciler) {
            System.out.println(ogrenci);
        }
        
        /* 
        http://localhost:4567/ogrenciler
        */
        
        Route ogrencilerSayfasi = new FreeMarkerRoute("/ogrenciler") {
            
            @Override
            public Object handle(Request request, Response response) {
                Map<String,Object> sayfaVerisi = new HashMap<>();
                sayfaVerisi.put("OGRENCI_LIST", ogrenciler);
                return new ModelAndView(sayfaVerisi, "/sayfalar/ogrenciler.html");
            }
        };
        get(ogrencilerSayfasi);
        
        
        Route ogrenciSilIstegi = new Route("/ogrenciler/sil") {
            @Override
            public Object handle(Request request, Response response) {
                String idx = request.queryParams("idx");
                ogrenciler.remove( Integer.parseInt(idx) );
                response.redirect("/ogrenciler");
                return null;
            }
        };
        get(ogrenciSilIstegi);
        
        
        Route ogrenciEkleIstegi = new Route("/ogrenciler/ekle") {
            
            @Override
            public Object handle(Request request, Response response) {
                String ogrenciAd = request.queryParams("ogrenci_ad");
                ogrenciler.add(ogrenciAd);
                response.redirect("/ogrenciler");
                return null;
            }
        };
        post(ogrenciEkleIstegi);
        
    }

}
