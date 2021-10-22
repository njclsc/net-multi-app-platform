package bd.nmam.timely.business.serviceimp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;

import bd.nmam.timely.business.dao.TimelyDataDao;
import bd.nmam.timely.business.pojo.TreeAreaPojo;
import bd.nmam.timely.business.pojo.UserPojo;
import bd.nmam.timely.business.service.ITimelyDataService;
import bd.nmam.timely.config.AppConfigure;

@Service("TimelyDataServiceImp")
public class TimelyDataServiceImp implements ITimelyDataService {
	@Autowired
	private TimelyDataDao timelyDataDao;
	private HashMap<String, TreeAreaPojo> devices = new HashMap<String, TreeAreaPojo>();
	private HashMap<String, TreeAreaPojo> areas = new HashMap<String, TreeAreaPojo>();
	@Override
	public String loadDeviceTree(HttpServletRequest req) {
		// TODO Auto-generated method stub
		String[] tokenInfo = AppConfigure.tokenOperate(3, req.getHeader("bd-token")).split("-");
		TreeAreaPojo tap = new TreeAreaPojo();
		tap.setUserId(Integer.parseInt(tokenInfo[2]));
		List<TreeAreaPojo> taps = timelyDataDao.findDeviceNode(tap);
		for(TreeAreaPojo tap1 : taps){
			System.out.println(tap1.get_dev_id() + "  " + tap1.get_devName() + "  " + tap1.get_areaCode());
		}
//		UserPojo up = new UserPojo();
////		up.setId(Integer.parseInt(tokenInfo[2]));
//		ptaps.clear();
//		List<TreeAreaPojo> taps = timelyDataDao.findTopArea(up);
//		List<TreeAreaPojo> topNode = new ArrayList<>();
//		for(TreeAreaPojo tap : taps){
//			tap.setLabel(tap.get_areaName());
//			tap.setUserId(up.getId());
//			List<TreeAreaPojo> devs = timelyDataDao.findDevice(tap);
//			for(TreeAreaPojo dev : devs){
//				dev.setLabel(dev.get_devName());
//			}
//			tap.setChildren(devs);
//			topNode.add(findParentNode(tap));
//		}
//		return JSONArray.toJSONString(topNode);
		return "";
	}
	
//	private TreeAreaPojo findParentNode(TreeAreaPojo tap){
//		TreeAreaPojo ptap = null;
//		if(tap.get_areaLevel() > 0){
//			ptap = timelyDataDao.findParentNode(tap);
//			ptap.setLabel(ptap.get_areaName());
//			if(!ptaps.containsKey(ptap.get_areaCode())){
//				ptaps.put(ptap.get_areaCode(), ptap);
//				ptap.setChildren(new ArrayList<TreeAreaPojo>());
//				ptap.getChildren().add(tap);
//			}else{
//				ptaps.get(ptap.get_areaCode()).getChildren().add(tap);
//			}
//		}
//		return ptap;
//	}
	
}
