package bd.nmam.collection.business.pojo.beidian;

public class AgainPowerOnAlarmPojo {
	private String deviceId;
	private String[] switchAlarm;
	private String[] switchAlarmstate;
	private String[] switchState;
	private String[] analogAlarm;
	private String[] analogAlarmState;
	private String[] analogData;
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String[] getSwitchAlarm() {
		return switchAlarm;
	}
	public void setSwitchAlarm(String[] switchAlarm) {
		this.switchAlarm = switchAlarm;
	}
	public String[] getSwitchAlarmstate() {
		return switchAlarmstate;
	}
	public void setSwitchAlarmstate(String[] switchAlarmstate) {
		this.switchAlarmstate = switchAlarmstate;
	}
	public String[] getSwitchState() {
		return switchState;
	}
	public void setSwitchState(String[] switchState) {
		this.switchState = switchState;
	}
	public String[] getAnalogAlarm() {
		return analogAlarm;
	}
	public void setAnalogAlarm(String[] analogAlarm) {
		this.analogAlarm = analogAlarm;
	}
	public String[] getAnalogAlarmState() {
		return analogAlarmState;
	}
	public void setAnalogAlarmState(String[] analogAlarmState) {
		this.analogAlarmState = analogAlarmState;
	}
	public String[] getAnalogData() {
		return analogData;
	}
	public void setAnalogData(String[] analogData) {
		this.analogData = analogData;
	}
}
