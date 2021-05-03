package tr.edu.medipol.ilerijava.ders9;

import spark.*;
import static spark.Spark.*;

public class WebOrnek2 {

    public static void main(String[] args) {
        
        //  http://localhost:4567/webornek2/iletisim
        get(    new WebSayfasi("/webornek2/iletisim")      );
        
        //  http://localhost:4567/webornek2/ogrenciler
        get(    new WebSayfasi("/webornek2/ogrenciler")    );
        
        //  http://localhost:4567/webornek2/ogretmenler
        get(    new WebSayfasi("/webornek2/ogretmenler")   );
        
    }
    
    private static class WebSayfasi extends Route {

        protected WebSayfasi(String path) {
            super(path);
        }

        @Override
        public Object handle(Request request, Response response) {
            
            String sayfaAdi;
            String sayfaIcerigi = "...";
            
            String path = request.pathInfo();
            if (path.endsWith("/iletisim")) {
                sayfaAdi = "Iletisim";
            } else if (path.endsWith("/ogrenciler")) {
                sayfaAdi = "Ogrenciler";
            } else if (path.endsWith("/ogretmenler")) {
                sayfaAdi = "Ogretmenler";
            } else {
                sayfaAdi = "Sayfa Bulunamadi";
            }
            
            return ""
                    + "<html>"
                    + "<head>"
                        + "<title>"
                        + sayfaAdi
                        + "</title>"
                    + "</head>"
                    + "<body>"
                        + "<h1>"
                        + sayfaAdi
                        + "</h1>"
                        + "<div>"
                        + sayfaIcerigi
                        + "</div>"
                    + "</body>"
                    + "</html>";
        }
        
    }
}
