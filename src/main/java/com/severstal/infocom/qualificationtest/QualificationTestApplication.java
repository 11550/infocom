package com.severstal.infocom.qualificationtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QualificationTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(QualificationTestApplication.class, args);
	}

}
//@SpringBootApplication
//@RequiredArgsConstructor
//public class QualificationTestApplication implements ApplicationRunner {
//	private final ProviderRepository providerRepository;
//
//	public static void main(String[] args) {
//		SpringApplication.run(QualificationTestApplication.class, args);
//	}
//
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		providerRepository.save(new Supplier());
//		providerRepository.save(new Supplier());
//		System.out.println(providerRepository.findAll());
//	}
//}
