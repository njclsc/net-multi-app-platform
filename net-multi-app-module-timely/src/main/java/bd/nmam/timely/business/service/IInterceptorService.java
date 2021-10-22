package bd.nmam.timely.business.service;

import javax.servlet.http.Cookie;

public interface IInterceptorService {

	public boolean loginCheck(String token);
	
}
