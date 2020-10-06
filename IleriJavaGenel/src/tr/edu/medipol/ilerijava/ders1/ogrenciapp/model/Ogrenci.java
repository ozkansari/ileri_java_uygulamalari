package tr.edu.medipol.ilerijava.ders1.ogrenciapp.model;

public class Ogrenci extends Birey {

	private int yas;
	private String yorum1;
	private String yorum2;
	
	// constructor - donus degeri yok
	public Ogrenci(String isim, String soyad, int yas) {
		super(isim, soyad);
		this.yas = yas;
	}
	
	/* 
	 * metod tanimi 4 parcadan olusur:
	 * - visibility/gorunurluk: public, private, protected, ""
	 * - donus degeri (output)
	 * - metod ismi
	 * - parametreler (input)
	 */
	public String getIsim() {
		return isim;
	}

	public void yorumEkle(String yorum1, String yorum2) {
		this.yorum1 = yorum1;
		this.yorum2 = yorum2;
	}

}
