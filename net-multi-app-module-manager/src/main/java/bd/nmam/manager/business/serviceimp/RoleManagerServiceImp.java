package bd.nmam.manager.business.serviceimp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import bd.nmam.manager.business.dao.RoleManagerDao;
import bd.nmam.manager.business.pojo.FindResultSetPojo;
import bd.nmam.manager.business.pojo.ModifyRoleModularPojo;
import bd.nmam.manager.business.pojo.ModularPojo;
import bd.nmam.manager.business.pojo.ResponsePojo;
import bd.nmam.manager.business.pojo.RoleModularPojo;
import bd.nmam.manager.business.pojo.RolePojo;
import bd.nmam.manager.business.service.IRoleManagerService;
import bd.nmam.manager.config.AppConfigure;
import bd.nmam.manager.util.ContainerUtil;

@Service("RoleManagerServiceImp")
public class RoleManagerServiceImp implements IRoleManagerService{
	@Autowired
	private RoleManagerDao roleManagerDao;
	
	@Override
	public String add(RolePojo role, HttpServletRequest request) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/role/add");
		if(roleManagerDao.count(role) < 1){
			String[] account = AppConfigure.tokenOperate(2, request.getHeader("bd-token")).split("-");
			role.setOrganizationIndex(AppConfigure.getOrganizationId());
			role.setCreateDateTime(ContainerUtil.getSdfStand().format(new Date()));
			role.setCreateAccount(account[0]);
			roleManagerDao.add(role);
			rp.setMessage("添加角色成功");
			rp.setState("success");
		}else{
			rp.setMessage("添加角色失败");
			rp.setState("fail");
		}
		return JSONObject.toJSONString(rp);
	}

	@Override
	public String remove(RolePojo role) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/role/remove");
		roleManagerDao.remove(role);
		rp.setMessage("删除角色成功");
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}

	@Override
	public String modify(RolePojo role, HttpServletRequest request) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/role/modify");
		if(roleManagerDao.count(role) < 1){
			String[] account = AppConfigure.tokenOperate(2, request.getHeader("bd-token")).split("-");
			role.setOrganizationIndex(AppConfigure.getOrganizationId());
			role.setModifyDateTime(ContainerUtil.getSdfStand().format(new Date()));
			role.setModifyAccount(account[0]);
			roleManagerDao.modify(role);
			rp.setMessage("修改角色成功");
			rp.setState("success");
			
		}else{
			rp.setMessage("修改角色失败");
			rp.setState("fail");
		}
		return JSONObject.toJSONString(rp);
	}

	@Override
	public String find(RolePojo role) {
		// TODO Auto-generated method stub
		int page = role.getPage();
		int rows = role.getRows();
		int begin = rows * (page - 1);
		role.setBeginRow(begin);
		role.setRoleName(role.getRoleName());
		int count = roleManagerDao.findCount(role);
		List<RolePojo> rps = roleManagerDao.find(role);
		FindResultSetPojo frsp = new FindResultSetPojo();
		frsp.setTotal(count);
		frsp.setTableData(rps);
		frsp.setMessage("查询完成");
		frsp.setState("success");
		return  JSONObject.toJSONString(frsp);
	}

	
	
	//小菜单
	@Override
	public String showRoleAndModular_1(RolePojo role) {
		// TODO Auto-generated method stub
		List<ModularPojo> mps = roleManagerDao.showRoleAndModular_1(role);
		FindResultSetPojo frsp = new FindResultSetPojo();
		frsp.setTableData(mps);
		frsp.setMessage("查询完成");
		frsp.setState("success");
		return JSONObject.toJSONString(frsp);
	}
	@Override
	public String haveRoleAndModular_1(RolePojo role) {
		// TODO Auto-generated method stub
		List<ModularPojo> mps = roleManagerDao.haveRoleAndModular_1(role);
		FindResultSetPojo frsp = new FindResultSetPojo();
		frsp.setTableData(mps);
		frsp.setMessage("查询完成");
		frsp.setState("success");
		return JSONObject.toJSONString(frsp);
	}
	@Override
	public String modifyRoleAndModular_1(ModifyRoleModularPojo modifyRoleModular) {
		// TODO Auto-generated method stub
		List<RoleModularPojo> rmps = modifyRoleModular.getRoleModualrPojo();
		RoleModularPojo rmp = new RoleModularPojo();
		rmp.setRoleIndex(modifyRoleModular.getRoleIndex());
		roleManagerDao.deleteRoleAndModular_1(rmp);
		List<RoleModularPojo> rmps1 = new ArrayList<RoleModularPojo>();
		if(rmps != null && rmps.size() > 0){
			for(RoleModularPojo rmp1 : rmps){
				findParent(rmps1, rmp1);
			}
		}
		HashMap<String, RoleModularPojo> rmps2 = new HashMap<String, RoleModularPojo>();
		for(RoleModularPojo rmp2 : rmps1){
			System.out.println(rmp2.getRoleIndex() + "  " + rmp2.getModularIndex() + "  " + rmp2.getOrganizationIndex());
			String key = rmp2.getRoleIndex() + "_" + rmp2.getModularIndex() + "_" + AppConfigure.getOrganizationId();
			if(!rmps2.containsKey(key)){
				RoleModularPojo rmp3 = new RoleModularPojo();
				rmp3.setRoleIndex(rmp2.getRoleIndex());
				rmp3.setModularIndex(rmp2.getModularIndex());
				rmp3.setOrganizationIndex(AppConfigure.getOrganizationId());
				rmps2.put(key, rmp3);
			}
		}
		Iterator<Map.Entry<String, RoleModularPojo>> itr = rmps2.entrySet().iterator();
		while(itr.hasNext()){
			roleManagerDao.modifyRoleAndModular_1(itr.next().getValue());
		}
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/role/modifyRoleAndModular");
		rp.setMessage("权限修改成功");
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}
	private List<RoleModularPojo> findParent(List<RoleModularPojo> rmps, RoleModularPojo rmp){
		ModularPojo mp = roleManagerDao.findModular(rmp.getModularIndex());
		System.out.println("--->>>" + mp);
		rmps.add(rmp);
		if(mp != null && !mp.getModularLevel().equals("0")){
			RoleModularPojo rmp1 = new RoleModularPojo();
			rmp1.setRoleIndex(rmp.getRoleIndex());
			rmp1.setOrganizationIndex(rmp.getOrganizationIndex());
			rmp1.setModularIndex(Integer.parseInt(mp.getParentId()));
			findParent(rmps, rmp1);
		}
		return rmps;
	}
	//大菜单
	@Override
	public String showRoleAndModular(RolePojo role) {
		// TODO Auto-generated method stub
		List<ModularPojo> mps = roleManagerDao.showRoleAndModular(role);
		FindResultSetPojo frsp = new FindResultSetPojo();
		frsp.setTableData(mps);
		frsp.setMessage("查询完成");
		frsp.setState("success");
		return JSONObject.toJSONString(frsp);
	}

	@Override
	public String modifyRoleAndModular(ModifyRoleModularPojo modifyRoleModular) {
		// TODO Auto-generated method stub
		List<RoleModularPojo> rmps = modifyRoleModular.getRoleModualrPojo();
		RoleModularPojo rmp = new RoleModularPojo();
		rmp.setRoleIndex(modifyRoleModular.getRoleIndex());
		roleManagerDao.deleteRoleAndModular(rmp);
		if(rmps != null && rmps.size() > 0){
			for(RoleModularPojo _rmp : rmps){
				_rmp.setOrganizationIndex(AppConfigure.getOrganizationId());
				roleManagerDao.modifyRoleAndModular(_rmp);
			}
		}
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/role/modifyRoleAndModular");
		rp.setMessage("权限修改成功");
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}

