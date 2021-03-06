package bd.nmam.collection.util.jiangxi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bd.nmam.collection.business.pojo.jiangxi.AlarmPojo;
import bd.nmam.collection.business.pojo.jiangxi.DataPojo;
import bd.nmam.collection.business.pojo.jiangxi.DevicePojo;
import bd.nmam.collection.config.Configuer;

@Configuration
public class JiangXIContainerUtil {
	@Autowired
	@Qualifier("dataSourceDruid")
	private DataSource dataSource;
	private static int organizationId;
	// -------------江西开始-------------------
	// 设备缓存
	private static HashMap<String, DevicePojo> devices = new HashMap<String, DevicePojo>();
	// 江西项目摄像头设备绑定缓存
	private static HashMap<String, String> cameraBandbuf = new HashMap<String, String>();
	// 报警级别缓存
	private static HashMap<String, String> alarmLVBuf = new HashMap<String, String>();
	//报警缓存
	private static HashMap<String, AlarmPojo> alarmBuffer = new HashMap<String, AlarmPojo>();
	// 时间格式
	public static SimpleDateFormat sdfStand = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat sdfHard = new SimpleDateFormat("yyyy-M-d H:m:s");
	public static SimpleDateFormat sdfTableName = new SimpleDateFormat("yyyy_MM");
	private static long dayMsecond = 86400000L;
	private static long hourMsecond = 3600000L;
	private static long minuteMsecond = 60000L;
	private static long msecond = 1000L;
	// -------------江西结束-------------------
	
