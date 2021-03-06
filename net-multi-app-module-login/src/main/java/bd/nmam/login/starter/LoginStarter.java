package bd.nmam.login.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"bd.nmam.login"})
@MapperScan(basePackages = {"bd.nmam.login.business"})
@EnableDiscoveryClient
@SpringBootApplication
public class LoginStarter extends SpringBootServletInitializer{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(LoginStarter.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(LoginStarter.class);
	}
	

}
