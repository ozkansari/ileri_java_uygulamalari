package tr.edu.medipol.ilerijava.ders2;

public class Cat extends Animal {

	private static final String TYPE = "Cat";
	
	private String name;
	
	public Cat() {
		super.animalColor = AnimalColor.UNKNOWN;
	}
	
	public Cat(String name) {
		this.name = name;
	}
	
	// constructor overload
	public Cat(AnimalColor animalColor) {
		super.animalColor = animalColor;
	}
	
	// constructor overload
	public Cat(int lengthCm, int weightGr) {
		super.animalColor = animalColor;
	}
	
	@Override
	public String talk() {
		return "MEOWW!";
	}

	@Override // Ust sinifin toString'ini eziyor
	public String toString() {
		return TYPE + " [name=" + name + "]";
	}
}
