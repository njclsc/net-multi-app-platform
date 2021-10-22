package bd.nmam.collection.business.pojo.jiangxi;

public class JXTimlyAlarmPojo {
	
	private String DEVICE_ID;
	private String DEVICE_DID;
	private String DEVICE_TYPE;
	//alarm
	private String ALARM_TYPE;
	private String ALARM_STATUS;
	private String ALARM_TIME;
	private String ALARM_IMG;
	private String ALARM_LV;
	private boolean alarmChangeFlag = false;
	private boolean alarmNewFlag = false;
	//data
	private String DATA_MODEL;
	private String DATA_TYPE;
	private String DATA_VALUE;
	private String DATA_TIME;
    private boolean dataChangeFlag = false;
    private boolean dataNewFlag = false;
    
	
	public String getDATA_MODEL() {
		return DATA_MODEL;
	}
	public void setDATA_MODEL(String dATA_MODEL) {
		DATA_MODEL = dATA_MODEL;
	}
	public String getDATA_TYPE() {
		return DATA_TYPE;
	}
	public void setDATA_TYPE(String dATA_TYPE) {
		DATA_TYPE = dATA_TYPE;
	}
	public String getDATA_VALUE() {
		return DATA_VALUE;
	}
	public void setDATA_VALUE(String dATA_VALUE) {
		DATA_VALUE = dATA_VALUE;
	}
	public String getDATA_TIME() {
		return DATA_TIME;
	}
	public void setDATA_TIME(String dATA_TIME) {
		DATA_TIME = dATA_TIME;
	}
	public boolean isDataChangeFlag() {
		return dataChangeFlag;
	}
	public void setDataChangeFlag(boolean dataChangeFlag) {
		this.dataChangeFlag = dataChangeFlag;
	}
	public boolean isDataNewFlag() {
		return dataNewFlag;
	}
	public void setDataNewFlag(boolean dataNewFlag) {
		this.dataNewFlag = dataNewFlag;
	}
	public String getDEVICE_ID() {
		return DEVICE_ID;
	}
	public boolean isAlarmChangeFlag() {
		return alarmChangeFlag;
	}
	public void setAlarmChangeFlag(boolean alarmChangeFlag) {
		this.alarmChangeFlag = alarmChangeFlag;
	}
	public boolean isAlarmNewFlag() {
		return alarmNewFlag;
	}
	public void setAlarmNewFlag(boolean alarmNewFlag) {
		this.alarmNewFlag = alarmNewFlag;
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
