package tr.edu.medipol.ilerijava.ders7.gui1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MasaUstuUygulamaOrnek3 {

	public static void main(String[] args) {
		new OgrenciEkrani("Mebis Masaustu", 500, 300);
	}

	private static class OgrenciEkrani extends JFrame {
		
		private OgrenciEkrani(String pencereAdi, int en, int boy){
			this.setTitle(pencereAdi);
			this.setSize(en, boy);
			this.setResizable(false);
			
			// Pencereyi ortala
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int x = (int) screenSize.getWidth() / 2 - en / 2;
			int y = (int) screenSize.getHeight() / 2 - boy / 2;
			this.setLocation(x, y);
			
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			ekranOlustur();
			
			setVisible(true);
		}
		
		private void ekranOlustur() {
			
			this.setLayout(new GridLayout(4,1));
			
			JTextArea bilgiPaneli = new JTextArea(5, 40);
			bilgiPaneli.setEditable(false);
			this.add(new JScrollPane(bilgiPaneli) );
			bilgiPaneli.setText("--- Ogrenciler ---");
			
			JPanel kullaniciAdiPaneli = new JPanel();
			JLabel kullaniciAdiBilgi = new JLabel("Kullanici adi:");
			kullaniciAdiPaneli.add(kullaniciAdiBilgi);
			JTextField kullaniciAdiAlani = new JTextField(30);
			kullaniciAdiPaneli.add(kullaniciAdiAlani);
			this.add(kullaniciAdiPaneli);
			
			JPanel kullaniciSoyadiPaneli = new JPanel();
			JLabel kullaniciSoyadiBilgi = new JLabel("Kullanici Soyadi:");
			kullaniciSoyadiPaneli.add(kullaniciSoyadiBilgi);
			JTextField kullaniciSoyadiAlani = new JTextField(30);
			kullaniciSoyadiPaneli.add(kullaniciSoyadiAlani);
			this.add(kullaniciSoyadiPaneli);
			
			JPanel ekleButonuPaneli = new JPanel();
			JButton ekleButonu = new JButton("EKLE");
			ekleButonuPaneli.add(ekleButonu);
			this.add(ekleButonuPaneli);
			
			/* BUTON AKSIYON YONTEM-1: Standart sinif tanimlama*/
			ekleButonu.addActionListener(new EkleButonuAksiyonu(kullaniciAdiAlani, kullaniciSoyadiAlani,bilgiPaneli));

			/* BUTON AKSIYON YONTEM-2: Anonymous Class*/
			/*--
			ekleButonu.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Butona basildi");
				}
			});
			*/
			
			/* BUTON AKSIYON YONTEM-3 */
			/*--
			ekleButonu.addActionListener( event -> {
				System.out.println("Butona basildi");
			});
			*/
	
		}
	}
	
	/* BUTON AKSIYON YONTEM-1 icin gerekli */
	private static class EkleButonuAksiyonu implements ActionListener {
		
		private JTextField kullaniciAdiAlani;
		private JTextField kullaniciSoyadiAlani;
		private JTextArea bilgiPaneli;
		
		public EkleButonuAksiyonu(JTextField kullaniciAdiAlani, JTextField kullaniciSoyadiAlani,JTextArea bilgiPaneli) {
			this.kullaniciAdiAlani = kullaniciAdiAlani;
			this.kullaniciSoyadiAlani = kullaniciSoyadiAlani;
			this.bilgiPaneli = bilgiPaneli;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String kullaniciAdi = kullaniciAdiAlani.getText();
			String kullaniciSoyad = kullaniciSoyadiAlani.getText();
			
			
			if (kullaniciAdi == null || kullaniciAdi.trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "Kullanici adi bos olamaz");
				return;
			}
			
			if (kullaniciSoyad == null || kullaniciSoyad.trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "Kullanici soyadi bos olamaz");
				return;
			}
			
			bilgiPaneli.setText( bilgiPaneli.getText() + "\n" + kullaniciAdi + " , " + kullaniciSoyad );
			kullaniciAdiAlani.setText("");
			kullaniciSoyadiAlani.setText("");

		}
	}
}
