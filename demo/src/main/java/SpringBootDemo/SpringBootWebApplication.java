package SpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

@EnableTransactionManagement
@EnableJms
@RestController
@SpringBootApplication
@ComponentScan(basePackages = {"SpringBootDemo"})
@EntityScan("SpringBootDemo")
public class SpringBootWebApplication  {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication .class, args);
	}
}
