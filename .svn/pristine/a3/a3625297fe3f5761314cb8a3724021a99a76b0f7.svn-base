package bd.nmam.login.business.service;

import java.util.List;
import java.util.Map;

import bd.nmam.login.business.pojo.ModularPojo;
import bd.nmam.login.business.pojo.UIIndexMenuPojo;

public interface ILoginService {
	public String loginCheck(Map<String, String> paramMap);
	public String loginOut(String token);
	public List<ModularPojo> loadModular(int userIndex, int parentId);
	public List<UIIndexMenuPojo> _loadModular(int userIndex, int parentId);
	public String getUser(String token);
}
