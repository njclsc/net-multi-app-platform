package bd.nmam.manager.business.serviceimp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import bd.nmam.manager.business.dao.DeviceGroupManagerDao;
import bd.nmam.manager.business.pojo.DeviceGroupPojo;
import bd.nmam.manager.business.pojo.DeviceTreePojo;
import bd.nmam.manager.business.pojo.FindResultSetPojo;
import bd.nmam.manager.business.pojo.GroupDeviceRelationPojo;
import bd.nmam.manager.business.pojo.ResponsePojo;
import bd.nmam.manager.business.service.IDeviceGroupManagerService;

@Service("DeviceGroupManagerServiceImp")
public class DeviceGroupManagerServiceImp implements IDeviceGroupManagerService {
	@Autowired
	private DeviceGroupManagerDao deviceGroupManagerDao;
	
	private HashMap<String, DeviceTreePojo> orgDtps = new HashMap<String, DeviceTreePojo>();
	private HashMap<String, DeviceTreePojo> areaDtps = new HashMap<String, DeviceTreePojo>();
	private HashMap<String, DeviceTreePojo> devDtps = new HashMap<String, DeviceTreePojo>();
	@Override
	public String groupAdd(DeviceGroupPojo dgp) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/deviceGroup/add");
		List<DeviceGroupPojo> dgps = deviceGroupManagerDao.groupFind(dgp);
		if (dgps.size() > 0) {
			rp.setMessage("设备组已经存在");
			rp.setState("fail");
		} else {
			deviceGroupManagerDao.groupAdd(dgp);
			rp.setMessage("设备组添加成功");
			rp.setState("success");
		}
		return JSONObject.toJSONString(rp);
	}

	@Override
	public String groupRemove(DeviceGroupPojo dgp) {
		// TODO Auto-generated method stub
		deviceGroupManagerDao.groupRemove(dgp);
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/deviceGroup/remove");
		rp.setMessage("设备组删除成功");
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}

	@Override
	public String groupModify(DeviceGroupPojo dgp) {
		// TODO Auto-generated method stub
		deviceGroupManagerDao.groupModify(dgp);
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/deviceGroup/modify");
		rp.setMessage("设备组修改成功");
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}

	@Override
	public String groupFind(DeviceGroupPojo dgp) {
		// TODO Auto-generated method stub
		int rows = dgp.getRows();
		int beginRow = (dgp.getPage() - 1) * rows;
		dgp.setBeginRows(beginRow);
		List<DeviceGroupPojo> dgps = deviceGroupManagerDao.groupFind(dgp);
		int count = deviceGroupManagerDao.groupFindCount(dgp);
		FindResultSetPojo frsp = new FindResultSetPojo();
		frsp.setTotal(count);
		frsp.setTableData(dgps);
		frsp.setMessage("查询完成");
		frsp.setState("success");
		return JSONObject.toJSONString(frsp);
	}

	@Override
	public String groupDeviceRelation(DeviceGroupPojo dgp) {
		// TODO Auto-generated method stub
		deviceGroupManagerDao.groupDeviceRelation(dgp);
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/deviceGroup/relation");
		rp.setMessage("设备与设备组关联完毕");
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}

	@Override
	public String groupDeviceUnRelation(DeviceGroupPojo dgp) {
		// TODO Auto-generated method stub
		deviceGroupManagerDao.groupDeviceUnRelation(dgp);
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/deviceGroup/unRelation");
		rp.setMessage("设备与设备组去关联完毕");
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}

	@Override
	public String groupUserRelation(DeviceGroupPojo dgp) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/deviceGroup/userGroupRelation");
		if(dgp.getOperate() == 0){
			List<DeviceGroupPojo> have = deviceGroupManagerDao.groupUserRelationHave(dgp);
			List<DeviceGroupPojo> hant = deviceGroupManagerDao.groupUserRelationHavnt(dgp);
			dgp.setHave(have);
			dgp.setHavnt(hant);
			rp.setResult(dgp);
			rp.setMessage("用户与设备组关联数据");
			rp.setState("success");
		}else if(dgp.getOperate() == 1){
			deviceGroupManagerDao.groupUserUnRelation(dgp);
			deviceGroupManagerDao.groupUserRelation(dgp);
			rp.setMessage("用户与设备组关联成功");
			rp.setState("success");
		}else{
			rp.setMessage("用户与设备组关联失败");
			rp.setState("fail");
		}
		
