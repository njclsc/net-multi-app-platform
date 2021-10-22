package bd.nmam.timely.business.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import bd.nmam.timely.business.service.IInterceptorService;
import bd.nmam.timely.config.AppConfigure;
import redis.clients.jedis.JedisCluster;
@Service("InterceptorServiceimp")
public class InterceptorServiceimp implements IInterceptorService{
	@Autowired
	@Qualifier("rediSource")
	private JedisCluster jedis;
	@Override
	public boolean loginCheck(String token) {
		// TODO Auto-generated method stub
		System.out.println(token);
		if(token != null && !token.equals("")){
			String v = jedis.get(AppConfigure.tokenOperate(2, token));
			System.out.println("拦截器获取--->" + v);
			JSONObject json = JSONObject.parseObject(v);
			boolean isLogin = json.getBooleanValue("login");
			return isLogin;
		}else{
			return false;
		}


	}

}
