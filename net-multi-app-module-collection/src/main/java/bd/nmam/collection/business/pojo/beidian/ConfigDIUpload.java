package bd.nmam.collection.business.pojo.beidian;

public class ConfigDIUpload {
	private String PlatformID;
	private String DeviceID;
	private String InfoCount;
	private String FrameTime;
	private String FrameType;
	private DIPojo DIConfig;
	public String getPlatformID() {
		return PlatformID;
	}
	public void setPlatformID(String platformID) {
		PlatformID = platformID;
	}
	public String getDeviceID() {
		return DeviceID;
	}
	public void setDeviceID(String deviceID) {
		DeviceID = deviceID;
	}
	public String getInfoCount() {
		return InfoCount;
	}
	public void setInfoCount(String infoCount) {
		InfoCount = infoCount;
	}
	public String getFrameTime() {
		return FrameTime;
	}
	public void setFrameTime(String frameTime) {
		FrameTime = frameTime;
	}
	public String getFrameType() {
		return FrameType;
	}
	public void setFrameType(String frameType) {
		FrameType = frameType;
	}
	public DIPojo getDIConfig() {
		return DIConfig;
	}
	public void setDIConfig(DIPojo dIConfig) {
		DIConfig = dIConfig;
	}
}
