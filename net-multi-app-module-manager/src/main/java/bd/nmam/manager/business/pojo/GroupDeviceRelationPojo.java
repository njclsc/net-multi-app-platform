package bd.nmam.manager.business.pojo;

public class GroupDeviceRelationPojo {

	private int groupIndex;
	private String deviceCod;
	private int deviceIndex;
	private String[] deviceIndexs;
	private String[] deviceCodes;
	
	public String[] getDeviceIndexs() {
		return deviceIndexs;
	}
	public void setDeviceIndexs(String[] deviceIndexs) {
		this.deviceIndexs = deviceIndexs;
	}
	public int getGroupIndex() {
		return groupIndex;
	}
	public void setGroupIndex(int groupIndex) {
		this.groupIndex = groupIndex;
	}
	
	public String getDeviceCod() {
		return deviceCod;
	}
	public void setDeviceCod(String deviceCod) {
		this.deviceCod = deviceCod;
	}
	public int getDeviceIndex() {
		return deviceIndex;
	}
	public String[] getDeviceCodes() {
		return deviceCodes;
	}
	public void setDeviceCodes(String[] deviceCodes) {
		this.deviceCodes = deviceCodes;
	}
	public void setDeviceIndex(int deviceIndex) {
		this.deviceIndex = deviceIndex;
	}
}
