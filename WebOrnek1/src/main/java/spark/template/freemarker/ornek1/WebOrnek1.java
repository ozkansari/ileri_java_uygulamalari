package spark.template.freemarker.ornek1;

import spark.Request;
import spark.Response;
import spark.Route;

public class WebOrnek1 {

	public static void main(String[] args) {
		
		/*--
		
		http://localhost:4567/medipol/ornek1/websayfasi1
		
		 */
		
		Route ogrencilerSayfasi = new WebSayfasi2("/medipol/ogrenciler");
		spark.Spark.get(ogrencilerSayfasi);
		
		Route derslerSayfasi = new WebSayfasi2("/medipol/dersler");
		spark.Spark.get(derslerSayfasi);
		
		// anonymous class
		Route iletisimSayfasi = new Route("/medipol/iletisim") {
			@Override
			public Object handle(Request request, Response response) {
				return "<html>"
						+ "<head>"
						+ 	"<title>"
						+ "Iletisim Sayfasi"
						+ "</title>"
						+ "</head>"
						+ "<body>"
						+ "Kavacik Kampusu, Beykoz, Istanbul"
						+ "</body>"
						+ "</html>";
			}
		};
		spark.Spark.get(iletisimSayfasi);
		
	}
	
}
