package tr.edu.medipol.ilerijava.ders1;

import java.time.LocalDateTime;

public class Main {

	// nesneye has - nesne degiskeni
	// her bir nesne olusturdugumda (new) - bilgisayar hafizasinda yeni bir yer ayriliyor
	private LocalDateTime olusturulmaTarihi;
	
	public Main() {
		olusturulmaTarihi = LocalDateTime.now();
	}
	
	// sinif metodu
	private static void log() {
		Main nesne1 = new Main();
		boolean donus1 = nesne1.ozelLog("Uygulama aciliyor");
		
		Main nesne2 = new Main();
		boolean donus2 = nesne2.ozelLog("Ders 1'den merhaba");
	}
	
	// nesne metodu
	private boolean ozelLog(String mesaj) {
		System.out.println(olusturulmaTarihi + ":" + mesaj);
		return true;
	}
	
	public static void main(String[] args) {
		Main.log();
	}
}
