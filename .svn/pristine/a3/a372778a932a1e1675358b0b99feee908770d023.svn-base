package bd.nmam.collection.business.feign.aed;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bd.nmam.collection.business.pojo.aed.LogPojo;

@FeignClient(name = "ms-log")
public interface ILogInterface {

	@RequestMapping(value = "/ms-log/log/runing", method = RequestMethod.POST)
	@ResponseBody
	public String runLog(@RequestBody LogPojo logPojo);
}
