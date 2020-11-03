package tr.edu.medipol.ilerijava.ders4;

// extends Thread diyerek, java sinifimiz Thread'in sahip oldugu ozellikleri kazandi
// main Thread disinda bir akista calisma ozelligi kazandi
// peki ana akistan farkli olarak hangi gorevi, opprasyonu yerine getirecek belirlemeliyiz: 
// Nasil? Thread'in run() metodu
public class Sayac extends Thread {

	// overload
	public Sayac() {
		super();
	}
	
	public Sayac(String isim) {
		super(isim);
	}
	
	@Override
    public void run() {
		// Thread calistiginda run metodu icindeki islemi gerceklestirir
		
		for(int i=0; i<1000000; i++) {
			OrnekDers4.ortakNesne.atomikIslem(getName());
		}
		
		// run metodu bitince, thread
	}
	
}
