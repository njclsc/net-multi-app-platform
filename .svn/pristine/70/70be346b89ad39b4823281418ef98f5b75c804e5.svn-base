package bd.nmam.timely.config;

import javax.websocket.server.ServerEndpointConfig;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class RegistServerEndpoint extends ServerEndpointConfig.Configurator implements ApplicationContextAware{
	private static volatile BeanFactory context;
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		RegistServerEndpoint.context = arg0;
	}
	@Override
	public <T> T getEndpointInstance(Class<T> clazz) throws InstantiationException {
		// TODO Auto-generated method stub
		return context.getBean(clazz);
	}

}
