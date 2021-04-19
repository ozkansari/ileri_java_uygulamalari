package tr.edu.medipol.ilerijava.ders6.gui1;

import javax.swing.*;

public class MasaUstuUygulamaOrnek1 {

	public static void main(String[] args) {
		new OgrenciEkrani("Mebis Masaustu", 500, 300);
	}

	private static class OgrenciEkrani extends JFrame {
		
		private OgrenciEkrani(String pencereAdi, int en, int boy){
			this.setTitle(pencereAdi);
			this.setSize(en, boy);
			this.setResizable(false);
			
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			ekranOlustur();
			
			setVisible(true);
		}
		
		private void ekranOlustur() {
			
			JTextArea bilgiPaneli = new JTextArea();
			bilgiPaneli.setEditable(false);
			this.add(bilgiPaneli);
			
			// Ornek
			int i = 0;
			while(i++ < 3) {
				bilgiPaneli.setText( bilgiPaneli.getText() + "\n" + "Yeni kayit-"+i );
			}
		}
	}
}
