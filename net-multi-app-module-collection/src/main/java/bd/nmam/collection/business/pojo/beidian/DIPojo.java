package bd.nmam.collection.business.pojo.beidian;

public class DIPojo {
	private String chNum;//ch-channel，xxx取值范围[001,122]
	private String chSta;//Sta-Status,EN-enable(使用),DIS-disable(未用)
	private String chAttr;//Attr-attribute,L:0-低电平告警,H:1-高电平告警,M:2-告警屏蔽
	private String dataID;//数据信号ID
	private String alarmID;//告警信号ID
	private String reserved;//保留字节
	public String getChNum() {
		return chNum;
	}
	public void setChNum(String chNum) {
		this.chNum = chNum;
	}
	public String getChSta() {
		return chSta;
	}
	public void setChSta(String chSta) {
		this.chSta = chSta;
	}
	public String getChAttr() {
		return chAttr;
	}
	public void setChAttr(String chAttr) {
		this.chAttr = chAttr;
	}
	public String getDataID() {
		return dataID;
	}
	public void setDataID(String dataID) {
		this.dataID = dataID;
	}
	public String getAlarmID() {
		return alarmID;
	}
	public void setAlarmID(String alarmID) {
		this.alarmID = alarmID;
	}
	public String getReserved() {
		return reserved;
	}
	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
}
