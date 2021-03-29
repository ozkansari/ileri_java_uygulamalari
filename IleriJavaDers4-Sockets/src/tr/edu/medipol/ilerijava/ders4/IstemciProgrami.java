package tr.edu.medipol.ilerijava.ders4;

import java.net.*;
import java.util.Scanner;
import java.io.*;

//Sunucu ve Istemci ayri main() metodlarina sahip yani ayri program olarak calisir

public class IstemciProgrami {

	private static final String SERVER_IP = "localhost";
	private static final int SERVER_PORT = 8883;
	
	
	public static void main(String[] args) throws UnknownHostException, IOException {

		System.out.println("Istemci programi basladi");
		
		// Belirtilen IP-PORTa baglanilamazsa : java.net.ConnectException:
/*[B]*/	Socket sunucuBaglantisi = new Socket(SERVER_IP, SERVER_PORT);
		
		System.out.println("Sunucuya baglanti kuruldu. Sunucu IP: " 
				+ sunucuBaglantisi.getInetAddress().getHostName() );
		
		// TODO
		
		InputStream sunucuOkuyucu = sunucuBaglantisi.getInputStream();
		OutputStream sunucuGonderici = sunucuBaglantisi.getOutputStream();
		
		DataInputStream sunucuDataOkuyucu = new DataInputStream(sunucuOkuyucu);
		DataOutputStream sunucuDataGonderici = new DataOutputStream(sunucuGonderici);
		
		Scanner konsolOkuyucu = new Scanner(System.in);
		System.out.println("Adinizi giriniz: ");
		String name = konsolOkuyucu.nextLine();
		
		sunucuDataGonderici.writeUTF("Merhaba " + name + " >>>");
		String okunanData = sunucuDataOkuyucu.readUTF();
		System.out.println("Okunan: " + okunanData);
		
		System.out.println("Istemci programi kapaniyor");
		konsolOkuyucu.close();
	}

}
