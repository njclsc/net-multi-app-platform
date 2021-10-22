package bd.nmam.manager.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import bd.nmam.manager.business.dao.AreaManagerDao;
import bd.nmam.manager.business.pojo.AreaPojo;
import bd.nmam.manager.business.pojo.FindResultSetPojo;
import bd.nmam.manager.business.pojo.ResponsePojo;
import bd.nmam.manager.business.service.IAreaManagerService;
@Service("AreaManagerServiceImp")
public class AreaManagerServiceImp implements IAreaManagerService{
	@Autowired
	private AreaManagerDao areaManagerDao;
	@Override
	public String add(AreaPojo ap) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/area/add");
		areaManagerDao.add(ap);
		rp.setMessage("区域添加成功");
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}
	@Override
	public String remove(AreaPojo ap) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/area/remove");
		areaManagerDao.remove(ap);
		rp.setMessage("区域删除成功");
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}
	@Override
	public String modify(AreaPojo ap) {
		// TODO Auto-generated method stub
		ResponsePojo rp = new ResponsePojo();
		rp.setAction("manager/area/modify");
		if(ap.getAreaLevel() > 0){
			ap.setParentLevel(ap.getAreaLevel() - 1);
		}
		areaManagerDao.modify(ap);
		rp.setMessage("区域修改成功");
		rp.setState("success");
		return JSONObject.toJSONString(rp);
	}
	@Override
	public String find(AreaPojo ap) {
		// TODO Auto-generated method stub
		int rows = ap.getRows();
		int beginRow = (ap.getPage() - 1) * rows;
		ap.setBeginRow(beginRow);
		int count = areaManagerDao.findCount(ap);
		List<AreaPojo> aps = areaManagerDao.find(ap);
		FindResultSetPojo frsp = new FindResultSetPojo();
		frsp.setTotal(count);
		frsp.setTableData(aps);
		frsp.setMessage("查询完成");
		frsp.setState("success");
		return JSONObject.toJSONString(frsp);
	}
	@Override
	public String load(AreaPojo ap) {
		// TODO Auto-generated method stub
		List<AreaPojo> aps = areaManagerDao.load(ap);
		FindResultSetPojo frsp = new FindResultSetPojo();
		frsp.setTableData(aps);
		frsp.setMessage("查询完成");
		frsp.setState("success");
		return JSONObject.toJSONString(frsp);
	}
	@Override
	public String findLevel(AreaPojo ap) {
		// TODO Auto-generated method stub
		List<AreaPojo> aps = areaManagerDao.findLevel();
		FindResultSetPojo frsp = new FindResultSetPojo();
		frsp.setTableData(aps);
		frsp.setMessage("查询完成");
		frsp.setState("success");
		return JSONObject.toJSONString(frsp);
	}

}
