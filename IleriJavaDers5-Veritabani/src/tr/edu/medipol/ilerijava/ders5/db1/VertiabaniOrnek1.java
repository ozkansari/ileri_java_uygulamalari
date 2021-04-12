package tr.edu.medipol.ilerijava.ders5.db1;

import java.sql.*;

public class VertiabaniOrnek1 {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Uygulama aciliyor.");
		
		// ADIM-1: VERITABANINA BAGLAN **************************************************
		
		// 1A-) JDBC Connection String / Baglanti cumlecigi olusturma
		// String jdbcUrl = "jdbc:derby:memory:ornek1;create=true"; // In-memory veritabani
		String jdbcUrl = "jdbc:derby:./ornek1;create=true"; // Dosya tabanli veritabani
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
		
		// 3B -) Insert komutu ile veri ekle
		String yeniOgrenciSql = "INSERT INTO ogrenciler VALUES ( 'mehmet', 25)";
		veritabaniKomutu.executeUpdate(yeniOgrenciSql);
		System.out.println("Ogrenci eklendi");
		
		// 3C-) Verileri sorgula
		String ogrenciKayitlariSql = "SELECT * FROM ogrenciler";
		ResultSet sonuclar = veritabaniKomutu.executeQuery(ogrenciKayitlariSql);
		while(sonuclar.next()) { // bir sonraki kayit mevcutsa true, baska kayit yoksa false
			
			String ogrenciIsim = sonuclar.getString("isim");
			int ogrenciYas = sonuclar.getInt(2);
			System.out.printf("%s - %d %n", ogrenciIsim, ogrenciYas);
			// System.out.println(ogrenciIsim + " - " + ogrenciYas);
		}

		
		
		System.out.println("Program sonlandi");	
	}

}
