package bd.nmam.collection.business.pojo.jiangxi;

public class AlarmPojo implements Cloneable{
	//当前状态
	private String deviceId;
	private String deviceType;
	private String alarmType;
	private String alarmStatus;
	private String alarmTime;
	private String alarmImg;
	private String alarmLv;
	private String alarmDuration = "0秒";
	private String manageState = "0";
	
	private String parentId;
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getAlarmType() {
		return alarmType;
	}
	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}
	public String getAlarmStatus() {
		return alarmStatus;
	}
	public void setAlarmStatus(String alarmStatus) {
		this.alarmStatus = alarmStatus;
	}
	public String getAlarmTime() {
		return alarmTime;
	}
	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}
	public String getAlarmImg() {
		return alarmImg;
	}
	public void setAlarmImg(String alarmImg) {
		this.alarmImg = alarmImg;
	}
	public String getAlarmLv() {
		return alarmLv;
	}
	public void setAlarmLv(String alarmLv) {
		this.alarmLv = alarmLv;
	}
	public String getAlarmDuration() {
		return alarmDuration;
	}
	public void setAlarmDuration(String alarmDuration) {
		this.alarmDuration = alarmDuration;
	}
	public String getManageState() {
		return manageState;
	}
	public void setManageState(String manageState) {
		this.manageState = manageState;
	}
	@Override
	public AlarmPojo clone(){
		// TODO Auto-generated method stub
		AlarmPojo ap = null;
		try {
			ap = (AlarmPojo)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ap;
	}
	
}
