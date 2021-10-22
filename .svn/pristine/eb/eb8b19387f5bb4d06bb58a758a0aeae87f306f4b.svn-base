package bd.nmam.login.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import bd.nmam.login.business.dao.ILoginDao;
import bd.nmam.login.business.pojo.UserPojo;

public class CustomRealm extends AuthorizingRealm{
	@Autowired
	private ILoginDao loginDao;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		UserPojo user = new UserPojo();
		user.setAccount((String)arg0.getPrincipal());
		user.setOrganizationId(AppConfigure.getOrganizationId());
		UserPojo _user = loginDao.findUser(user);
		if(_user != null){
			SimpleAuthenticationInfo authen = new SimpleAuthenticationInfo(_user.getAccount(), _user.getPassword(), this.getName());
			return authen;
		}else{
			return null;
		}
		
	}

}
