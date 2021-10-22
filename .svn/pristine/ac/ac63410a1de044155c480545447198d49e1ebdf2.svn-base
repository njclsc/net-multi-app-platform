package bd.nmam.demon.business.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bd.nmam.demon.business.pojo.KeepAlivePojo;

@RestController
@RequestMapping("/keepAlive")
public class KeepAliveDemonController {

	@RequestMapping("living")
	public String keepAlive(@RequestBody KeepAlivePojo kaPojo){
		System.out.println(kaPojo.getModuleName());
		System.out.println(kaPojo.getOrganizationId());
		System.out.println(kaPojo.getServerCode());
		
		return "llll";
	}
}
