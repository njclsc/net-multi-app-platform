package bd.nmam.collection.business.pojo.beidian;

public class DeviceInfoPojo {
	private String softVer; 
	private String protocolVer; 
	private String hardwareVer; 
	private String IMEI; 
	private String SIM;
	private String LAC;
	private String CELLID;
	private String PCI;
	public String getLAC() {
		return LAC;
	}
	public void setLAC(String lAC) {
		LAC = lAC;
	}
	public String getCELLID() {
		return CELLID;
	}
	public void setCELLID(String cELLID) {
		CELLID = cELLID;
	}
	public String getPCI() {
		return PCI;
	}
	public void setPCI(String pCI) {
		PCI = pCI;
	}
	public String getSoftVer() {
		return softVer;
	}
	public void setSoftVer(String softVer) {
		this.softVer = softVer;
	}
	public String getProtocolVer() {
		return protocolVer;
	}
	public void setProtocolVer(String protocolVer) {
		this.protocolVer = protocolVer;
	}
	public String getHardwareVer() {
		return hardwareVer;
	}
	public void setHardwareVer(String hardwareVer) {
		this.hardwareVer = hardwareVer;
	}
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public String getSIM() {
		return SIM;
	}
	public void setSIM(String sIM) {
		SIM = sIM;
	}
}
