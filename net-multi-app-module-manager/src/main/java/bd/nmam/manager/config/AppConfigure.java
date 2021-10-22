package bd.nmam.manager.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;

import bd.nmam.manager.business.pojo.UserPojo;

@Configuration
public class AppConfigure {
	private static int organizationId;
	private static String JWT_ALG;
	private static String JWT_TYP;
	private static String JWT_SECRET;
	private static long JWT_EXPIRES;
	//flag : 1=生成token; 2=解析token; 3=获取参数值
	public static String tokenOperate(int flag, Object _infoOrToken){
		if(flag == 1){
			Map<String,Object> h_map=new HashMap<>();
			h_map.put("alg", AppConfigure.getJWT_ALG());
			h_map.put("typ", AppConfigure.getJWT_TYP());
			UserPojo infoOrToken = (UserPojo)_infoOrToken;
			return JWT.create().withHeader(h_map)
						.withClaim("userIndex", "" + infoOrToken.getId())
						.withClaim("account", infoOrToken.getAccount())
						.withClaim("roleIndex", "" + infoOrToken.getRoleIndex())
						.withClaim("organizationId", infoOrToken.getOrganizationId())
						.withIssuedAt(new Date(System.currentTimeMillis()))
						.withExpiresAt(new Date(System.currentTimeMillis() + AppConfigure.getJWT_EXPIRES()))
						.withSubject(infoOrToken.getAccount())
						.sign(Algorithm.HMAC256(AppConfigure.JWT_SECRET));
		}else if(flag == 2){
			Map<String, Claim> claims = JWT.decode((String)_infoOrToken).getClaims();
			Claim claim2 = claims.get("account");
			Claim claim1 = claims.get("organizationId");
			System.out.println("key ----->>>>redis     " + claim1.asInt() + "-" + claim2.asString());
			return claim1.asInt() + "-" + claim2.asString();
		}else if(flag == 3){
			Map<String, Claim> claims = JWT.decode((String)_infoOrToken).getClaims();
			Claim claim1 = claims.get("userIndex");
			Claim claim2 = claims.get("account");
			return claim1.asInt() + "-" + claim2.asString();
		}else{
			return "";
		}
		
	}
	@Bean
	public Object initInfo(@Value("${service.organizationId}")int organizationId,
			@Value("${token.jwt.alg}")String alg, 
			@Value("${token.jwt.typ}")String typ, 
			@Value("${token.jwt.secret}")String secret, 
			@Value("${token.jwt.expires}")long expires){
		AppConfigure.setOrganizationId(organizationId);
		AppConfigure.setJWT_ALG(alg);
		AppConfigure.setJWT_TYP(typ);
		AppConfigure.setJWT_SECRET(secret);
		AppConfigure.setJWT_EXPIRES(expires);
		return null;
	}
	public static String tokenParse(String token, String key){
		return JWT.decode(token).getClaims().get(key).asString();
	}
	public static int getOrganizationId() {
		return organizationId;
	}

	public static void setOrganizationId(int organizationId) {
		AppConfigure.organizationId = organizationId;
	}
	public static String getJWT_ALG() {
		return JWT_ALG;
	}
	public static void setJWT_ALG(String jWT_ALG) {
		JWT_ALG = jWT_ALG;
	}
	public static String getJWT_TYP() {
		return JWT_TYP;
	}
	public static void setJWT_TYP(String jWT_TYP) {
		JWT_TYP = jWT_TYP;
	}
	public static String getJWT_SECRET() {
		return JWT_SECRET;
	}
	public static void setJWT_SECRET(String jWT_SECRET) {
		JWT_SECRET = jWT_SECRET;
	}
	public static long getJWT_EXPIRES() {
		return JWT_EXPIRES;
	}
	public static void setJWT_EXPIRES(long jWT_EXPIRES) {
		JWT_EXPIRES = jWT_EXPIRES;
	}
	
}
