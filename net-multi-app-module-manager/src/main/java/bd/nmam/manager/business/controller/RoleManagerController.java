package bd.nmam.manager.business.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bd.nmam.manager.business.pojo.ModifyRoleModularPojo;
import bd.nmam.manager.business.pojo.RolePojo;
import bd.nmam.manager.business.service.IRoleManagerService;

@RestController
@RequestMapping(value = "/role", produces="application/json;charset=utf-8")
public class RoleManagerController {
	@Autowired
	@Qualifier("RoleManagerServiceImp")
	private IRoleManagerService roleManagerService;
	@RequestMapping("add")
	public String add(@RequestBody RolePojo role, HttpServletRequest request){
		return roleManagerService.add(role, request);
	}
	@RequestMapping("remove")
	public String remove(@RequestBody RolePojo role){
		return roleManagerService.remove(role);
	}
	@RequestMapping("modify")
	public String remove(@RequestBody RolePojo role, HttpServletRequest request){
		return roleManagerService.modify(role, request);
	}
	@RequestMapping("find")
	public String find(@RequestBody RolePojo role){
		return roleManagerService.find(role);
	}
	//权限分配
	//小菜单
	@RequestMapping("showRoleAndModular_1")
	public String showRoleAndModular_1(@RequestBody RolePojo role){
		return roleManagerService.showRoleAndModular_1(role);
	}
	@RequestMapping("haveRoleAndModular_1")
	public String haveRoleAndModular_1(@RequestBody RolePojo role){
		return roleManagerService.haveRoleAndModular_1(role);
	}
	@RequestMapping("modifyRoleAndModular_1")
	public String modifyRoleAndModular_1(@RequestBody ModifyRoleModularPojo modifyRoleModular){
		return roleManagerService.modifyRoleAndModular_1(modifyRoleModular);
	}
	//大菜单
	@RequestMapping("showRoleAndModular")
	public String showRoleAndModular(@RequestBody RolePojo role){
		return roleManagerService.showRoleAndModular(role);
	}
	@RequestMapping("modifyRoleAndModular")
	public String modifyRoleAndModular(@RequestBody ModifyRoleModularPojo modifyRoleModular){
		return roleManagerService.modifyRoleAndModular(modifyRoleModular);
	}
//	@RequestMapping("updateRoleAndModular")
//	public String updateRoleAndModular(@RequestBody List<RoleModularPojo> role){
//		return roleManagerService.updateRoleAndModular(role);
//	}
	@RequestMapping("haveRoleAndModular")
	public String haveRoleAndModular(@RequestBody RolePojo role){
		return roleManagerService.haveRoleAndModular(role);
	}
//	@RequestMapping("removeRoleAndModular")
//	public String removeRoleAndModular(@RequestBody RoleModularPojo role){
//		return roleManagerService.removeRoleAndModular(role);
//	}
}
