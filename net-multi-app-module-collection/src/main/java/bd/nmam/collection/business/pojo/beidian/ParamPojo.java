package bd.nmam.collection.business.pojo.beidian;

public class ParamPojo {
//	private int id;
	private String deviceId;
	private String channel;
	private String channelType;
	private String param;
	private long uploadTime;
	private boolean changeFlag = false;
	private boolean newFlag = false;
	
	public long getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(long uploadTime) {
		this.uploadTime = uploadTime;
	}
	public boolean isChangeFlag() {
		return changeFlag;
	}
	public void setChangeFlag(boolean changeFlag) {
		this.changeFlag = changeFlag;
	}
	public boolean isNewFlag() {
		return newFlag;
	}
	public void setNewFlag(boolean newFlag) {
		this.newFlag = newFlag;
	}
	//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getChannelType() {
		return channelType;
	}
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
}
