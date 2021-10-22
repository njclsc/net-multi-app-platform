package bd.nmam.history.business.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bd.nmam.history.business.pojo.FirmwarePojo;
import bd.nmam.history.business.service.IFirmWareOperateService;

@RestController
@RequestMapping(value = "/firmOperate", produces="application/json;charset=utf-8")
public class FirmWareOperateController {
	@Autowired
	@Qualifier("FirmwareOperateServiceImp")
	private IFirmWareOperateService foService;
	
	@RequestMapping("firmwareUpgrade")
	public String firmwareUpgrade(@RequestBody FirmwarePojo fp, HttpServletRequest request){
		return foService.firmwareUpgrade(fp, request);
	}
	@RequestMapping("firmwareDownload")
	public String firmwareDownload(@RequestBody FirmwarePojo fp, HttpServletResponse response){
		foService.firmwareDownload(fp, response);
		return "固件下载完成";
	}
}
