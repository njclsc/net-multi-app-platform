package bd.nmam.collection.business.pojo.beidian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DevicePojo {
	private int id;
	private String deviceId;
	private String deviceName;
	private long refreshTime;
	private String ip;
	private int port;
	private String targetIp;
	private int targetPort;
	private int alarmFlag = 1;
	private String state = "1";
	private List<AlarmPojo> alarms1 = new ArrayList<AlarmPojo>();
	private List<AlarmPojo> alarms2 = new ArrayList<AlarmPojo>();
	private int switchFlag = 1;
	private List<SwitchPojo> switch1 = new ArrayList<SwitchPojo>();
	private List<SwitchPojo> switch2 = new ArrayList<SwitchPojo>();
	private int analogFlag = 1;
	private List<AnalogPojo> analog1 = new ArrayList<AnalogPojo>();
	private List<AnalogPojo> analog2 = new ArrayList<AnalogPojo>();
//	private int paramFlag = 1;
//	private List<ParamPojo> param1 = new ArrayList<ParamPojo>();
//	private List<ParamPojo> param2 = new ArrayList<ParamPojo>();
	//告警预制
	private int alarmPreSetFlag = 1;
	private HashMap<String, AlarmPreSetPojo> alarmPreSet = new HashMap<String, AlarmPreSetPojo>();
	//离线告警状态位 0:设备在线 1：设备离线
	private String offlineAlarmState = "1";
	//设备信息
	private DeviceInfoPojo dip;
	//设备信息更新标志位
	private int deviceInfoFlag = 0;
	//设备GPS信息
	private GPSPojo gp;
	//设备GPS信息更新标志位
	private int GPSInfoFlag = 0;
	
//	public int getParamFlag() {
//		return paramFlag;
//	}
//	public void setParamFlag(int paramFlag) {
//		this.paramFlag = paramFlag;
//	}
//	public List<ParamPojo> getParam1() {
//		return param1;
//	}
//	public void setParam1(List<ParamPojo> param1) {
//		this.param1 = param1;
//	}
//	public List<ParamPojo> getParam2() {
//		return param2;
//	}
//	public void setParam2(List<ParamPojo> param2) {
//		this.param2 = param2;
//	}
	
	public DeviceInfoPojo getDip() {
		return dip;
	}
	public GPSPojo getGp() {
		return gp;
	}
	public void setGp(GPSPojo gp) {
		this.gp = gp;
	}
	public int getGPSInfoFlag() {
		return GPSInfoFlag;
	}
	public void setGPSInfoFlag(int gPSInfoFlag) {
		GPSInfoFlag = gPSInfoFlag;
	}
	public void setDip(DeviceInfoPojo dip) {
		this.dip = dip;
	}
	public int getDeviceInfoFlag() {
		return deviceInfoFlag;
	}
	public void setDeviceInfoFlag(int deviceInfoFlag) {
		this.deviceInfoFlag = deviceInfoFlag;
	}
	public String getOfflineAlarmState() {
		return offlineAlarmState;
	}
	public void setOfflineAlarmState(String offlineAlarmState) {
		this.offlineAlarmState = offlineAlarmState;
	}
	public HashMap<String, AlarmPreSetPojo> getAlarmPreSet() {
		return alarmPreSet;
	}
	public void setAlarmPreSet(HashMap<String, AlarmPreSetPojo> alarmPreSet) {
		this.alarmPreSet = alarmPreSet;
	}
	public int getSwitchFlag() {
		return switchFlag;
	}
	public void setSwitchFlag(int switchFlag) {
		this.switchFlag = switchFlag;
	}
	public List<SwitchPojo> getSwitch1() {
		return switch1;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setSwitch1(List<SwitchPojo> switch1) {
		this.switch1 = switch1;
	}
	public int getAlarmPreSetFlag() {
		return alarmPreSetFlag;
	}
	public void setAlarmPreSetFlag(int alarmPreSetFlag) {
		this.alarmPreSetFlag = alarmPreSetFlag;
	}
	public List<SwitchPojo> getSwitch2() {
		return switch2;
	}
	public void setSwitch2(List<SwitchPojo> switch2) {
		this.switch2 = switch2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public int getAnalogFlag() {
		return analogFlag;
	}
	public void setAnalogFlag(int analogFlag) {
		this.analogFlag = analogFlag;
	}
	public List<AnalogPojo> getAnalog1() {
		return analog1;
	}
	public void setAnalog1(List<AnalogPojo> analog1) {
		this.analog1 = analog1;
	}
	public List<AnalogPojo> getAnalog2() {
		return analog2;
	}
	public void setAnalog2(List<AnalogPojo> analog2) {
		this.analog2 = analog2;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public long getRefreshTime() {
		return refreshTime;
	}
	public void setRefreshTime(long refreshTime) {
		this.refreshTime = refreshTime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public int getAlarmFlag() {
		return alarmFlag;
	}
	public void setAlarmFlag(int alarmFlag) {
		this.alarmFlag = alarmFlag;
	}
	public List<AlarmPojo> getAlarms1() {
		return alarms1;
	}
	public void setAlarms1(List<AlarmPojo> alarms1) {
		this.alarms1 = alarms1;
	}
	public List<AlarmPojo> getAlarms2() {
		return alarms2;
	}
	public void setAlarms2(List<AlarmPojo> alarms2) {
		this.alarms2 = alarms2;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getTargetIp() {
		return targetIp;
	}
	public void setTargetIp(String targetIp) {
		this.targetIp = targetIp;
	}
	public int getTargetPort() {
		return targetPort;
	}
	public void setTargetPort(int targetPort) {
		this.targetPort = targetPort;
	}
}
