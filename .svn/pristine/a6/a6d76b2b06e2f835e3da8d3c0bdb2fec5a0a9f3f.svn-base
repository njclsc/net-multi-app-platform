package bd.nmam.manager.business.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bd.nmam.manager.business.pojo.ModifyUserRolePojo;
import bd.nmam.manager.business.pojo.UserPojo;
import bd.nmam.manager.business.service.IUserManagerService;

@RestController
@RequestMapping(value="/user", produces="application/json;charset=utf-8")
public class UserManagerController {
	@Autowired
	@Qualifier("UserMangerServiceImp")
	private IUserManagerService userManagerService;
	@RequestMapping("add")
	public String add(@RequestBody UserPojo user, HttpServletRequest request){
		return userManagerService.add(user, request);
	}
	@RequestMapping("remove")
	public String remove(@RequestBody UserPojo user){
		return userManagerService.remove(user);
	}
	@RequestMapping("modify")
	public String modify(@RequestBody UserPojo user, HttpServletRequest request){
		return userManagerService.modify(user, request);
	}
	@RequestMapping("find")
	public String find(@RequestBody UserPojo user){
		return userManagerService.find(user);
	}
	//角色分配
	@RequestMapping("showUserAndRole")
	public String showUserAndRole(@RequestBody UserPojo user){
		return userManagerService.showUserAndRole(user);
	}
	@RequestMapping("modifyUserAndRole")
	public String modifyUserAndRole(@RequestBody ModifyUserRolePojo userRole){
		return userManagerService.modifyUserAndRole(userRole);
	}
//	@RequestMapping("updateUserAndRole")
//	public String updateUserAndRole(@RequestBody List<UserRolePojo> userRole){
//		return userManagerService.updateUserAndRole(userRole);
//	}
	@RequestMapping("haveUserAndRole")
	public String haveUserAndRole(@RequestBody UserPojo user){
		return userManagerService.haveUserAndRole(user);
	}
//	@RequestMapping("removeUserAndRole")
//	public String removeUserAndRole(@RequestBody UserRolePojo userRole){
//		return userManagerService.removeUserAndRole(userRole);
//	}
}
