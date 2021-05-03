package tr.edu.medipol.ilerijava.ders9;

import spark.*;
import spark.template.freemarker.*;
import static spark.Spark.*;

public class WebOrnek3 {

    public static void main(String[] args) {
        
        // http://localhost:4567/sayfa1
        Route sayfa1 = new FreeMarkerRoute("/sayfa1") {
            @Override
            public Object handle(Request request, Response response) {
                return new ModelAndView(null, "/sayfalar/sayfa1.html");
            }
        };
        get(sayfa1);
        
    }

}
