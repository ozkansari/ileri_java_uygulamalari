package tr.edu.medipol.ilerijava.ders11;

import spark.*;
import spark.template.freemarker.*;

import java.util.*;

import static spark.Spark.*;



public class WebOrnek5 {

    public static void main(String[] args) {
        /*
         http://localhost:4567/webornek5/
         */

        Route anasayfa = new FreeMarkerRoute("/webornek5/") {
            @Override
            public Object handle(Request request, Response response) {
                Map<String, Object> sayfaVerisi = new HashMap<>();
                
                return new ModelAndView(sayfaVerisi, "/webornek5/index.html");
            }
        };
        get(anasayfa);
        
        
        Route ogrencilerSayfasi = new FreeMarkerRoute("/webornek5/ogrenciler/") {
            @Override
            public Object handle(Request request, Response response) {
                Map<String, Object> sayfaVerisi = new HashMap<>();
                
                return new ModelAndView(sayfaVerisi, "/webornek5/ogrenciler.html");
            }
        };
        get(ogrencilerSayfasi);
        
        
        Route ogretmenlerSayfasi = new FreeMarkerRoute("/webornek5/ogretmenler/") {
            @Override
            public Object handle(Request request, Response response) {
                Map<String, Object> sayfaVerisi = new HashMap<>();
                
                return new ModelAndView(sayfaVerisi, "/webornek5/ogretmenler.html");
            }
        };
        get(ogretmenlerSayfasi);
        
    }

}
