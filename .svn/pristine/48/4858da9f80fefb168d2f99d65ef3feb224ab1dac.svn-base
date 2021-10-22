package bd.nmam.manager.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bd.nmam.manager.business.pojo.AreaPojo;
import bd.nmam.manager.business.service.IAreaManagerService;

@RestController
@RequestMapping(value = "/area", produces="application/json;charset=utf-8")
public class AreaManagerController {

	@Autowired
	@Qualifier("AreaManagerServiceImp")
	private IAreaManagerService areaManagerService;
	
	@RequestMapping("add")
	public String add(@RequestBody AreaPojo ap){
		return areaManagerService.add(ap);
	}
	@RequestMapping("remove")
	public String remove(@RequestBody AreaPojo ap){
		return areaManagerService.remove(ap);
	}
	@RequestMapping("modify")
	public String modify(@RequestBody AreaPojo ap){
		return areaManagerService.modify(ap);
	}
	@RequestMapping("find")
	public String find(@RequestBody AreaPojo ap){
		return areaManagerService.find(ap);
	}
	@RequestMapping("load")
	public String load(@RequestBody AreaPojo ap){
		return areaManagerService.load(ap);
	}
	@RequestMapping("findLevel")
	public String findLevel(@RequestBody AreaPojo ap){
		return areaManagerService.findLevel(ap);
	}
}
