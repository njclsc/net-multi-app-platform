package bd.nmam.collection.business.pojo.jiangxi;

public class JXAlarmPojo {
	private String DEVICE_ID;
	private String DEVICE_DID;
	private String DEVICE_TYPE;
	private String ALARM_TYPE;
	private String ALARM_STATUS;
	private String ALARM_TIME;
	private String ALARM_IMG;
	private String ALARM_LV;
	private String ALARM_DURATION = "0秒";
	private String MANAGE_STATE = "0";
	
	public String getMANAGE_STATE() {
		return MANAGE_STATE;
	}
	public void setMANAGE_STATE(String mANAGE_STATE) {
		MANAGE_STATE = mANAGE_STATE;
	}
	public String getALARM_DURATION() {
		return ALARM_DURATION;
	}
	public void setALARM_DURATION(String aLARM_DURATION) {
		ALARM_DURATION = aLARM_DURATION;
	}
	public String getDEVICE_ID() {
		return DEVICE_ID;
	}
	public void setDEVICE_ID(String dEVICE_ID) {
		DEVICE_ID = dEVICE_ID;
	}
	public String getDEVICE_DID() {
		return DEVICE_DID;
	}
	public void setDEVICE_DID(String dEVICE_DID) {
		DEVICE_DID = dEVICE_DID;
	}
	public String getDEVICE_TYPE() {
		return DEVICE_TYPE;
	}
	public void setDEVICE_TYPE(String dEVICE_TYPE) {
		DEVICE_TYPE = dEVICE_TYPE;
	}
	public String getALARM_TYPE() {
		return ALARM_TYPE;
	}
	public void setALARM_TYPE(String aLARM_TYPE) {
		ALARM_TYPE = aLARM_TYPE;
	}
	public String getALARM_STATUS() {
		return ALARM_STATUS;
	}
	public void setALARM_STATUS(String aLARM_STATUS) {
		ALARM_STATUS = aLARM_STATUS;
	}
	public String getALARM_TIME() {
		return ALARM_TIME;
	}
	public void setALARM_TIME(String aLARM_TIME) {
		ALARM_TIME = aLARM_TIME;
	}
	public String getALARM_IMG() {
		return ALARM_IMG;
	}
	public void setALARM_IMG(String aLARM_IMG) {
		ALARM_IMG = aLARM_IMG;
	}
	public String getALARM_LV() {
		return ALARM_LV;
	}
	public void setALARM_LV(String aLARM_LV) {
		ALARM_LV = aLARM_LV;
	}
	
}
