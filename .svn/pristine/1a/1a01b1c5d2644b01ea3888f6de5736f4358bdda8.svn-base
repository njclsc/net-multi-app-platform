package bd.nmam.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bd.nmam.log.pojo.LogPojo;
import bd.nmam.log.service.ILogService;

@RestController
@RequestMapping("/log")
public class LogController {
	@Autowired
	@Qualifier("LogServiceimp")
	private ILogService logService;
	
	@RequestMapping("runing")
	public String runLog(@RequestBody LogPojo logPojo){
		System.out.println("8888888888888888888888888");
		logService.runLog(logPojo);
		return "";
	}
	@RequestMapping("operater")
	public String operater(@RequestBody LogPojo logPojo){
		
		return "";
	}
}
