package tr.edu.medipol.ilerijava.WebMebisSpring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebMebisSpringApplication implements CommandLineRunner {

	@Autowired
	private OgrenciRepository ogrenciRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(WebMebisSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Uygulama acildi");
		
		ogrenciRepository.deleteAll();
		
		Ogrenci ogrenci1 = new Ogrenci();
		ogrenci1.setIsim("Ali");
		ogrenci1.setYas(21);
		ogrenciRepository.save(ogrenci1);
		
		Ogrenci ogrenci2 = new Ogrenci();
		ogrenci2.setIsim("Ayşe");
		ogrenci2.setYas(23);
		ogrenciRepository.save(ogrenci2);
		
		
		List<Ogrenci> ogrenciler = ogrenciRepository.findAll();
		for (Ogrenci ogrenci : ogrenciler) {
			System.out.printf("%d-) %s %d %n", ogrenci.getId(), ogrenci.getIsim(), ogrenci.getYas());
		}
		
	}

	// Object Relational Mapping
}
