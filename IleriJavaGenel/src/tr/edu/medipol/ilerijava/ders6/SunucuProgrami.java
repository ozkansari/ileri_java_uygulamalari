package tr.edu.medipol.ilerijava.ders6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SunucuProgrami {

	private static final int SERVER_PORT = 8182;

	private static LocalDateTime sunucuBaslangicZamani;
	
	private static List<String> bagliIstemciler = new ArrayList<>();
	private static Map<Integer,DataOutputStream> istemciDataOutputMap = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		
		// 1-) Bilgisayarin belirli portundan baglanti ac
		ServerSocket sunucuSocketi = new ServerSocket(SERVER_PORT);
		// Eger verilen port baska uygulama tarafindan kullaniliyorsa, BindException olusur
		// Exception in thread "main" java.net.BindException: Address already in use: JVM_Bind
		
		System.out.println("Sunucu uygulamasi basladi");
		sunucuBaslangicZamani = LocalDateTime.now();
		
		int istemciSayaci = 0;
		while(true) {
			Socket istemciBaglantisi = sunucuSocketi.accept();
			istemciSayaci++;

			IstemciThread okuyucuThread = new IstemciThread(istemciBaglantisi, istemciSayaci);
			okuyucuThread.start();		
		}

	}
	
	private static class IstemciThread extends Thread {
		private int istemciNo;
		private DataInputStream istemciMesajAlici;
		private DataOutputStream istemciMesajGonderici;
		
		public IstemciThread(Socket istemciBaglantisi, int istemciSayaci) throws IOException {
			super("Okuyucu-" + istemciSayaci);
			istemciNo = istemciSayaci;
			istemciMesajAlici = new DataInputStream(istemciBaglantisi.getInputStream());
			istemciMesajGonderici = new DataOutputStream(istemciBaglantisi.getOutputStream());
			istemciDataOutputMap.put(istemciNo, istemciMesajGonderici);
		}
		
		private void mesajiDigerlerineGonder(String istemciAdi, String istemcidenMesaj) {
			istemciDataOutputMap.forEach( (istemciNo,istemciMesajGonderici) -> {
				if (istemciNo != this.istemciNo) {
					try {
						istemciMesajGonderici.writeUTF( "[" + istemciAdi + "] " + istemcidenMesaj);
					} catch (IOException e) {
						System.out.println("Mesaj gonderimde hata");
					}
				}
			});
		}
		
		
		@Override
		public void run() {
			try {
				String istemciAdi = istemciMesajAlici.readUTF();
				bagliIstemciler.add(istemciAdi);
				
				// Threadin yapacagi islemler
				while(true) {
					String istemcidenMesaj = istemciMesajAlici.readUTF();
					System.out.println(istemciAdi + " istemciden gelen: " + istemcidenMesaj);
					istemciMesajGonderici.writeUTF("Bagli istemciler:" + Arrays.toString(bagliIstemciler.toArray()));
					mesajiDigerlerineGonder(istemciAdi, istemcidenMesaj);
				}
				
			} catch (IOException e) {
				System.out.println("Istemciden mesaj okurken hata olustu: " + e.getMessage());
			}
			
			System.out.println("Istemci threadi kapaniyor");
			
		}

	}

}
