package tr.edu.medipol.ilerijava.ders2.ogrenciapp.model;

import java.math.BigDecimal;

public class Ogretmen extends Birey {

	private BigDecimal maas;
	
	public Ogretmen(String isim, String soyad, BigDecimal maas) {
		super(isim, soyad);
		this.maas = maas;
	}

	public BigDecimal getMaas() {
		return maas;
	}

}
