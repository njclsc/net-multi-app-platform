package bd.nmam.manager.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import bd.nmam.manager.business.controller.AuthInterceptor;


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
//	@Override
//	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		// TODO Auto-generated method stub
//		super.configureMessageConverters(converters);
//		converters.add(responseBodyConverter());
//	}
//	@Bean
//	public HttpMessageConverter<String> responseBodyConverter(){
//		return new StringHttpMessageConverter(Charset.forName("UTF-8"));
//	}
//	@Override
//	protected void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//		// TODO Auto-generated method stub
////		super.configureContentNegotiation(configurer);
//		configurer.favorParameter(false);
//	}

	
}
