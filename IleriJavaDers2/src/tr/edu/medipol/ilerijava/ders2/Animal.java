package tr.edu.medipol.ilerijava.ders2;
// abstract : direkt olarak new'lenemez / yani nesne olustutulamaz
public abstract class Animal {

	protected AnimalColor animalColor;
	protected int lengthCm;
	protected int weightGr;
	private int positionX;
	private int positionY;
	
	public abstract String talk();
	
	public void walk() {
		positionX++;
	}

	@Override
	public String toString() {
		return "Animal [animalColor=" + animalColor + ", lengthCm=" + lengthCm + ", weightGr=" + weightGr
				+ ", positionX=" + positionX + ", positionY=" + positionY + "]";
	}
	
}
