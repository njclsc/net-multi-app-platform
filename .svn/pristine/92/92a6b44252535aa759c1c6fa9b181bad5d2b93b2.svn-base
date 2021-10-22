package bd.nmam.timely.business.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bd.nmam.timely.business.service.ITimelyDataService;

@RestController
@RequestMapping(value = "/uiData", produces="application/json;charset=utf-8")
public class TimelyDataController {
	@Autowired
	@Qualifier("TimelyDataServiceImp")
	private ITimelyDataService timelyDataService;
	
	@RequestMapping("loadTree")
	public String loadDeviceTree(HttpServletRequest req){
		return timelyDataService.loadDeviceTree(req);
	}
}
