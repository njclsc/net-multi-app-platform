package bd.nmam.timely.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = {"bd.nmam.timely"})
@MapperScan(basePackages = {"bd.nmam.timely.business"})
@EnableFeignClients(basePackages = {"bd.nmam.timely"})
@EnableDiscoveryClient
@SpringBootApplication
public class TimelyStarter extends SpringBootServletInitializer{
	
	public static void main(String[] args){
		SpringApplication.run(TimelyStarter.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(TimelyStarter.class);
	}
	
}
