package tr.edu.medipol.ilerijava.ders4;

// extends Thread diyerek, java sinifimiz Thread'in sahip oldugu ozellikleri kazandi
// main Thread disinda bir akista calisma ozelligi kazandi
// peki ana akistan farkli olarak hangi gorevi, opprasyonu yerine getirecek belirlemeliyiz: 
// Nasil? Thread'in run() metodu
public class Sayac extends Thread {

	private Arttirici arttirici;
	
	// overload
	public Sayac(Arttirici arttirici) {
		super();
		this.arttirici = arttirici;
	}
	
	public Sayac(String isim, Arttirici arttirici) {
		super(isim);
		this.arttirici = arttirici;
	}
	
	@Override
    public void run() {
		// Thread calistiginda run metodu icindeki islemi gerceklestirir
		
		for(int i=0; i<1000000; i++) {
			arttirici.atomikIslem(getName());
		}
		
		// run metodu bitince, thread
	}
	
}
