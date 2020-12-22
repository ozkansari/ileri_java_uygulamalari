package tr.edu.medipol.ilerijava.ders7;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.*;

public class Ekran1 extends JFrame {

	private static final long serialVersionUID = 1L;

	public Ekran1(int width, int height) {
		
		setTitle("Ekran 1");
		
		setSize(width, height);
		setResizable(false);	
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) screenSize.getWidth() / 2 - width/2;
		int y = (int) screenSize.getHeight() / 2 - height/2;
		setLocation(x,y);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ekranOlustur();
		
		setVisible(true);
	}

	private void ekranOlustur() {
		GridLayout layout = new GridLayout(4, 1);
		this.setLayout( layout );
		
		JTextArea bilgiPaneli = new JTextArea();
		bilgiPaneli.setEditable(false);
		this.add( new JScrollPane(bilgiPaneli) );
		
		JPanel kullaniciAdiPanel = new JPanel(new GridLayout(1,2));
		kullaniciAdiPanel.add(new JLabel("Kullanıcı adı:"));
		JTextField kullaniciAdiAlani = new JTextField(20);
		kullaniciAdiPanel.add(kullaniciAdiAlani);
		this.add(kullaniciAdiPanel);
		
		JPanel sifrePaneli = new JPanel(new GridLayout(1,2));
		sifrePaneli.add(new JLabel("Şifre: "));
		sifrePaneli.add(new JPasswordField(20));
		this.add(sifrePaneli);
	
		JButton girisButonu = new JButton("EKLE");
		girisButonu.addActionListener( event -> {
			bilgiPaneli.setText( bilgiPaneli.getText() + " " + kullaniciAdiAlani.getText() + "\n");
			kullaniciAdiAlani.setText("");
			// bilgiPaneli.setCaretPosition( bilgiPaneli.getDocument().getLength() );
		});
		this.add(girisButonu);
		
	}
	
}
