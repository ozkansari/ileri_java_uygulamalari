package tr.edu.medipol.ilerijava.ders7.gui1;

import javax.swing.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MasaUstuUygulamaOrnek2 {

	public static void main(String[] args) throws Exception {
		
		// ADIM-1: VERITABANINA BAGLAN **************************************************
		
		// 1A-) JDBC Connection String / Baglanti cumlecigi olusturma
		// String jdbcUrl = "jdbc:derby:memory:ornek1;create=true"; // In-memory veritabani
		String jdbcUrl = "jdbc:derby:../IleriJavaDers5-Veritabani/ornek1;create=true"; // Dosya tabanli veritabani
		// String jdbcUrl = "jdbc:derby://localhost:1527/ornek1;create=true";
		
		// 1B -) Baglanti kur
		Connection veritabaniBaglantisi = DriverManager.getConnection(jdbcUrl);
		System.out.println("Veritabanina baglandi : " + veritabaniBaglantisi);
		
		
		// ADIM -2 : VERITABANI KOMUTU OLUSTUR
		Statement veritabaniKomutu = veritabaniBaglantisi.createStatement();
		
		// ADIM-3 : "Statement" NESNESIYLA SQL KOMUTU CALISTIR
		
		// 3A -) Tablo olustur
		try {
			String tabloSql = "CREATE TABLE ogrenciler ( isim varchar(40), yas int )";
			veritabaniKomutu.executeUpdate(tabloSql);
			System.out.println("Tablo olusturuldu");
		} catch(SQLException e) {
			System.out.println("UYARI: Tablo zaten var ya da baska bir hata olustu: " + e.getMessage());
		}
		
		// 3C-) Verileri sorgula
		List<String> ogrenciler = new ArrayList<>();
		String ogrenciKayitlariSql = "SELECT * FROM ogrenciler";
		ResultSet ogrenciKayitSonuclari = veritabaniKomutu.executeQuery(ogrenciKayitlariSql);
		while(ogrenciKayitSonuclari.next()) { // bir sonraki kayit mevcutsa true, baska kayit yoksa false
			
			String ogrenciIsim = ogrenciKayitSonuclari.getString("isim");
			int ogrenciYas = ogrenciKayitSonuclari.getInt(2);
			// System.out.printf("%s - %d %n", ogrenciIsim, ogrenciYas);
			// System.out.println(ogrenciIsim + " - " + ogrenciYas);
			ogrenciler.add(ogrenciIsim + " - " + ogrenciYas);
		}
		
		new OgrenciEkrani("Mebis Masaustu", 500, 300, ogrenciler);
	}

	private static class OgrenciEkrani extends JFrame {
		
		private OgrenciEkrani(String pencereAdi, int en, int boy, List<String> ogrenciler){
			this.setTitle(pencereAdi);
			this.setSize(en, boy);
			this.setResizable(false);
			
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			ekranOlustur(ogrenciler);
			
			setVisible(true);
		}
		
		private void ekranOlustur(List<String> ogrenciler) {
			
			JTextArea bilgiPaneli = new JTextArea();
			bilgiPaneli.setEditable(false);
			this.add(bilgiPaneli);
			
			// Ornek
			int i = 0;
			for (String ogrenci : ogrenciler) {
				bilgiPaneli.setText( bilgiPaneli.getText() + "\n" + ogrenci );
			}
		}
	}
}
