package bd.nmam.history.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import bd.nmam.history.business.controller.AuthInterceptor;

//动态与静态混合使用 必须一个要指定
@Configuration
public class WebApplicationConfig extends WebMvcConfigurationSupport {
	
	@Autowired
	private AuthInterceptor authInterceptor;
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(authInterceptor)
				.addPathPatterns("/staticSource/**");
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/**")
			.addResourceLocations("classpath:/static/");
	}


	
}
