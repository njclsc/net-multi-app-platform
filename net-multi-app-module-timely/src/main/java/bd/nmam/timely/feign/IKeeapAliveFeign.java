package bd.nmam.timely.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bd.nmam.timely.business.pojo.KeepAlivePojo;

@FeignClient(name = "demon")
public interface IKeeapAliveFeign {

//	@RequestMapping(method = RequestMethod.POST, value = "/demon/keepAlive/living")
//	public String stateReport(@RequestBody KeepAlivePojo kap);
}
