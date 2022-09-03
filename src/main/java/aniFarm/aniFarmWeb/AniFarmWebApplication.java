package aniFarm.aniFarmWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AniFarmWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AniFarmWebApplication.class, args);
	}

}
