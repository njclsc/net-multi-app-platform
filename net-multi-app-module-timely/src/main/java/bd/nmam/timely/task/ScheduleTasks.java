package bd.nmam.timely.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import bd.nmam.timely.business.pojo.KeepAlivePojo;
import bd.nmam.timely.feign.IKeeapAliveFeign;

@Configuration
@EnableScheduling
public class ScheduleTasks {
	@Autowired
	private IKeeapAliveFeign kaFeign;
	
//	@Scheduled(cron = "${service.keepaliveCron}")
	private void keepAliveTask(){
//		KeepAlivePojo kap = new KeepAlivePojo();
//		kap.setModuleName("timely");
//		kap.setOrganizationId(5);
//		kap.setServerCode("5-timly");
//		kap.setState("running");
//		kaFeign.stateReport(kap);
	}
}
