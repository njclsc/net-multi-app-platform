package bd.nmam.collection.business.pojo.beidian;

public class AIPojo {
	private String chNum;//ch-channel，xxx取值范围[001,122]
	private String chSta;//Sta-Status,EN-enable(使用),DIS-disable(未用)
	private String chAttr;//Attr-attribute,V-电压,C-电流,D-数字,O-其他(自定义)

	private String svOne;//float字符串，采样值1
	private String acOne;//float字符串，实际值1
	private String svTwo;//float字符串，采样值2
	private String acTwo;//float字符串，实际值2

	private String almUpLim;//告警上限
	private String almDnLim;//告警下限
	private String almRtn;//告警回差
	private String jumpParm;//跃变参数
	private String calParm;//修正参数

	private String dataID;//数据信号ID
	private String upLimID;//上限告警ID
	private String dnLimID;//下限告警ID
	private String faultID;//故障告警ID
	private String jumpID;//跃变告警ID

	private String upLimMask;//上限告警屏蔽
	private String dnLimMask;//下限告警屏蔽
	private String faultMask;//故障告警屏蔽
	private String jumpMask;//跃变告警屏蔽
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
	public String getSvOne() {
		return svOne;
	}
	public void setSvOne(String svOne) {
		this.svOne = svOne;
	}
	public String getAcOne() {
		return acOne;
	}
	public void setAcOne(String acOne) {
		this.acOne = acOne;
	}
	public String getSvTwo() {
		return svTwo;
	}
	public void setSvTwo(String svTwo) {
		this.svTwo = svTwo;
	}
	public String getAcTwo() {
		return acTwo;
	}
	public void setAcTwo(String acTwo) {
		this.acTwo = acTwo;
	}
	public String getAlmUpLim() {
		return almUpLim;
	}
	public void setAlmUpLim(String almUpLim) {
		this.almUpLim = almUpLim;
	}
	public String getAlmDnLim() {
		return almDnLim;
	}
	public void setAlmDnLim(String almDnLim) {
		this.almDnLim = almDnLim;
	}
	public String getAlmRtn() {
		return almRtn;
	}
	public void setAlmRtn(String almRtn) {
		this.almRtn = almRtn;
	}
	public String getJumpParm() {
		return jumpParm;
	}
	public void setJumpParm(String jumpParm) {
		this.jumpParm = jumpParm;
	}
	public String getCalParm() {
		return calParm;
	}
	public void setCalParm(String calParm) {
		this.calParm = calParm;
	}
	public String getDataID() {
		return dataID;
	}
	public void setDataID(String dataID) {
		this.dataID = dataID;
	}
	public String getUpLimID() {
		return upLimID;
	}
	public void setUpLimID(String upLimID) {
		this.upLimID = upLimID;
	}
	public String getDnLimID() {
		return dnLimID;
	}
	public void setDnLimID(String dnLimID) {
		this.dnLimID = dnLimID;
	}
	public String getFaultID() {
		return faultID;
	}
	public void setFaultID(String faultID) {
		this.faultID = faultID;
	}
	public String getJumpID() {
		return jumpID;
	}
	public void setJumpID(String jumpID) {
		this.jumpID = jumpID;
	}
	public String getUpLimMask() {
		return upLimMask;
	}
	public void setUpLimMask(String upLimMask) {
		this.upLimMask = upLimMask;
	}
	public String getDnLimMask() {
		return dnLimMask;
	}
	public void setDnLimMask(String dnLimMask) {
		this.dnLimMask = dnLimMask;
	}
	public String getFaultMask() {
		return faultMask;
	}
	public void setFaultMask(String faultMask) {
		this.faultMask = faultMask;
	}
	public String getJumpMask() {
		return jumpMask;
	}
	public void setJumpMask(String jumpMask) {
		this.jumpMask = jumpMask;
	}
}
