package bd.nmam.log.serviceimp;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import bd.nmam.log.pojo.LogPojo;
import bd.nmam.log.service.ILogService;

@Service("LogServiceimp")
public class LogServiceimp implements ILogService{
	
	@Override
	public String runLog(LogPojo logPojo) {
		// TODO Auto-generated method stub
		System.out.println("9999999999999999999999999");
		Logger loger = Logger.getLogger("loginModular");
		for(String s : logPojo.getLogMessage()){
			loger.info(s);
		}
		return null;
	}

	@Override
	public String operater(LogPojo logPojo) {
		// TODO Auto-generated method stub
		return null;
	}

}
