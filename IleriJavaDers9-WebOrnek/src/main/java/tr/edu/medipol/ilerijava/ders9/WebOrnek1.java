package tr.edu.medipol.ilerijava.ders9;

import spark.*;

public class WebOrnek1 {

    public static void main(String[] args) {
        
        /*--
         http://localhost:4567/merhaba
         */
        
        Route merhabaWeb = new Route("/merhaba") {

            @Override
            public Object handle(Request request, Response response) {
                System.out.println("http://localhost:4567/merhaba istegi geldi.");
                return ""
                        + "<html>"
                            + "<head>"
                                + "<title>Merhaba Web Sayfasi</title>"
                            + "</head>"
                            + "<body>"
                                + "<p style='color:red;font-size:15px;'>Merhaba</p>"
                            + "</body>"
                        + "</html>";
            }
            
        };
        spark.Spark.get(merhabaWeb);
    }

}
