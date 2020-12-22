package spark.template.freemarker.ornek1;

import spark.*;

public class WebSayfasi1 extends Route {

	protected WebSayfasi1(String path) {
		super(path);
	}

	@Override
	public Object handle(Request istek, Response cevap) {
		return "<html>"
				+ "<head>"
				+ 	"<title>Web Ornek 1</title>"
				+ "</head>"
				+ "<body>"
				+ "Web Ornek 1 - Merhaba!"
				+ "</body>"
				+ "</html>";
	}
}