//	@Override
//	public String updateRoleAndModular(List<RoleModularPojo> role) {
//		// TODO Auto-generated method stub
//		for(RoleModularPojo rmp : role){
//			rmp.setOrganizationIndex(AppConfigure.getOrganizationId());
//		}
//		roleManagerDao.updateRoleAndModular(role);
//		ResponsePojo rp = new ResponsePojo();
//		rp.setAction("manager/role/updateRoleAndModular");
//		rp.setMessage("权限分配成功");
//		rp.setState("success");
//		return JSONObject.toJSONString(rp);
//	}
//
	@Override
	public String haveRoleAndModular(RolePojo role) {
		// TODO Auto-generated method stub
		List<ModularPojo> mps = roleManagerDao.haveRoleAndModular(role);
		FindResultSetPojo frsp = new FindResultSetPojo();
		frsp.setTableData(mps);
		frsp.setMessage("查询完成");
		frsp.setState("success");
		return JSONObject.toJSONString(frsp);
	}
//
//	@Override
//	public String removeRoleAndModular(RoleModularPojo role) {
//		// TODO Auto-generated method stub
//		roleManagerDao.removeRoleAndModular(role);
//		ResponsePojo rp = new ResponsePojo();
//		rp.setAction("manager/role/removeRoleAndModular");
//		rp.setMessage("权限删除成功");
//		rp.setState("success");
//		return JSONObject.toJSONString(rp);
//	}

	
	

	

	
}
