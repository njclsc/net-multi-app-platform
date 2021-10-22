package bd.nmam.collection.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableFeignClients(basePackages = "bd.nmam.collection")
@EnableDiscoveryClient
@EnableScheduling
@ComponentScan(basePackages = {"bd.nmam.collection"})
@SpringBootApplication
public class CollectionStarter extends SpringBootServletInitializer{
	public static void main(String[] args){
		SpringApplication.run(CollectionStarter.class, args);
		
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(CollectionStarter.class);
	}
}
