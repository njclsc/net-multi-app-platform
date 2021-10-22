package bd.nmam.login.business.serviceimp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import bd.nmam.login.business.dao.ILoginDao;
import bd.nmam.login.business.pojo.MetaPojo;
import bd.nmam.login.business.pojo.ModularPojo;
import bd.nmam.login.business.pojo.ResponsePojo;
import bd.nmam.login.business.pojo.UIIndexMenuPojo;
import bd.nmam.login.business.pojo.UserPojo;
import bd.nmam.login.business.service.ILoginService;
import bd.nmam.login.config.AppConfigure;
import redis.clients.jedis.JedisCluster;
@Service("LoginServiceImp")
public class LoginServiceImp implements ILoginService{
	@Autowired
	private ILoginDao loginDao;
	@Autowired
	@Qualifier("rediSource")
	private JedisCluster jedis;
	@Override
	public String loginCheck(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		try{
			UsernamePasswordToken token = new UsernamePasswordToken(paramMap.get("account"), paramMap.get("password"));
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			UserPojo up = new UserPojo();
			up.setAccount(paramMap.get("account"));
			up.setOrganizationId(AppConfigure.getOrganizationId());
			UserPojo _up = loginDao.loadUserInfo(up);
			_up.setPassword("");
			_up.setLogin(true);
			jedis.set(_up.getOrganizationId() + "-" + _up.getAccount(), JSONObject.toJSONString(_up));
//			jedis.expire(_up.getOrganizationId() + "-" + _up.getAccount(), 60);
			String web_token = AppConfigure.tokenOperate(1, _up);
			rp.setState("success");
			rp.setMessage("登录验证成功");
			rp.setToken(web_token);
			
//			List<ModularPojo> mps = loadModular(_up.getId(), 0);
			List<UIIndexMenuPojo> uiim = _loadModular(_up.getId(), 0);
			rp.setResult(uiim);
			rp.setServerTarget(AppConfigure.getSERVER_TARGET());
		}catch(UnknownAccountException e){
			e.printStackTrace();
			rp.setState("fail");
			rp.setMessage("账号错误");
		}catch(IncorrectCredentialsException e){
			e.printStackTrace();
			rp.setState("fail");
			rp.setMessage("密码错误");
		}
		rp.setAction("login/check");
		return JSONObject.toJSONString(rp);
	}

	@Override
	public String loginOut(String token) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		JSONObject obj = JSONObject.parseObject(AppConfigure.tokenOperate(2, token));
		jedis.del(obj.getString("organizationId") + "-" + obj.getString("account"));
		rp.setAction("login/check");
		rp.setState("success");
		rp.setMessage("用户已退出");
		return JSONObject.toJSONString(rp);
	}
//============================================
	@Override
	public List<ModularPojo> loadModular(int userIndex, int parentId) {
		// TODO Auto-generated method stub
		List<ModularPojo> mps = loginDao.findModular(userIndex, 0, 0);
		for(ModularPojo mp : mps){
			load(userIndex, mp);
		}
		return mps;
	}
	public ModularPojo load(int userIndex, ModularPojo mp){
		List<ModularPojo> _cmp = loginDao.findModular(userIndex, mp.getModularLevel() + 1, mp.getId());
		for(ModularPojo _tmp : _cmp){
			load(userIndex, _tmp);
		}
		mp.setChildren(_cmp);
		return mp;
	}
//============================================UIIndexMenuPojo
	public List<UIIndexMenuPojo> _loadModular(int userIndex, int parentId){
		List<UIIndexMenuPojo> uiim = new ArrayList<>();
		List<ModularPojo> mps = loginDao.findModular(userIndex, 0, 0);
		for(ModularPojo mp : mps){
			UIIndexMenuPojo _uiim = new UIIndexMenuPojo();
//			_uiim.setPath(mp.getUrl());---------
//			_uiim.setName(mp.getUiName());---------
//			MetaPojo meta = new MetaPojo();---------
//			meta.setTitle(mp.getModularName());---------
//			meta.setIcon(mp.getIcon());---------
//			meta.setAffix("false");---------
//			_uiim.setMeta(meta);---------
			
			
			//=================一级菜单没有子菜单=============================
			List<ModularPojo> _cmp = loginDao.findModular(userIndex, mp.getModularLevel() + 1, mp.getId());
			if(_cmp.size() <= 0){
				_uiim.setPath("/");
				_uiim.setName(null);
				_uiim.setMeta(null);
				UIIndexMenuPojo __uiim = new UIIndexMenuPojo();
//				List<UIIndexMenuPojo> uiims = new ArrayList<>();
				__uiim.setPath(mp.getUrl());
				__uiim.setName(mp.getUiName());
				MetaPojo meta = new MetaPojo();
				meta.setTitle(mp.getModularName());
				meta.setIcon(mp.getIcon());
				meta.setAffix("false");
				__uiim.setMeta(meta);
				__uiim.setChildren(null);
				_uiim.getChildren().add(__uiim);
				uiim.add(_uiim);
			}else{
				_uiim.setPath(mp.getUrl());
				_uiim.setName(mp.getUiName());
				MetaPojo meta = new MetaPojo();
				meta.setTitle(mp.getModularName());
				meta.setIcon(mp.getIcon());
				meta.setAffix("false");
				_uiim.setMeta(meta);
				uiim.add(_load(userIndex, mp, _uiim));
			}
			//===============================================================
			
			
//			uiim.add(_load(userIndex, mp, _uiim));---------
		}
		
		return uiim;
	}
	public UIIndexMenuPojo _load(int userIndex, ModularPojo mp, UIIndexMenuPojo uiimp){
		List<ModularPojo> _cmp = loginDao.findModular(userIndex, mp.getModularLevel() + 1, mp.getId());
//		List<UIIndexMenuPojo> upps = new  ArrayList<>();
		for(ModularPojo _tmp : _cmp){
//			upps.clear();
			UIIndexMenuPojo _uiimp = new  UIIndexMenuPojo();
			_uiimp.setPath(_tmp.getUrl());
			_uiimp.setName(_tmp.getUiName());
			MetaPojo meta = new MetaPojo();
			meta.setTitle(_tmp.getModularName());
			meta.setIcon(_tmp.getIcon());
			meta.setAffix("false");
			_uiimp.setMeta(meta);
//			upps.add(_load(userIndex, _tmp, _uiimp));
			uiimp.getChildren().add(_load(userIndex, _tmp, _uiimp));
		}
//		uiimp.setChildren(upps);
		return uiimp;
	}

	@Override
	public String getUser(String token) {
		// TODO Auto-generated method stub
		JSONObject obj = JSONObject.parseObject(AppConfigure.tokenOperate(2, token));
		String json = jedis.get(obj.getString("organizationId") + "-" + obj.getString("account"));
		JSONObject _obj = JSONObject.parseObject(AppConfigure.tokenOperate(2, token));
		_obj.put("state", "success");
		return _obj.toJSONString();
	}
}
