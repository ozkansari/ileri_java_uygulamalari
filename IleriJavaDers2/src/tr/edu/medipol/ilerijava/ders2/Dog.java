package tr.edu.medipol.ilerijava.ders2;

public class Dog extends Animal {

	// Sinif degiskeni - Tek bir tane olusur
	// Tum nesneler ortak kullanir, 
	//  her nesne icin yeniden olusturulmaz.
	private static final String TYPE = "Dog";
	
	private String name;
	
	public Dog(String name) {
		this.name = name;
	}

	@Override
	public String talk() {
		return "BARK BARK!";
	}

	@Override
	public String toString() {
		return TYPE + " [name=" + name + "]";
	}
	
}
