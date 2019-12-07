package pe.edu.cibertec.Viajes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "pe.edu.cibertec.Viajes" })
public class ViajesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViajesApplication.class, args);
	}

}
