package tr.edu.medipol.ilerijava.ders2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Animal comar = new Dog("comar");
		Dog rex = new Dog("rex");
		
		Animal tekir = new Cat(AnimalColor.BLACK_WHITE);
		Cat pamuk = new Cat("pamuk");
		
		// Animal animal = new Animal(); // HATALI - abstract class direkt newlenemez
		
		// Anonymous class
		Animal unknownCreature = new Animal() {
			@Override
			public String talk() {
				return "ROARRRRRRRR!";
			}
		};
		
		Animal [] animalsArray = new Animal[4];
		animalsArray[0] = comar;
		animalsArray[1] = rex;
		animalsArray[2] = tekir;
		animalsArray[3] = pamuk;
		// animalsArray[4] = unknownCreature; // Array Index Out Of Bounds exception
		
		List<Animal> animals = new ArrayList<>();
		animals.add(comar);
		animals.add(rex);
		animals.add(tekir);
		animals.add(pamuk);
		animals.add(unknownCreature);
		
		for (Animal a : animals) {
			System.out.println(a + " : " + a.talk());
			// System.out.println(a.toString());
		}

		
		
	}

}
