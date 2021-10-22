package bd.nmam.demon.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"bd.nmam.demon"})
@SpringBootApplication
public class DemonStarter extends SpringBootServletInitializer{

	public static void main(String[] args){
		SpringApplication.run(DemonStarter.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(DemonStarter.class);
	}
	
}
