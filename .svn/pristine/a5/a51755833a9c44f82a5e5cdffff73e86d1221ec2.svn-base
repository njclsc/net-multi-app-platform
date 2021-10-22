package bd.nmam.manager.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import bd.nmam.manager.business.dao.IDeviceManagerDao;
import bd.nmam.manager.business.pojo.DevicePojo;
import bd.nmam.manager.business.pojo.DeviceTypePojo;
import bd.nmam.manager.business.pojo.FindResultSetPojo;
import bd.nmam.manager.business.pojo.ResponsePojo;
import bd.nmam.manager.business.pojo.RolePojo;
import bd.nmam.manager.business.service.IDeviceManagerService;

@Service("DeviceManagerServiceImp")
public class DeviceManagerServiceImp implements IDeviceManagerService{
	@Autowired
	private IDeviceManagerDao deviceManagerDao;
	@Override
	public String loadDeviceType(DeviceTypePojo dtp) {
		// TODO Auto-generated method stub
		List<DeviceTypePojo> rps = deviceManagerDao.loadDeviceType(dtp);
		FindResultSetPojo frsp = new FindResultSetPojo();
		frsp.setTableData(rps);
		frsp.setMessage("查询完成");
		frsp.setState("success");
		return  JSONObject.toJSONString(frsp);
	}
	@Override
	public String add(DeviceTypePojo dtp) {
		// TODO Auto-generated method stub
		
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/device/remove");
		deviceManagerDao.add(dtp);
		rp.setMessage("设备类型添加成功");
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}
	@Override
	public String remove(DeviceTypePojo dtp) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/device/remove");
		deviceManagerDao.remove(dtp);
		rp.setMessage("设备类型删除成功");
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}
	@Override
	public String modify(DeviceTypePojo dtp) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/device/remove");
		deviceManagerDao.modify(dtp);
		rp.setMessage("设备类型修改成功");
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}
	@Override
	public String addHardware(DevicePojo dp) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/device/addHardware");
		deviceManagerDao.addHardware(dp);
		rp.setMessage("设备添加成功");
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}
	@Override
	public String removeHardware(DevicePojo dp) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/device/removeHardware");
		deviceManagerDao.removeHardware(dp);
		rp.setMessage("设备删除成功");
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}
	@Override
	public String modifyHardware(DevicePojo dp) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/device/modifyHardware");
		deviceManagerDao.modifyHardware(dp);
		rp.setMessage("设备修改成功");
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}
	@Override
	public String findHardware(DevicePojo dp) {
		// TODO Auto-generated method stub
		int page = dp.getPage();
		int rows = dp.getRows();
		int begin = rows * (page - 1);
		dp.setBeginRow(begin);
		int count = deviceManagerDao.findHardwareCount(dp);
		List<DevicePojo> rps = deviceManagerDao.findHardware(dp);
		FindResultSetPojo frsp = new FindResultSetPojo();
		frsp.setTotal(count);
		frsp.setTableData(rps);
		frsp.setMessage("查询完成");
		frsp.setState("success");
		return  JSONObject.toJSONString(frsp);
	}

}
