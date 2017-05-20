package edu.mum.coffee;

//import edu.mum.coffee.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CoffeShopApplication {

	public static void main(String[] args) {
            //AnnotationConfigApplicationContext(AppConfig.class);
            SpringApplication.run(CoffeShopApplication.class, args);
	}
}