package bd.nmam.collection.business.mvc.aed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bd.nmam.collection.business.mvc.aed.service.IFirmwareUpgradeService;
import bd.nmam.collection.business.pojo.aed.FirmwarePojo;

@RestController
@RequestMapping(value = "/firmOperate", produces="application/json;charset=utf-8")
public class FirmwareUpgradeController {
	@Autowired
	@Qualifier("FirmwareUpgradeServiceImp")
	private IFirmwareUpgradeService fus;
	@RequestMapping("upgrade")
	public String upgrade(@RequestBody FirmwarePojo fp){
		System.out.println("固件地址" + fp.getUrl());
		fus.firmwareDownload(fp);
		return "指令接受完成。。。。";
	}
}
