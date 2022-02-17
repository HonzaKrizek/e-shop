package cz.honza.eshop;

import cz.honza.eshop.entyty.SubtypeEnum;
import cz.honza.eshop.entyty.TypeEnum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class EshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshopApplication.class, args);

	}

}