//		
//		
//		if (dgp.getGroupIndexs().length > 0) {
//			deviceGroupManagerDao.groupUserRelation(dgp);
//			rp.setMessage("用户与设备组关联完毕");
//			rp.setState("success");
//		} else {
//			rp.setMessage("用户与设备组不能为空");
//			rp.setState("fail");
//		}
		return JSONObject.toJSONString(rp);
		
//		return "";
	}

	@Override
	public String groupUserUnRelation(DeviceGroupPojo dgp) {
		// TODO Auto-generated method stub
		deviceGroupManagerDao.groupUserUnRelation(dgp);
		;
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/deviceGroup/userGroupUnRelation");
		rp.setMessage("设备与设备组去关联完毕");
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}

	@Override
	public String loadFullDeviceTree() {
		// TODO Auto-generated method stub
		DeviceTreePojo dtp = new DeviceTreePojo();
		dtp.setOrgan_parentOrganizationCode("0000000");
		List<DeviceTreePojo> orgs = loadChildOrg(dtp);
		for(String s : deviceGroupManagerDao.findAllOrganizationOfArea()){
			DeviceTreePojo dtp1 = orgDtps.get(s);

			if(dtp1 != null){
				dtp1.setArea_parentAreaCode(null);
				loadChildArea(dtp1);
			}
		}
		for(String s : deviceGroupManagerDao.findAllAreaOfDevice()){
			DeviceTreePojo dtp1 = areaDtps.get(s);
			if(dtp1 != null){
				dtp1.setDevice_areaCode(dtp1.getArea_areaCode());
				loadChildDevice(dtp1);
			}
		}
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/deviceGroup/loadFullDeviceTree");
		rp.setMessage("全设备树加载完毕");
		rp.setState("success");
		rp.setResult(orgs);
		
		return JSONArray.toJSONString(rp);
	}
	private List<DeviceTreePojo> loadChildDevice(DeviceTreePojo dtp){
		List<DeviceTreePojo> children = deviceGroupManagerDao.findDevice(dtp);
		dtp.setChildren(children);
		for(DeviceTreePojo dtp1 : children){
			devDtps.put(dtp1.getDevice_deviceCode(), dtp1);
			dtp1.setId(dtp1.getDevice_deviceCode());
			dtp1.setLabel(dtp1.getDevice_devName());
			dtp1.setIcon("green");
		}
		return children;
	}
	private List<DeviceTreePojo> loadChildArea(DeviceTreePojo dtp){
		List<DeviceTreePojo> children = deviceGroupManagerDao.findArea(dtp);
		dtp.setChildren(children);
		for(DeviceTreePojo dtp1 : children){
			dtp1.setArea_parentAreaCode(dtp1.getArea_areaCode());
			areaDtps.put(dtp1.getArea_areaCode(), dtp1);
			loadChildArea(dtp1);
			dtp1.setId("" + dtp1.getArea_id());
			dtp1.setLabel(dtp1.getArea_areaName());
			dtp1.setIcon("green");
		}
		return children;
	}
	private List<DeviceTreePojo> loadChildOrg(DeviceTreePojo dtp) {
		List<DeviceTreePojo> children = deviceGroupManagerDao.findOrganization(dtp);
		dtp.setChildren(children);
		for(DeviceTreePojo dtp1 : children) {
			dtp1.setOrgan_parentOrganizationCode(dtp.getOrgan_organizationCode());
			orgDtps.put(dtp1.getOrgan_organizationCode(), dtp1);
			loadChildOrg(dtp1);
			dtp1.setId("" + dtp1.getOrgan_id());
			dtp1.setLabel(dtp1.getOrgan_organizationName());
			dtp1.setIcon("green");
		}
		return children;
	}

	@Override
	public String groupDeviceRelationEd(GroupDeviceRelationPojo gdrp) {
		// TODO Auto-generated method stub
		String[] devs = deviceGroupManagerDao.groupDeviceRelationEd(gdrp);
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/deviceGroup/groupDeviceRelationEd");
		rp.setMessage("以有设备加载完毕");
		rp.setState("success");
		gdrp.setDeviceIndexs(devs);
		rp.setResult(gdrp);
		return JSONObject.toJSONString(rp);
	}

	@Override
	public String groupDeviceRelation(GroupDeviceRelationPojo gdrp) {
		// TODO Auto-generated method stub
		deviceGroupManagerDao.removeGroupDeviceRelation(gdrp);
		if(gdrp.getDeviceCodes().length > 0){
			deviceGroupManagerDao.groupDeviceRelation1(gdrp);
		}
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/deviceGroup/groupDeviceRelation");
		rp.setMessage("组设备关联完毕");
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}
	
}
