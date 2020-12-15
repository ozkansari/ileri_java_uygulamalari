package tr.edu.medipol.ilerijava.ders9;

import java.sql.*;
import java.util.*;

public class VeritabaniOrnek1 {

	public static void main(String[] args) throws SQLException {
		
		// ADIM-1: VERITABINAN BAGLAN
		
		// Local mysql
		String jdbcUrl = 
				"jdbc" + ":" +	// jdbc javanin standard veritabani baglanti mekanizmasi
				"mysql" + ":" +	// apache derby kullandigimizi belirtiyoruz
				"//localhost:3306/ilerijava_ders8";		// veritabani ip:port/db_adi
		
		// Online db4freenet 
		String jdbcUrl2 = "jdbc:mysql://db4free.net:3306/ilerijava_ders8";
		
		Connection veritabaniBaglantisi = DriverManager.getConnection(jdbcUrl2, "ilerijava_ders8", "ilerijava_ders8");
		System.out.printf("Veritabanina baglanildi: %s %n", veritabaniBaglantisi.toString() );

		// ADIM-2 : VERITABANI KOMUTU OLUSTUR
		// Veritabaninda komut calistirmayi saglayacak Statement olusturuluyor
		Statement veritabaniKomutu = veritabaniBaglantisi.createStatement();
		
		// ADIM-3 TABLO OLUSTUR
		try {
			String sql = "CREATE TABLE ogrenciler ( isim varchar(40) , yas int )";
			veritabaniKomutu.executeUpdate(sql);
			System.out.println("ogrenciler tablosu olusturuldu.");
		} catch(Exception e) {
			System.out.printf("Tablo zaten var ya da baska bir sorun olustu. Hata: %s %n", e.getMessage());
		}
		
		// Konsoldan veri al
		Scanner konsolOkuyucu = new Scanner(System.in);
		System.out.println("isim ve yas gir. Ornek: Ali 23. >> ");
		String kullaniciGirisi = konsolOkuyucu.nextLine();
		String [] girdiler = kullaniciGirisi.split(" "); 	// "Ali 23"u bosluga gore parcaladik, array olustu: girdiler
		String isim = girdiler[0];
		int yas = Integer.parseInt(girdiler[1]);
		System.out.printf("%s veritabanina kaydedilecek %n", kullaniciGirisi);
		
		// ADIM-4: VERITABANI TABLOSU VERI EKLE - INSERT
		String insertSql = String.format("INSERT INTO ogrenciler VALUES ('%s' , %d)", isim, yas);
		veritabaniKomutu.executeUpdate(insertSql);
		System.out.printf("%s veritabanina basariyla kaydedildi %n", kullaniciGirisi);
		
		
		// ADIM 5 - VERILERI SORGULAMA ve ALMA - SELECT
		String selectSql = "SELECT * FROM ogrenciler";
		ResultSet sonuclar = veritabaniKomutu.executeQuery(selectSql);
		
		System.out.println("--------------------------------");
		System.out.println("OGRENCI LISTESI");
		System.out.println("--------------------------------");
		// bir sonraki satira (row) ilerlediyse true doner, ilerleyemediyse yani baska veri yoksa false doner
		while(sonuclar.next()) { 
			String sonucIsim = sonuclar.getString("isim");
			int sonucYas = sonuclar.getInt(2);
			System.out.printf("%s %d %n", sonucIsim, sonucYas);
		}
		System.out.println("--------------------------------");
		
	}

}
