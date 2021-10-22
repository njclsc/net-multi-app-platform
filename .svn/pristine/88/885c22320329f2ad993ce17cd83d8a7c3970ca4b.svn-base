package bd.nmam.manager.business.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import bd.nmam.manager.business.pojo.ModifyRoleModularPojo;
import bd.nmam.manager.business.pojo.ModularPojo;
import bd.nmam.manager.business.pojo.RoleModularPojo;
import bd.nmam.manager.business.pojo.RolePojo;

public interface IRoleManagerService {
	public String add(RolePojo role, HttpServletRequest request);
	public String remove(RolePojo role);
	public String modify(RolePojo role, HttpServletRequest request);
	public String find(RolePojo role);
	
	//小菜单
	public String showRoleAndModular_1(RolePojo role);
	public String haveRoleAndModular_1(RolePojo role);
	public String modifyRoleAndModular_1(ModifyRoleModularPojo modifyRoleModular);
	//大菜单
	public String showRoleAndModular(RolePojo role);
	public String modifyRoleAndModular(ModifyRoleModularPojo modifyRoleModular);
//	public String updateRoleAndModular(List<RoleModularPojo> role);
	public String haveRoleAndModular(RolePojo role);
//	public String removeRoleAndModular(RoleModularPojo role);
}
