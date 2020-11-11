package tr.edu.medipol.ilerijava.ders5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SunucuProgrami {

	private static final int SERVER_PORT = 8182;

	public static void main(String[] args) throws Exception {
		
		// 1-) Bilgisayarin belirli portundan baglanti ac
		ServerSocket sunucuSocketi = new ServerSocket(SERVER_PORT);
		// Eger verilen port baska uygulama tarafindan kullaniliyorsa, BindException olusur
		// Exception in thread "main" java.net.BindException: Address already in use: JVM_Bind
		
		System.out.println("Sunucu uygulamasi basladi");
		
		// 2-) Porta istemcinin baglanmasini bekle (baglanana kadar)
		Socket istemciBaglantisi = sunucuSocketi.accept();
		// accept() metodu istemci baglandiginda, istemciyi temsil eden Socket nesnesini olusturur
		
		
		// 3-) Istemciyle mesajlasma
		// Gelen mesajlari almak icin
		DataInputStream dataInputStream = new DataInputStream(istemciBaglantisi.getInputStream());
		String istemcidenMesaj = dataInputStream.readUTF();
		System.out.println("istemciden gelen: " + istemcidenMesaj);
		
		// Mesaj gondermek icin
		DataOutputStream dataOutputStream = new DataOutputStream(istemciBaglantisi.getOutputStream());
		dataOutputStream.writeUTF("Gonderdigin mesajini aldim " + istemcidenMesaj);
		
	}

}
