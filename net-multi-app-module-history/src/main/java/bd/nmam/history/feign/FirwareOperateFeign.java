package bd.nmam.history.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bd.nmam.history.business.pojo.FirmwarePojo;

@FeignClient(name = "collection")
public interface FirwareOperateFeign {
	@RequestMapping(value = "/collection/firmOperate/upgrade", method = RequestMethod.POST)
	@ResponseBody
	public String upgrade(@RequestBody FirmwarePojo fp);
}
