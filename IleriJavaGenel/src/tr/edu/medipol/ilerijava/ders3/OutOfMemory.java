package tr.edu.medipol.ilerijava.ders3;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemory {

	public static void main(String[] args) throws InterruptedException {
		
		List stringDepo = new ArrayList();
		for(int i=0; i<999999999;i++) {
			Thread.sleep(2000L);
			stringDepo.add( new String[99999999]);
		}
	}

}
