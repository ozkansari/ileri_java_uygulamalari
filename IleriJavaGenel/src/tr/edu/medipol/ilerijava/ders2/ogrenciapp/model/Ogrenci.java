package tr.edu.medipol.ilerijava.ders2.ogrenciapp.model;

public class Ogrenci extends Birey {

	private static final String UNIVERSITE = "Medipol";
	private int yas;
	private String yorum1;
	private String yorum2;
	
	// constructor - donus degeri yok
	public Ogrenci(String isim, String soyad, int yas, String tckimlikno) {
		super(isim, soyad);
		this.yas = yas;
		setTckimlikNo(tckimlikno);
	}
	
	public void setTckimlikNo(String tckimlikno) {
		super.setTckimlikNo(tckimlikno);
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

	public int getYas() {
		return yas;
	}

	public void yorumEkle(String yorum1, String yorum2) {
		this.yorum1 = yorum1;
		this.yorum2 = yorum2;
	}
	
	

}
