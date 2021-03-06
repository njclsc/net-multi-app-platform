package bd.nmam.manager.business.serviceimp;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import bd.nmam.manager.business.dao.UserManagerDao;
import bd.nmam.manager.business.pojo.FindResultSetPojo;
import bd.nmam.manager.business.pojo.ModifyUserRolePojo;
import bd.nmam.manager.business.pojo.ResponsePojo;
import bd.nmam.manager.business.pojo.RoleModularPojo;
import bd.nmam.manager.business.pojo.RolePojo;
import bd.nmam.manager.business.pojo.UserPojo;
import bd.nmam.manager.business.pojo.UserRolePojo;
import bd.nmam.manager.business.service.IUserManagerService;
import bd.nmam.manager.config.AppConfigure;
import bd.nmam.manager.util.ContainerUtil;
@Service("UserMangerServiceImp")
public class UserMangerServiceImp implements IUserManagerService{
	@Autowired
	private UserManagerDao userManagerDao;
	@Override
	public String add(UserPojo user, HttpServletRequest request) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/user/add");
		if(userManagerDao.count(user) < 1 && user.getPassword() != null && user.getAgainPassword() != null
				&& user.getAgainPassword().equals(user.getPassword())){
			String[] account = AppConfigure.tokenOperate(2, request.getHeader("bd-token")).split("-");
			user.setOrganizationId(AppConfigure.getOrganizationId());
			user.setCreateDateTime(ContainerUtil.getSdfStand().format(new Date()));
			user.setCreateAccount(account[0]);
			userManagerDao.add(user);
			rp.setMessage("添加用户成功");
			rp.setState("success");
		}else{
			rp.setMessage("添加用户失败");
			rp.setState("fail");
		}
		return JSONObject.toJSONString(rp);
	}

	@Override
	public String remove(UserPojo user) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/user/remove");
		userManagerDao.remove(user);
		rp.setMessage("用户已删除");
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}

	@Override
	public String modify(UserPojo user, HttpServletRequest request) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/user/modify");
		if(userManagerDao.count(user) <= 1 && user.getPassword() != null && user.getAgainPassword() != null
				&& user.getAgainPassword().equals(user.getPassword())){
			System.out.println(user.getAccount() + "  " + user.getPassword());
			String[] account = AppConfigure.tokenOperate(2, request.getHeader("bd-token")).split("-");
			user.setOrganizationId(AppConfigure.getOrganizationId());
			user.setModifyDateTime(ContainerUtil.getSdfStand().format(new Date()));
			user.setModifyAccount(account[0]);
			userManagerDao.modify(user);
			rp.setMessage("用户修改成功");
			rp.setState("success");
		}else{
			rp.setMessage("用户修改失败");
			rp.setState("fail");
		}
		return JSONObject.toJSONString(rp);
	}

	@Override
	public String find(UserPojo user) {
		// TODO Auto-generated method stub
		int page = user.getPage();
		int rows = user.getRows();
		int begin = rows * (page - 1);
		user.setBeginRow(begin);
		int count = userManagerDao.findCount(user);
		List<UserPojo> ups = userManagerDao.find(user);
		FindResultSetPojo frsp = new FindResultSetPojo();
		frsp.setTotal(count);
		frsp.setTableData(ups);
		frsp.setMessage("查询完成");
		frsp.setState("success");
		return JSONObject.toJSONString(frsp);
	}

	@Override
	public String showUserAndRole(UserPojo user) {
		// TODO Auto-generated method stub
		List<RolePojo> ups = userManagerDao.showUserAndRole(user);
		for(RolePojo rp : ups){
			rp.setModularName(rp.getRoleName());
		}
		FindResultSetPojo frsp = new FindResultSetPojo();
		frsp.setTableData(ups);
		frsp.setMessage("查询完成");
		frsp.setState("success");
		return JSONObject.toJSONString(frsp);
	}

//	@Override
//	public String updateUserAndRole(List<UserRolePojo> userRole) {
//		// TODO Auto-generated method stub
//		for(UserRolePojo rmp : userRole){
//			rmp.setOrganizationIndex(AppConfigure.getOrganizationId());
//		}
//		userManagerDao.updateUserAndRole(userRole);
//		ResponsePojo rp = new ResponsePojo();
//		rp.setAction("manager/user/updateUserAndRole");
//		rp.setMessage("角色分配成功");
//		rp.setState("success");
//		return JSONObject.toJSONString(rp);
//	}

	@Override
	public String haveUserAndRole(UserPojo user) {
		// TODO Auto-generated method stub
		List<RolePojo> rps = userManagerDao.haveUserAndRole(user);
		for(RolePojo rp : rps){
			rp.setModularName(rp.getRoleName());
		}
		FindResultSetPojo frsp = new FindResultSetPojo();
		frsp.setTableData(rps);
		frsp.setMessage("查询完成");
		frsp.setState("success");
		return JSONObject.toJSONString(frsp);
	}

	@Override
	public String modifyUserAndRole(ModifyUserRolePojo modifyUserRole) {
		// TODO Auto-generated method stub
		List<UserRolePojo> ups = modifyUserRole.getUserModualrPojo();
		for(UserRolePojo up : ups){
			System.out.println(up.getUserIndex() + "   " + up.getRoleIndex());
		}
		UserRolePojo urp = new UserRolePojo();
		urp.setUserIndex(modifyUserRole.getUserIndex());
		userManagerDao.deleteUserAndRole(urp);
		if(ups != null && ups.size() > 0){
			for(UserRolePojo up : ups){
				System.out.println(up.getUserIndex() + "   " + up.getRoleIndex());
				if(up.getRoleIndex() > 0){
					userManagerDao.modifyUserAndRole(up);
				}
			}
		}
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/user/modifyUserAndRole");
		rp.setMessage("角色修改成功");
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}

//	@Override
//	public String removeUserAndRole(UserRolePojo userRole) {
//		// TODO Auto-generated method stub
//		userManagerDao.removeUserAndRole(userRole);
//		ResponsePojo rp = new ResponsePojo();
//		rp.setAction("manager/user/removeUserAndRole");
//		rp.setMessage("角色删除成功");
//		rp.setState("success");
//		return JSONObject.toJSONString(rp);
//	}

}
