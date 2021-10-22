package bd.nmam.manager.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bd.nmam.manager.business.pojo.DevicePojo;
import bd.nmam.manager.business.pojo.DeviceTypePojo;
import bd.nmam.manager.business.service.IDeviceManagerService;

@RestController
@RequestMapping(value = "/device", produces="application/json;charset=utf-8")
public class DeviceManagerController {

	@Autowired
	@Qualifier("DeviceManagerServiceImp")
	private IDeviceManagerService deviceManagerService;
	//设备类型
	@RequestMapping("load")
	public String loadDeviceType(@RequestBody DeviceTypePojo devicePojo){
		return deviceManagerService.loadDeviceType(devicePojo);
	}
	@RequestMapping("add")
	public String add(@RequestBody DeviceTypePojo devicePojo){
		return deviceManagerService.add(devicePojo);
	}
	@RequestMapping("remove")
	public String remove(@RequestBody DeviceTypePojo devicePojo){
		return deviceManagerService.remove(devicePojo);
	}
	@RequestMapping("modify")
	public String modify(@RequestBody DeviceTypePojo devicePojo){
		return deviceManagerService.modify(devicePojo);
	}
	//物理设备
	@RequestMapping("addHardware")
	public String addHardware(@RequestBody DevicePojo devicePojo){
		return deviceManagerService.addHardware(devicePojo);
	}
	@RequestMapping("removeHardware")
	public String removeHardware(@RequestBody DevicePojo devicePojo){
		return deviceManagerService.removeHardware(devicePojo);
	}
	@RequestMapping("modifyHardware")
	public String modifyHardware(@RequestBody DevicePojo devicePojo){
		return deviceManagerService.modifyHardware(devicePojo);
	}
	@RequestMapping("findHardware")
	public String findHardware(@RequestBody DevicePojo devicePojo){
		return deviceManagerService.findHardware(devicePojo);
	}
}
