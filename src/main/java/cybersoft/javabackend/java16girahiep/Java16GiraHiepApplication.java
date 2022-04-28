package cybersoft.javabackend.java16girahiep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Java16GiraHiepApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java16GiraHiepApplication.class, args);
	}

}
