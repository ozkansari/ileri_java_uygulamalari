package tr.edu.medipol.ilerijava.ders6;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class IstemciProgrami {

	private static final String SERVER_IP = "localhost"; // 172.20.10.3
	private static final int SERVER_PORT = 8182;
	
	public static void main(String[] args) throws Exception {
		
		Scanner konsolOkuyucu = new Scanner(System.in);
		
		System.out.println("Uygulama basladi");
		
		// 1-) Sunucuya baglan
		Socket sunucuBaglantisi = new Socket(SERVER_IP, SERVER_PORT);
		
		System.out.println("Sunucuya baglanti kuruldu");
		
		DataInputStream dataInputStream = new DataInputStream(sunucuBaglantisi.getInputStream());
		new OkuyucuThread(dataInputStream).start();
		
		DataOutputStream dataOutputStream = new DataOutputStream(sunucuBaglantisi.getOutputStream());
		
		System.out.println("Adinizi yaziniz: >");
		String adiniz = konsolOkuyucu.nextLine();
		dataOutputStream.writeUTF(adiniz);
		
		while(true) {	
			System.out.println("Mesaj yaz: >");
			String mesaj = konsolOkuyucu.nextLine();
			dataOutputStream.writeUTF(mesaj);
		}
	}
	
	private static class OkuyucuThread extends Thread {
		private DataInputStream mesajAlici;
		public OkuyucuThread(DataInputStream mesajAlici) {
			this.mesajAlici = mesajAlici;
		}

		@Override
		public void run() {
			while(true) {
				try {
					String sunucudanMesaj = mesajAlici.readUTF();
					System.out.println("sunucudan gelen: " + sunucudanMesaj);
				} catch (IOException e) {
					System.out.println("Sunucudan mesaj okunurken hata olustu: " + e.getMessage());
					break;
				}
			}
		}
	}

}
