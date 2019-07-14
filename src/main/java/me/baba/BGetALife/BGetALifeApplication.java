package me.baba.BGetALife;

import me.baba.BGetALife.model.Bike;
import me.baba.BGetALife.model.Owner;
import me.baba.BGetALife.model.User;
import me.baba.BGetALife.repository.BikeRepository;
import me.baba.BGetALife.repository.OwnerRepository;
import me.baba.BGetALife.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BGetALifeApplication {

	// AUTO WIRING USED TO ENABLE DEPENDENCY INJECTION
	@Autowired
	private BikeRepository bikeRepository;

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private UserRepository userRepository;

	private Logger logger = LogManager.getLogger(BGetALifeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BGetALifeApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return arg -> {
			List<Bike> tanveerBikes= new ArrayList<>();
			List<Bike> deepakBikes= new ArrayList<>();
			Owner tanveer = new Owner("Tanveer","Baba");
			ownerRepository.save(tanveer);
			tanveerBikes.add(bikeRepository.save(new Bike("Giant","Propel Advanced SL 1 Disc","Black","G-3002",2019,75000,tanveer)));
			tanveerBikes.add(bikeRepository.save(new Bike("Marin Bikes","Mountain HardTail","Blue","MBS-4512",2019,75000,tanveer)));
			tanveer.setBikes(tanveerBikes);
			Owner deepak = new Owner("Deepak","G");
			ownerRepository.save(deepak);
			deepakBikes.add(bikeRepository.save(new Bike("GT Bikes","Gravity","purple","GB-3021",2018,207013,deepak)));
			deepak.setBikes(deepakBikes);
			logger.info(tanveerBikes);
			logger.info(deepakBikes);

			userRepository.save(new User("tanveer","$2a$10$i0pkNw61V8qg8nCESL3dQ.5zJAkqi6W1P5ghZcVa3ur9nX9AVcKFy","USER"));
			userRepository.save(new User("baba","$2a$10$i0pkNw61V8qg8nCESL3dQ.5zJAkqi6W1P5ghZcVa3ur9nX9AVcKFy","ADMIN"));
		};
	}
}
