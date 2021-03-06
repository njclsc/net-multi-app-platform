package bd.nmam.history.business.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bd.nmam.history.business.pojo.SourceMessagePojo;
import bd.nmam.history.business.service.IStaticSourceManagerService;

@RestController
@RequestMapping(value = "/staticSource", produces="application/json;charset=utf-8")
public class StaticSourceManagerController {
	@Autowired
	@Qualifier("StaticSourceManagerImp")
	private IStaticSourceManagerService sourceService;
	
	@RequestMapping("upload")
	public String uploadSource(@RequestParam("file") MultipartFile files[], HttpServletRequest request){
		return sourceService.uploadOperate(files, request);
	}
	@RequestMapping("remove")
	public String removeSource(@RequestBody SourceMessagePojo sourceMessagePojo, HttpServletRequest request){
		return sourceService.removeOperate(sourceMessagePojo, request);
	}
	
}
