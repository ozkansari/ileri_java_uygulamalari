package tr.edu.medipol.ilerijava.ders2.ogrenciapp.model;

public class Birey {

	protected String isim;
	protected String soyad;
	protected String tckimlikno;
	
	// constructor - olusturucu- newlerken deger atama
	public Birey(String isim, String soyad) {
		this.isim = isim;
		this.soyad = soyad;
	}
	
	public void setTckimlikNo(String tckimlikno) {
		this.tckimlikno = tckimlikno;
	}
}