	@Bean(name = "devices_jiangxi")
	public HashMap<String, DevicePojo> loadDevices(){
		HashMap<String, DevicePojo> devices = new HashMap<String, DevicePojo>();
		try {
			Connection con = dataSource.getConnection();
			//第一级设备加载[江西项目网络盒]
			String sql = "select * from tb_device where parentId = 0";
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				DevicePojo dp = new DevicePojo();
				dp.setId(rs.getInt("id"));
				dp.setDev_id(rs.getString("dev_id"));
				dp.setDev_local_ip(rs.getString("dev_local_ip"));
				dp.setDev_local_port(rs.getInt("dev_local_port"));
				dp.setDev_target_ip(rs.getString("dev_target_ip"));
				dp.setDev_target_port(rs.getInt("dev_target_port"));
				dp.setDevType(rs.getInt("devType"));
				dp.setParentId(rs.getInt("parentId"));
				String sql1 = "select * from tb_device where parentId != 0 and parentId = " + dp.getId();
				Statement stat1 = con.createStatement();
				ResultSet rs1 = stat1.executeQuery(sql1);
				while(rs1.next()){
					DevicePojo dp1 = new DevicePojo();
					dp1.setId(rs1.getInt("id"));
					dp1.setDev_id(rs1.getString("dev_id"));
					dp1.setDevType(rs1.getInt("devType"));
					dp1.setParentId(rs1.getInt("parentId"));
//					System.out.println(dp1.getId() + "++++++++++++++++++" + dp1.getDev_id());
					dp.getClientDev().put(dp1.getDev_id(), dp1);
//					System.out.println(dp.getClientDev().size());
				}
				rs1.close();
				stat1.close();
				devices.put(dp.getDev_id(), dp);
			}
			rs.close();
			stat.close();
			con.close();
			JiangXIContainerUtil.setDevices(devices);
			return devices;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Bean
	public Object bufferLoad() throws Exception{
//		//摄像头设备网络地址
//		String sql = "select ip_add, cd_code from tb_camera_device";
		Connection con = Configuer.getDataSource().getConnection();
//		Statement stat = con.createStatement();
//		ResultSet rs = stat.executeQuery(sql);
//		while(rs.next()){
//			JiangXIContainerUtil.getCameraBandbuf().put(rs.getString("ip_add"), rs.getString("cd_code"));
//		}
//		rs.close();
//		stat.close();
		//报警级别
		String sql1 = "select * from alarmdictionaries";
		Statement stat1 = con.createStatement();
		ResultSet rs1 = stat1.executeQuery(sql1);
		while(rs1.next()){
			String signalID = rs1.getString("signalID");
			String alarmLV = rs1.getString("alarmLV");
			//当alarmlv在数据字典中不为null且不为空，放入缓存
			if(alarmLV!=null && alarmLV!=""){
				JiangXIContainerUtil.getAlarmLVBuf().put(signalID, alarmLV);
			}
		}
		//信号映射缓存
		String sql2 = "select * from tb_property_map";
		Statement stat2 = con.createStatement();
		ResultSet rs2 = stat2.executeQuery(sql2);
		HashMap<String, String> signal = ContainerUtil.getSignal();
		while(rs2.next()){
			signal.put(rs2.getString("outPropter"), rs2.getString("innerPropter"));
		}
		//实时告警缓存
		HashMap<String, AlarmPojo> aps = ContainerUtil.getTimelyAlarmBuf();
		String sql3 = "select * from tb_current_alarm";
		Statement stat3 = con.createStatement();
		ResultSet rs3 = stat3.executeQuery(sql3);
		while(rs3.next()){
			String deviceId = rs3.getString("device_id");
			String parentId = rs3.getString("device_did");
			String deviceType = rs3.getString("device_type");
			String alarmType = rs3.getString("alarm_type");
			String alarmStatus = rs3.getString("alarm_status");
			String alarmTime = rs3.getString("alarm_time");
			String alarmImg = rs3.getString("alarm_img");
			String alarmLv = rs3.getString("alarm_lv");
			AlarmPojo ap = new AlarmPojo();
			ap.setDeviceId(deviceId);
			ap.setParentId(parentId);
			ap.setDeviceType(deviceType);
			ap.setAlarmType(alarmType);
			ap.setAlarmStatus(alarmStatus);
			ap.setAlarmTime(alarmTime);
			ap.setAlarmImg(alarmImg);
			ap.setAlarmLv(alarmLv);
			String key = deviceId + "_" + parentId + "_" + alarmType;
			aps.put(key, ap);
		}
		//实时数据缓存
		HashMap<String, DataPojo> dps = ContainerUtil.getTimelyDataBuf();
		String sql4 = "select * from tb_current_data";
		Statement stat4 = con.createStatement();
		ResultSet rs4 = stat4.executeQuery(sql4);
		while(rs4.next()){
			DataPojo dp = new DataPojo();
			String deviceId = rs4.getString("device_id");
			String parentId = rs4.getString("device_did");
			String deviceType = rs4.getString("device_type");
			String dataModel = rs4.getString("data_model");
			String dataType = rs4.getString("data_type");
			String dataValue = rs4.getString("data_value");
			String dataTime = rs4.getString("data_time");
			String alarmStatus = rs4.getString("alarm_status");
			String alarmLv = rs4.getString("alarm_lv");
			dp.setDeviceId(deviceId);
			dp.setParentId(parentId);
			dp.setDeviceType(deviceType);
			dp.setDataModel(dataModel);
			dp.setDataType(dataType);
			dp.setDataValue(dataValue);
			dp.setDataTime(dataTime);
			dp.setAlarmStatus(alarmStatus);
			dp.setAlarmLv(alarmLv);
			String key = deviceId + "_" + parentId + "_" + dataType;
			dps.put(key, dp);
		}
		
		
		rs3.close();
		stat3.close();
		rs2.close();
		stat2.close();
		rs1.close();
		stat1.close();
		con.close();
		return null;
	}
	@Bean
	public Object initInfo(@Value("${service.organizationId}")int organizationId){
		JiangXIContainerUtil.setOrganizationId(organizationId);
		return null;
	}
	public static void alarmOperate(AlarmPojo ap) throws Exception{
		Connection con = Configuer.getDataSource().getConnection();
		HashMap<String, AlarmPojo> aps = ContainerUtil.getTimelyAlarmBuf();
		String key = ap.getDeviceId() + "_" + ap.getParentId() + "_" + ap.getAlarmType();
		AlarmPojo _ap = aps.get(key);
//		if(ap.getDeviceType().equals("3") || ap.getDeviceType().equals("7")){
			//新报警
			if(_ap == null){
				String sql = "insert into tb_current_alarm (device_id, device_did, device_type, alarm_type, alarm_status, alarm_time, alarm_img, alarm_lv) values ('" + 
						ap.getDeviceId() + "', '" + ap.getParentId() + "', '" + ap.getDeviceType() + "', '" + ap.getAlarmType()  + "', '" + 
						ap.getAlarmStatus() + "', '" + ap.getAlarmTime() + "', '" + ap.getAlarmImg() + "', '" + ap.getAlarmLv() + "')";
				Statement stat = con.createStatement();
				stat.executeUpdate(sql);
				stat.close();
				aps.put(key, ap);
				
				//存入历史报警库
				String tableName = createTableAlarm(con, sdfTableName.format(new Date()));
				
				String sql1 = "insert into " + tableName + "(device_id, device_did, device_type, alarm_type, alarm_status, alarm_time, alarm_img, alarm_lv) values ('" + 
						ap.getDeviceId() + "', '" + ap.getParentId() + "', '" + ap.getDeviceType() + "', '" + ap.getAlarmType()  + "', '" + 
						ap.getAlarmStatus() + "', '" + ap.getAlarmTime() + "', '" + ap.getAlarmImg() + "', '" + ap.getAlarmLv() + "')";
				Statement stat1 = con.createStatement();
				stat1.executeUpdate(sql1);
				stat1.close();
			//报警更新
			}else{
				if(!ap.getAlarmStatus().equals(_ap.getAlarmStatus()) || !ap.getAlarmTime().equals(_ap.getAlarmTime())){
					String sql = "update tb_current_alarm set alarm_status = '" + ap.getAlarmStatus() + "', alarm_time = '" + 
							ap.getAlarmTime() + "', alarm_img = '" + ap.getAlarmImg() + "' where device_id = '" + ap.getDeviceId() + "' and device_did = '" + 
							ap.getParentId() + "' and alarm_type = '" + ap.getAlarmType() + "'";
					Statement stat = con.createStatement();
					stat.executeUpdate(sql);
					stat.close();
//					AlarmPojo __ap = _ap.clone();
					_ap.setAlarmStatus(ap.getAlarmStatus());
					_ap.setAlarmTime(ap.getAlarmTime());
					_ap.setAlarmImg(ap.getAlarmImg());
					if(ap.getAlarmStatus().equals("0")){
						long[] dt = countDateTime(JiangXIContainerUtil.getSdfStand().parse(ap.getAlarmTime()).getTime(), JiangXIContainerUtil.getSdfStand().parse(_ap.getAlarmTime()).getTime());
						_ap.setAlarmDuration(dt[0] + "天  " + dt[1] + "小时  " + dt[2] + "分钟  " + dt[3] + "秒  ");
					}
					//存入历史报警库
					String tableName = createTableAlarm(con, sdfTableName.format(new Date()));
					
					String sql1 = "insert into " + tableName + "(device_id, device_did, device_type, alarm_type, alarm_status, alarm_time, alarm_img, alarm_lv) values ('" + 
							ap.getDeviceId() + "', '" + ap.getParentId() + "', '" + ap.getDeviceType() + "', '" + ap.getAlarmType()  + "', '" + 
							ap.getAlarmStatus() + "', '" + ap.getAlarmTime() + "', '" + ap.getAlarmImg() + "', '" + ap.getAlarmLv() + "')";
					Statement stat1 = con.createStatement();
					stat1.executeUpdate(sql1);
					stat1.close();
				}
			}
//		}
		
		con.close();
	}
	public static void dataOperate(DataPojo dp) throws SQLException{
		Connection con = Configuer.getDataSource().getConnection();
		HashMap<String, DataPojo> dps = ContainerUtil.getTimelyDataBuf();
		String key = dp.getDeviceId() + "_" + dp.getParentId() + "_" + dp.getDataType();
		DataPojo _dp = dps.get(key);
//		if(dp.getDeviceType().equals("7")){
			if(_dp == null){
				String sql = "insert into tb_current_data (device_id, device_did, device_type, data_model, data_type, data_value, data_time, alarm_status, alarm_lv) values ('" +
						dp.getDeviceId() + "', '" + dp.getParentId() + "', '" + dp.getDataType() + "', '" + dp.getDataModel() + "', '" + dp.getDataType() + "', '" + dp.getDataValue() + "', '" + 
						dp.getDataTime() + "', '" + dp.getAlarmStatus() + "', '" + dp.getAlarmLv() + "')";
				Statement stat = con.createStatement();
				stat.executeUpdate(sql);
				stat.close();
				dps.put(key, dp);
				stat.close();
				
				//存入历史数据
				String tableName = createTableData(con, sdfTableName.format(new Date()));
				String sql1 = "insert into " + tableName + "(device_id, device_did, device_type, data_model, data_type, data_value, data_time, alarm_status, alarm_lv) values('" + 
						dp.getDeviceId() + "', '" + dp.getParentId() + "', '" + dp.getDataType() + "', '" + dp.getDataModel() + "', '" + dp.getDataType() + "', '" + dp.getDataValue() + "', '" + 
						dp.getDataTime() + "', '" + dp.getAlarmStatus() + "', '" + dp.getAlarmLv() + "')";
				Statement stat1 = con.createStatement();
				stat1.executeUpdate(sql1);
				stat1.close();
			}else{
				//不同就更新
				if(!_dp.getDataValue().equals(dp.getDataValue()) || !_dp.getDataTime().equals(dp.getDataTime())){
					String sql = "update tb_current_data set data_value = '" + dp.getDataValue() + "', data_time = '" + dp.getDataTime() + "' where device_id = '" + dp.getDeviceId() + "' and device_did = '" +
							dp.getParentId() + "' and data_type = '" + dp.getDataType() + "'";
					Statement stat = con.createStatement();
					stat.executeUpdate(sql);
					stat.close();
//					DataPojo __dp = _dp.clone();
					_dp.setDataValue(dp.getDataValue());
				//存入历史数据
					String tableName = createTableData(con, sdfTableName.format(new Date()));
					String sql1 = "insert into " + tableName + "(device_id, device_did, device_type, data_model, data_type, data_value, data_time, alarm_status, alarm_lv) values('" + 
							dp.getDeviceId() + "', '" + dp.getParentId() + "', '" + dp.getDataType() + "', '" + dp.getDataModel() + "', '" + dp.getDataType() + "', '" + dp.getDataValue() + "', '" + 
							dp.getDataTime() + "', '" + dp.getAlarmStatus() + "', '" + dp.getAlarmLv() + "')";
					Statement stat1 = con.createStatement();
					stat1.executeUpdate(sql1);
					stat1.close();
				}
			}
//		}
		con.close();
	}
	public static String createTableData(Connection con, String tableName) throws SQLException{
		String sql = "CREATE TABLE IF NOT EXISTS tb_data_" + tableName + "(" + 
			  "`id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键序号'," + 
			  "`device_id` varchar(30) DEFAULT NULL COMMENT '主设备ID（tb_device表deviceId字段）'," + 
			  "`device_did` varchar(30) DEFAULT NULL COMMENT '设备DID'," + 
			  "`device_type` varchar(20) DEFAULT NULL COMMENT '设备类型'," + 
			  "`data_model` varchar(20) DEFAULT NULL COMMENT '数据类别 AI，DI，DO'," + 
			  "`data_type` varchar(20) DEFAULT NULL COMMENT '数据类型'," + 
			  "`data_value` varchar(30) DEFAULT NULL COMMENT '数据值（0：开；1：关）'," + 
			  "`data_time` varchar(50) DEFAULT NULL COMMENT '数据上报时间'," + 
			  "`alarm_status` varchar(30) DEFAULT NULL COMMENT '告警状态'," + 
			  "`alarm_lv` varchar(30) DEFAULT NULL COMMENT '告警等级'," + 
			  "`ep_code` varchar(9) DEFAULT NULL COMMENT '企业编码'," + 
			  "PRIMARY KEY (`id`)" + 
			") ENGINE=MyISAM DEFAULT CHARSET=utf8";
		Statement stat = con.createStatement();
		stat.executeUpdate(sql);
		stat.close();
		return "tb_data_" + tableName;
	}
	public static String createTableAlarm(Connection con, String tableName) throws SQLException{
		String sql2 = "CREATE TABLE IF NOT EXISTS tb_alarm_" + tableName +  "(" + 
				  "`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键序号'," + 
				  "`device_id` VARCHAR(30) DEFAULT NULL COMMENT '主设备ID（tb_device表deviceId字段）'," + 
				  "`device_did` VARCHAR(30) DEFAULT NULL COMMENT '摄像头IP地址或设备DID'," + 
				  "`device_type` VARCHAR(20) DEFAULT NULL COMMENT '设备类型（摄像头：0；）'," + 
				  "`alarm_type` VARCHAR(30) DEFAULT NULL COMMENT '告警类型'," + 
				  "`alarm_status` VARCHAR(30) DEFAULT NULL COMMENT '告警状态'," + 
				  "`alarm_time` VARCHAR(30) DEFAULT NULL COMMENT '告警时间'," + 
				  "`alarm_img` VARCHAR(100) DEFAULT NULL COMMENT '摄像头设备告警时使用'," + 
				  "`alarm_lv` INT(11) DEFAULT NULL COMMENT '告警等级'," + 
				  "`ep_code` VARCHAR(9) DEFAULT NULL COMMENT '企业编码'," + 
				  "PRIMARY KEY (`id`)" + 
				") ENGINE=MYISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;";
		Statement stat = con.createStatement();
		stat.executeUpdate(sql2);
		stat.close();
		return "tb_alarm_" + tableName;
	}
	public static String createTable_FaceData(Connection con, String tableName) throws SQLException{
		String sql = "CREATE TABLE IF NOT EXISTS tb_facedata_" + tableName +  "(" +
				  "`id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键序号'," +
				  "`fTime` varchar(20) DEFAULT NULL COMMENT '时间'," +
				  "`dID` varchar(20) DEFAULT NULL COMMENT '设备ID'," +
				  "`result` varchar(20) DEFAULT NULL COMMENT '识别结果'," +
				  "`NAME` varchar(20) DEFAULT NULL COMMENT '姓名'," +
				  "PRIMARY KEY (`id`)" +
				") ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8";
		Statement stat = con.createStatement();
		stat.executeUpdate(sql);
		stat.close();
		return "tb_facedata_" + tableName;
	}
	public static long[] countDateTime(long newDateTime, long newOldTime){
		long timeDifferent = newDateTime - newOldTime;
		long day = timeDifferent / dayMsecond;
		long hour = timeDifferent % dayMsecond / hourMsecond;
		long minute = timeDifferent % hourMsecond / minuteMsecond;
		long second = timeDifferent % minuteMsecond / msecond;
		long[] dt = {day, hour, minute, second};
		return dt;
	}
//	public static void alarmOperate(AlarmPojo alarmPojo){
//		DevicePojo dp = JiangXIContainerUtil.getDevices().get(alarmPojo.getDeviceId());
//		ReentrantLock synAlarmLock = dp.getSynAlarmLock();
//		try{
//			synAlarmLock.lock();
//			HashMap<String, AlarmPojo> currAlarmBuffer = dp.get_alarms();
//			String key = alarmPojo.getDeviceType() + "_" + alarmPojo.getAlarmType();
//			if(!currAlarmBuffer.containsKey(key)){
//				currAlarmBuffer.put(key, alarmPojo);
//				dp.getAlarmNotice().add(key + "_new");
//			}else{
//				AlarmPojo _alarmPojo = currAlarmBuffer.get(key);
//				dp.getAlarms().add(_alarmPojo.clone());
//				String alarmStatus = alarmPojo.getAlarmStatus();
//				String alarmTime = alarmPojo.getAlarmTime();
//				if(!_alarmPojo.getAlarmStatus().equals(alarmStatus)){
//					_alarmPojo.setAlarmStatus(alarmStatus);
//					//告警2正常
//					if(alarmStatus.equals("0")){
//						try{
//							long timeDifferent = JiangXIContainerUtil.getSdfStand().parse(alarmTime).getTime() - JiangXIContainerUtil.getSdfStand().parse(_alarmPojo.getAlarmTime()).getTime();
//							long day = timeDifferent / dayMsecond;
//							long hour = timeDifferent % dayMsecond / hourMsecond;
//							long minute = timeDifferent % hourMsecond / minuteMsecond;
//							long second = timeDifferent % minuteMsecond / msecond;
//							_alarmPojo.setAlarmDuration(day + "天" + hour + "小时" + minute + "分钟" + second + "秒");
//							if(_alarmPojo.getDeviceType().equals("camera")){
//								_alarmPojo.setAlarmImg(alarmPojo.getAlarmImg());
//							}
//							dp.getAlarmNotice().add(key + "_2normal");
//						}catch(Exception e){
//							e.printStackTrace();
//						}
//					//正常2告警
//					}else{
//						if(_alarmPojo.getDeviceType().equals("camera")){
//							_alarmPojo.setAlarmImg(alarmPojo.getAlarmImg());
//						}
//						dp.getAlarmNotice().add(key + "_2alarm");
//					}
//					_alarmPojo.setAlarmTime(alarmTime);
//				}else{
//					if(_alarmPojo.getDeviceType().equals("camera") && !alarmStatus.equals("0")){
//						_alarmPojo.setAlarmImg(alarmPojo.getAlarmImg());
//					}
//					dp.getAlarmNotice().add(key + "_repeat");
//				}
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			synAlarmLock.unlock();
//		}
//	}
	public static HashMap<String, DevicePojo> getDevices() {
		return devices;
	}
	public static void setDevices(HashMap<String, DevicePojo> devices) {
		JiangXIContainerUtil.devices = devices;
	}
	public static HashMap<String, String> getCameraBandbuf() {
		return cameraBandbuf;
	}
	public static void setCameraBandbuf(HashMap<String, String> cameraBandbuf) {
		JiangXIContainerUtil.cameraBandbuf = cameraBandbuf;
	}
	public static HashMap<String, String> getAlarmLVBuf() {
		return alarmLVBuf;
	}
	public static void setAlarmLVBuf(HashMap<String, String> alarmLVBuf) {
		JiangXIContainerUtil.alarmLVBuf = alarmLVBuf;
	}
	public static SimpleDateFormat getSdfStand() {
		return sdfStand;
	}
	public static void setSdfStand(SimpleDateFormat sdfStand) {
		JiangXIContainerUtil.sdfStand = sdfStand;
	}
	public static HashMap<String, AlarmPojo> getAlarmBuffer() {
		return alarmBuffer;
	}
	public static void setAlarmBuffer(HashMap<String, AlarmPojo> alarmBuffer) {
		JiangXIContainerUtil.alarmBuffer = alarmBuffer;
	}
	public static int getOrganizationId() {
		return organizationId;
	}
	public static void setOrganizationId(int organizationId) {
		JiangXIContainerUtil.organizationId = organizationId;
	}
	public static SimpleDateFormat getSdfTableName() {
		return sdfTableName;
	}
	public static void setSdfTableName(SimpleDateFormat sdfTableName) {
		JiangXIContainerUtil.sdfTableName = sdfTableName;
	}
	public static SimpleDateFormat getSdfHard() {
		return sdfHard;
	}
	public static void setSdfHard(SimpleDateFormat sdfHard) {
		JiangXIContainerUtil.sdfHard = sdfHard;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// //江西设备报警缓存
	// private static HashMap<String, JXAlarmPojo> rtAlarm = new HashMap<String,
	// JXAlarmPojo>();
	// //实时告警缓存
	// private static HashMap<String, JXTimlyAlarmPojo> JXtimlyBuf = new
	// HashMap<String,JXTimlyAlarmPojo>();
	//
	//
	// //江西报警缓存操作
	// public static boolean JXAlarmOperate(JXAlarmPojo ap){
	// String key = ap.getDEVICE_ID() + "-" + ap.getDEVICE_DID() + "-" +
	// ap.getALARM_TYPE();
	// if(!rtAlarm.containsKey(key)){
	// rtAlarm.put(key, ap);
	// return true;
	// }else{
	// JXAlarmPojo _ap = rtAlarm.get(key);
	// String as = ap.getALARM_STATUS();
	// String at = ap.getALARM_TIME();
	// if(!_ap.getALARM_STATUS().equals(as)){
	// _ap.setALARM_STATUS(as);
	// //告警-->恢复
	// if(as.equals("0")){
	// try{
	// long alarmBeginTime =
	// BusinessOperateConfig.getSdfStand().parse(_ap.getALARM_TIME()).getTime();
	// long alarmEndTime =
	// BusinessOperateConfig.getSdfStand().parse(ap.getALARM_TIME()).getTime();
	// long diff = alarmEndTime - alarmBeginTime;
	// long day = diff / 86400000L;
	// long hour = diff % 86400000L / 3600000L;
	// long minutes = diff % 3600000L / 60000;
	// long seconds = diff % 60000 / 1000;
	// StringBuffer sb = new StringBuffer();
	// sb.append(day);sb.append("天 ");
	// sb.append(hour);sb.append("小时 ");
	// sb.append(minutes);sb.append("分钟 ");
	// sb.append("seconds");sb.append("秒");
	// _ap.setALARM_DURATION(sb.toString());
	// if(_ap.getALARM_IMG() != null && !_ap.getALARM_IMG().equals("")){
	// String IMG = ap.getALARM_IMG();
	// String StrIMG = _ap.getALARM_IMG() + ";" + IMG;
	// _ap.setALARM_IMG(StrIMG);
	// }
	// }catch(Exception e){
	// e.printStackTrace();
	// }
	// //正常-->告警
	// }else{
	// _ap.setALARM_IMG(ap.getALARM_IMG());
	// }
	// _ap.setALARM_TIME(at);
	// return true;
	// }else if(as.equals("0")){
	// return false;
	// }else {
	// if(_ap.getALARM_IMG() != null && !_ap.getALARM_IMG().equals("")){
	// String IMG = ap.getALARM_IMG();
	// String StrIMG = _ap.getALARM_IMG() + ";" + IMG;
	// _ap.setALARM_IMG(StrIMG);
	// }
	// return false;
	// }
	// }
	// }
	// public static HashMap<String, JXAlarmPojo> getRtAlarm() {
	// return rtAlarm;
	// }
	//
	// public static void setRtAlarm(HashMap<String, JXAlarmPojo> rtAlarm) {
	// JiangXIContainerUtil.rtAlarm = rtAlarm;
	// }
	// public static HashMap<String, JXTimlyAlarmPojo> getJXtimlyBuf() {
	// return JXtimlyBuf;
	// }
	// public static void setJXtimlyBuf(HashMap<String, JXTimlyAlarmPojo>
	// jXtimlyBuf) {
	// JXtimlyBuf = jXtimlyBuf;
	// }

}
