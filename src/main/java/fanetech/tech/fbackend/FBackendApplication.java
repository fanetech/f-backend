package fanetech.tech.fbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class FBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FBackendApplication.class, args);
	}

}
