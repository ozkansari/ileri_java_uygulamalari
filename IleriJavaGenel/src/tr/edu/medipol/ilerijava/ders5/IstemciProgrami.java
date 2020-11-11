package tr.edu.medipol.ilerijava.ders5;

import java.net.*;
import java.io.*;

public class IstemciProgrami {

	private static final String SERVER_IP = "localhost"; // 172.20.10.3
	private static final int SERVER_PORT = 8182;
	
	public static void main(String[] args) throws Exception {
		
		// 1-) Sunucuya baglan
		Socket sunucuBaglantisi = new Socket(SERVER_IP, SERVER_PORT);
		
		// 2-) Sunucuyla Mesajlas
		DataOutputStream dataOutputStream = new DataOutputStream(sunucuBaglantisi.getOutputStream());
		dataOutputStream.writeUTF("Merhaba");
		
		DataInputStream dataInputStream = new DataInputStream(sunucuBaglantisi.getInputStream());
		String sunucudanMesaj = dataInputStream.readUTF();
		System.out.println("sunucudan gelen: " + sunucudanMesaj);
	}

}
