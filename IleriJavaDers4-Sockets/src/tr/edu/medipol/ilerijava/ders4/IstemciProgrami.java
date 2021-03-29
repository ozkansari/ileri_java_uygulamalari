package tr.edu.medipol.ilerijava.ders4;

import java.net.*;
import java.io.*;

//Sunucu ve Istemci ayri main() metodlarina sahip yani ayri program olarak calisir

public class IstemciProgrami {

	private static final String SERVER_IP = "localhost";
	private static final int SERVER_PORT = 8882;
	
	
	public static void main(String[] args) throws UnknownHostException, IOException {

		System.out.println("Istemci programi basladi");
		
		// Belirtilen IP-PORTa baglanilamazsa : java.net.ConnectException:
		Socket sunucuBaglantisi = new Socket(SERVER_IP, SERVER_PORT);
		
		System.out.println("Sunucuya baglanti kuruldu. Sunucu IP: " 
				+ sunucuBaglantisi.getInetAddress().getHostName() );
		
		
		System.out.println("Istemci programi kapaniyor");
	}

}
