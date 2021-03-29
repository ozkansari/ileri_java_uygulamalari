package tr.edu.medipol.ilerijava.ders4;

import java.net.*;
import java.io.*;

// Sunucu ve Istemci ayri main() metodlarina sahip yani ayri program olarak calisir
public class SunucuProgrami {

	private static final int SERVER_PORT = 8882;
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Sunucu programi basladi");
		
		// Port kullanimdaysa - java.net.BindException alir
		ServerSocket sunucuSocket = new ServerSocket(SERVER_PORT);
		
		System.out.println("Sunucu socket olusturuldu. Port: " + SERVER_PORT);
		
		boolean sunucuCalissin = true;
		while(sunucuCalissin) {
			
			System.out.println("Yeni istemci baglantisi bekleniyor...");
			
			// Bloklanmis sekilde, istemci baglanana kadar bekler
			Socket istemciBaglantisi = sunucuSocket.accept();
			
			new Thread(new IstemciRunnable(istemciBaglantisi)).start();
		}

		System.out.println("Sunucu programi kapaniyor");
	}
	
	private static class IstemciRunnable implements Runnable {

		private Socket istemciBaglantisi;
		
		IstemciRunnable(Socket istemciBaglantisi) {
			this.istemciBaglantisi = istemciBaglantisi;
			System.out.printf(
					"Istemci baglandi. Istemci IP: %s, Port: %s " 
					, istemciBaglantisi.getInetAddress().getHostAddress()
					, istemciBaglantisi.getPort()
			);
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
