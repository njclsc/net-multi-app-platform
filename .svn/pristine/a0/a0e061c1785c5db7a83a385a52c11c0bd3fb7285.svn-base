package bd.nmam.collection.business.feign.aed;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bd.nmam.collection.business.pojo.aed.FirmwarePojo;

@FeignClient(name = "history")
public interface FirmwareOperateFeign {

	@RequestMapping(value = "/history/firmOperate/firmwareDownload", method = RequestMethod.POST)
	@ResponseBody
	public byte[] firmwareDownload(@RequestBody FirmwarePojo fp);
}
