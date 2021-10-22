package bd.nmam.timely.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import bd.nmam.timely.business.controller.AuthInterceptor;


@Configuration
public class WebApplicationConfig extends WebMvcConfigurationSupport {
	
	@Autowired
	private AuthInterceptor authInterceptor;
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(authInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/static/*");
//		super.addInterceptors(registry);
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub

		
	}


	
}