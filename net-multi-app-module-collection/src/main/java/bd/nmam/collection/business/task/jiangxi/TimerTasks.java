package bd.nmam.collection.business.task.jiangxi;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import bd.nmam.collection.business.feign.aed.ILogInterface;
import bd.nmam.collection.business.pojo.aed.LogPojo;
import bd.nmam.collection.business.pojo.jiangxi.FaceDataPojo;
import bd.nmam.collection.business.pojo.jiangxi.FaceModePojo;
import bd.nmam.collection.util.jiangxi.ContainerUtil;

@Component
public class TimerTasks {
	@Autowired
	private DiscoveryClient disc;
	
	@Autowired
	private ILogInterface logInterface;
	@Autowired
	@Qualifier("dataSourceDruid")
	private DataSource dataSource;
	
	private String tmpBegin = ",('";
	private String tmpMidd = "', '";
	private String tmpEnd1 = ", '";
	private String tmpEnd2 = "')";
	private String insert = "insert into tb_acsdata (UPLOADTIME, PERSONNAME, CARDNUM, ACS_NUM) values";
	private String insert1 = "insert into tb_facedata (dID,result,name,fTime) values";
	private String insert2 = "insert into tb_faceMode (name) values";
	private String delete = "delete from tb_faceMode";
	
//	@Scheduled(cron = "${timer.alarmOperateRate}")
//	public void alarmOperateTask(){
//		HashMap<String, DevicePojo> dps = JiangXIContainerUtil.getDevices();
//		Iterator<Map.Entry<String, DevicePojo>> itr = dps.entrySet().iterator();
//		while(itr.hasNext()){
//			Map.Entry<String, DevicePojo> entry = itr.next();
//			String key = entry.getKey();
//			DevicePojo dp = entry.getValue();
//			ReentrantLock synAlarmLock = dp.getSynAlarmLock();
//			try{
//				synAlarmLock.tryLock(2000, TimeUnit.MILLISECONDS);
//				for(String s : dp.getAlarmNotice()){
////					String[] _ekey = s.split("_");
////					if(_ekey[2].equals("new")){
////						System.out.println("new");
////					}else if(_ekey[2].equals("2normal")){
////						System.out.println("2normal");
////					}else if(_ekey[2].equals("2alarm")){
////						System.out.println("2alarm");
////					}else if(_ekey[2].equals("repeat")){
////						System.out.println("repeat");
////					}
//				}
//			}catch(Exception e){
//				e.printStackTrace();
//			}finally{
//				if(synAlarmLock.isHeldByCurrentThread()){
//					synAlarmLock.unlock();
//				}
//			}
//		}
//	}
//	@Scheduled(cron = "${timer.acsDataOperateRate}")
	public void tt(){
		LogPojo lp = new LogPojo();
		lp.setLogMessage(new ArrayList<String>());
		for(int i = 0; i < 5; i++){
			lp.getLogMessage().add("????????????-->" + i);
		}
		ServiceInstance si = disc.getInstances("ms-log").get(0);
		System.out.println(si.getHost() + "  " + si.getPort() + "  " + si.getUri() + "  " + si.getServiceId());
		logInterface.runLog(lp);
	}
//	@Scheduled(cron = "${timer.acsDataOperateRate}")
	public void acsDataOperateTask() throws SQLException{
		List<FaceDataPojo> FaceDataBuf1 = ContainerUtil.getFaceDataBuf1();
//		List<FaceDataPojo> FaceDataBuf2 = ContainerUtil.getFaceDataBuf2();
		List<FaceModePojo> FaceModeBuf1 = ContainerUtil.getFaceModeBuf1();
//		List<FaceModePojo> FaceModeBuf2 = ContainerUtil.getFaceModeBuf2();

		List<FaceDataPojo> temp1 = null;
		List<FaceModePojo> temp2 =null;
		StringBuffer sql1 = new StringBuffer();
		StringBuffer sql2 = new StringBuffer();
		int ixFlag1 =0;
		int ixFlag2 =0;
		Connection con = dataSource.getConnection();
		
//		switch(ContainerUtil.getFaceDataFlag()){
//		case 1:
//			temp1 = FaceDataBuf2;
//			ixFlag1 += saveFaceData(temp1,sql1);
//			ContainerUtil.setFaceDataFlag(2);
//			break;
//		case 2:
//			temp1 = FaceDataBuf1;
//			ixFlag1 += saveFaceData(temp1,sql1);
//			ContainerUtil.setFaceDataFlag(1);
//			break;
//		}
//		switch(ContainerUtil.getFaceModeFlag()){
//		case 1:
//			temp2 = FaceModeBuf2;
//			ixFlag2 += saveFaceMode(temp2,sql2);
//			ContainerUtil.setFaceModeFlag(2);
//			break;
//		case 2:
//			temp2 = FaceModeBuf1;
//			ixFlag2 += saveFaceMode(temp2,sql2);
//			ContainerUtil.setFaceModeFlag(1);
//			break;
//		}
		if(ixFlag1 > 0){
			sql1.replace(0, 1, "");
			sql1.insert(0, insert1);
			Statement stat = con.createStatement();
			stat.executeUpdate(sql1.toString());
			stat.close();
			System.out.println("????????????????????????....");
			stat.close();
			
		}
		if(ixFlag2 > 0){
			sql2.replace(0, 1, "");
			sql2.insert(0, insert2);
			Statement stat = con.createStatement();
			stat.executeUpdate(delete);
			stat.close();
			System.out.println(sql2);
			stat = con.createStatement();
			stat.executeUpdate(sql2.toString());
			stat.close();
			System.out.println("??????????????????????????????....");
		}
		temp2.clear();
		temp1.clear();
		con.close();
	}
	
	
	private int saveFaceData(List<FaceDataPojo> list,StringBuffer sql1){
		try{
			int ix = 0;
			for(FaceDataPojo fdp : list){
				sql1.append(tmpBegin);
				sql1.append(fdp.getdID());
				sql1.append(tmpMidd);
				sql1.append(fdp.getResult());
				sql1.append(tmpMidd);
				sql1.append(fdp.getName());
				sql1.append(tmpMidd);
				sql1.append(fdp.getfTime());
				sql1.append(tmpEnd2);
				ix += 1;
			}
			return ix;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	private int saveFaceMode(List<FaceModePojo> list,StringBuffer sql2){
		try{
			int ix = 0;

			for(FaceModePojo fmp : list){
				sql2.append(tmpBegin);
				sql2.append(fmp.getName());
				sql2.append(tmpEnd2);
				ix += 1;
			}
			return ix;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
//	//???????????????
//	private void newAlarmSave(DevicePojo dp) throws SQLException{
//		Connection con = dataSource.getConnection();
//		String devId = dp.getDev_id();
//		int devType = dp.getDevType();
//		HashSet<String> ekey = dp.getAlarmNotice();
//		for(String s : ekey){
//			String[] _ekey = s.split("_");
//			String alarmType = _ekey[1];
//			//???????????? ????????????????????????????????????????????????
//		}
////		String sql1 = "select count(*) from tb_current_alarm where device_id = '" + 
////				devId + "' and device_type = '" + devType + "' and alarm_type = '";
////		Connection con = dataSource.getConnection();
//		
//		
//	}
}
