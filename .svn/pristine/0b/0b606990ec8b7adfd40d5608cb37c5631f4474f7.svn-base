package bd.nmam.manager.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"bd.nmam.manager"})
@MapperScan(basePackages = {"bd.nmam.manager.business"})
@SpringBootApplication
public class ManagerStarter extends SpringBootServletInitializer{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ManagerStarter.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(ManagerStarter.class);
	}
}
