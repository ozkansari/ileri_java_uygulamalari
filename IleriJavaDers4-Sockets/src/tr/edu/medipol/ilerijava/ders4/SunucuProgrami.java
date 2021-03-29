package tr.edu.medipol.ilerijava.ders4;

import java.net.*;
import java.io.*;

// Sunucu ve Istemci ayri main() metodlarina sahip yani ayri program olarak calisir
public class SunucuProgrami {

	private static final int SERVER_PORT = 8883;
	
	private static int baglananIstemciSayisi = 0;
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Sunucu programi basladi");
		
		// Port kullanimdaysa - java.net.BindException alir
/*[A]*/	ServerSocket sunucuSocket = new ServerSocket(SERVER_PORT);
		
		System.out.println("Sunucu socket olusturuldu. Port: " + SERVER_PORT);
		
		boolean sunucuCalissin = true;
		while(sunucuCalissin) {
			
			System.out.println("Yeni istemci baglantisi bekleniyor...");
			
			// Bloklanmis sekilde, istemci baglanana kadar bekler
/*[B]*/		Socket istemciBaglantisi = sunucuSocket.accept();
			baglananIstemciSayisi++;
			
			new Thread(
					new IstemciRunnable(istemciBaglantisi), 
					String.valueOf(baglananIstemciSayisi) 
				).start();
		}

		System.out.println("Sunucu programi kapaniyor");
	}
	
	private static class IstemciRunnable implements Runnable {

		private Socket istemciBaglantisi;
		private InputStream sunucuOkuyucu;
		private OutputStream sunucuGonderici;
		
		IstemciRunnable(Socket istemciBaglantisi) throws IOException {
			this.istemciBaglantisi = istemciBaglantisi;
			this.sunucuOkuyucu = istemciBaglantisi.getInputStream();
			this.sunucuGonderici = istemciBaglantisi.getOutputStream();
			System.out.printf(
					"Istemci baglandi. Istemci IP: %s, Port: %s %n" 
					, istemciBaglantisi.getInetAddress().getHostAddress()
					, istemciBaglantisi.getPort()
			);
		}
		
		@Override
		public void run() {
			
			DataInputStream sunucuDataOkuyucu = new DataInputStream(sunucuOkuyucu);
			DataOutputStream sunucuDataGonderici = new DataOutputStream(sunucuGonderici);
			
			while(true) {
				
				try {
					String okunanData = sunucuDataOkuyucu.readUTF();
					System.out.println("Okunan: " + okunanData);

					sunucuDataGonderici.writeUTF("Mesaj alindi <<<");
					
				} catch (IOException e) {
					System.out.println("Mesaj okuma hatasi: " + e.getMessage());
					return;
				}
				
			}
		}
		
	}

}
