package bd.nmam.manager.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bd.nmam.manager.business.pojo.DeviceGroupPojo;
import bd.nmam.manager.business.pojo.GroupDeviceRelationPojo;
import bd.nmam.manager.business.service.IDeviceGroupManagerService;

@RestController
@RequestMapping(value = "/deviceGroup", produces="application/json;charset=utf-8")
public class DeviceGroupManagerController {
	@Autowired
	@Qualifier("DeviceGroupManagerServiceImp")
	private IDeviceGroupManagerService deviceGroupManagerService;
	
	@RequestMapping("add")
	public String groupAdd(@RequestBody DeviceGroupPojo dgp){
		return deviceGroupManagerService.groupAdd(dgp);
	}
	@RequestMapping("remove")
	public String groupRemove(@RequestBody DeviceGroupPojo dgp){
		return deviceGroupManagerService.groupRemove(dgp);
	}
	@RequestMapping("modify")
	public String groupModify(@RequestBody DeviceGroupPojo dgp){
		return deviceGroupManagerService.groupModify(dgp);
	}
	@RequestMapping("find")
	public String groupFind(@RequestBody DeviceGroupPojo dgp){
		return deviceGroupManagerService.groupFind(dgp);
	}
	@RequestMapping("relation")
	public String groupDeviceRelation(@RequestBody DeviceGroupPojo dgp){
		return deviceGroupManagerService.groupDeviceRelation(dgp);
	}
	@RequestMapping("unRelation")
	public String groupDeviceUnRelation(@RequestBody DeviceGroupPojo dgp){
		return deviceGroupManagerService.groupDeviceUnRelation(dgp);
	}
	@RequestMapping("userGroupRelation")
	public String userGroupRelation(@RequestBody DeviceGroupPojo dgp){
		return deviceGroupManagerService.groupUserRelation(dgp);
	}
	@RequestMapping("userGroupUnRelation")
	public String userGroupUnRelation(@RequestBody DeviceGroupPojo dgp){
		return deviceGroupManagerService.groupUserUnRelation(dgp);
	}
	//===================??????????????????????????????
	@RequestMapping("loadFullDeviceTree")
	public String loadFullDeviceTree(){
		return deviceGroupManagerService.loadFullDeviceTree();
	}
	@RequestMapping("groupDeviceRelationEd")
	public String groupDeviceRelationEd(@RequestBody GroupDeviceRelationPojo gdrp){
		return deviceGroupManagerService.groupDeviceRelationEd(gdrp);
	}
	@RequestMapping("groupDeviceRelation")
	public String groupDeviceRelation(@RequestBody GroupDeviceRelationPojo gdrp){
		return deviceGroupManagerService.groupDeviceRelation(gdrp);
	}
	
}
