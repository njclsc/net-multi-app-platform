package bd.nmam.history.business.serviceimp;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import bd.nmam.history.business.service.IInterceptorService;
import bd.nmam.history.config.AppConfigure;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
@Service("InterceptorServiceimp")
public class InterceptorServiceimp implements IInterceptorService{
	@Autowired
	@Qualifier("rediSource")
	private JedisCluster jedis;
	@Override
	public boolean loginCheck(String token) {
		// TODO Auto-generated method stub
		if(token != null && !token.equals("")){
			String v = jedis.get(AppConfigure.tokenOperate(2, token));
			JSONObject json = JSONObject.parseObject(v);
			boolean isLogin = json.getBooleanValue("login");
			return isLogin;
		}else{
			return false;
		}

		
	}

}
