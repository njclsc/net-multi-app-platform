package bd.nmam.collection.business.pojo.beidian;

public class TheTimlyAlarmPojo {
	//alarm
		private int id;
		private String deviceId;
		private String signalId;
		private int alarmStatus;
		private int switchStatus;
		private String analogValue;
		private long uploadTime;
		private int confirmState;
		private boolean changeFlag = false;
		private boolean newFlag = false;
		//switch
		private String switchSignalId;
		private int swhStatus;
		private long switchUploadTime;
		private boolean switchChangeFlag = false;
		private boolean switchNewFlag = false;
		//开关量推送标志
		private boolean switchPushFlag = false;
//		//do
//		private String doSignalId;
//		private int doStatus;
//		private long doUploadTime;
//		private boolean doChangeFlag = true;
//		private boolean doNewFlag = false;
		//analog
		private String analogSignalId;
		private String algValue;
		private long analogUploadTime;
		private boolean algChangeFlag = false;
		private boolean algNewFlag = false;

		public String getAnalogSignalId() {
			return analogSignalId;
		}
//		public boolean isDiNewFlag() {
//			return diNewFlag;
//		}
//		public void setDiNewFlag(boolean diNewFlag) {
//			this.diNewFlag = diNewFlag;
//		}
//		public boolean isDoNewFlag() {
//			return doNewFlag;
//		}
//		public void setDoNewFlag(boolean doNewFlag) {
//			this.doNewFlag = doNewFlag;
//		}
		public boolean isAlgNewFlag() {
			return algNewFlag;
		}
		
		public boolean isSwitchPushFlag() {
			return switchPushFlag;
		}
		public void setSwitchPushFlag(boolean switchPushFlag) {
			this.switchPushFlag = switchPushFlag;
		}
		public void setAlgNewFlag(boolean algNewFlag) {
			this.algNewFlag = algNewFlag;
		}
		public void setAnalogSignalId(String analogSignalId) {
			this.analogSignalId = analogSignalId;
		}
		public String getAlgValue() {
			return algValue;
		}
		public void setAlgValue(String algValue) {
			this.algValue = algValue;
		}
		public long getAnalogUploadTime() {
			return analogUploadTime;
		}
		public void setAnalogUploadTime(long analogUploadTime) {
			this.analogUploadTime = analogUploadTime;
		}
		public boolean isAlgChangeFlag() {
			return algChangeFlag;
		}
		public void setAlgChangeFlag(boolean algChangeFlag) {
			this.algChangeFlag = algChangeFlag;
		}
		public boolean isNewFlag() {
			return newFlag;
		}
	public String getSwitchSignalId() {
			return switchSignalId;
		}
		public void setSwitchSignalId(String switchSignalId) {
			this.switchSignalId = switchSignalId;
		}
		public int getSwhStatus() {
			return swhStatus;
		}
		public void setSwhStatus(int swhStatus) {
			this.swhStatus = swhStatus;
		}
		public long getSwitchUploadTime() {
			return switchUploadTime;
		}
		public void setSwitchUploadTime(long switchUploadTime) {
			this.switchUploadTime = switchUploadTime;
		}
		public boolean isSwitchChangeFlag() {
			return switchChangeFlag;
		}
		public void setSwitchChangeFlag(boolean switchChangeFlag) {
			this.switchChangeFlag = switchChangeFlag;
		}
		public boolean isSwitchNewFlag() {
			return switchNewFlag;
		}
		public void setSwitchNewFlag(boolean switchNewFlag) {
			this.switchNewFlag = switchNewFlag;
		}
		//	public String getDoSignalId() {
//			return doSignalId;
//		}
//		public void setDoSignalId(String doSignalId) {
//			this.doSignalId = doSignalId;
//		}
//		public int getDoStatus() {
//			return doStatus;
//		}
//		public void setDoStatus(int doStatus) {
//			this.doStatus = doStatus;
//		}
//		public long getDoUploadTime() {
//			return doUploadTime;
//		}
//		public void setDoUploadTime(long doUploadTime) {
//			this.doUploadTime = doUploadTime;
//		}
//		public boolean isDoChangeFlag() {
//			return doChangeFlag;
//		}
//		public void setDoChangeFlag(boolean doChangeFlag) {
//			this.doChangeFlag = doChangeFlag;
//		}
		public void setNewFlag(boolean newFlag) {
			this.newFlag = newFlag;
		}
//		public String getDiSignalId() {
//			return diSignalId;
//		}
//		public void setDiSignalId(String diSignalId) {
//			this.diSignalId = diSignalId;
//		}
//		public int getDiStatus() {
//			return diStatus;
//		}
//		public void setDiStatus(int diStatus) {
//			this.diStatus = diStatus;
//		}
//		public long getDiUploadTime() {
//			return diUploadTime;
//		}
//		public void setDiUploadTime(long diUploadTime) {
//			this.diUploadTime = diUploadTime;
//		}
//		public boolean isDiChangeFlag() {
//			return diChangeFlag;
//		}
//		public void setDiChangeFlag(boolean diChangeFlag) {
//			this.diChangeFlag = diChangeFlag;
//		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public boolean isChangeFlag() {
			return changeFlag;
		}
		public void setChangeFlag(boolean changeFlag) {
			this.changeFlag = changeFlag;
		}
		public String getDeviceId() {
			return deviceId;
		}
		public void setDeviceId(String deviceId) {
			this.deviceId = deviceId;
		}
		public String getSignalId() {
			return signalId;
		}
		public void setSignalId(String signalId) {
			this.signalId = signalId;
		}
		public int getAlarmStatus() {
			return alarmStatus;
		}
		public void setAlarmStatus(int alarmStatus) {
			this.alarmStatus = alarmStatus;
		}
		public int getSwitchStatus() {
			return switchStatus;
		}
		public void setSwitchStatus(int switchStatus) {
			this.switchStatus = switchStatus;
		}
		public String getAnalogValue() {
			return analogValue;
		}
		public void setAnalogValue(String analogValue) {
			this.analogValue = analogValue;
		}
		public long getUploadTime() {
			return uploadTime;
		}
		public void setUploadTime(long uploadTime) {
			this.uploadTime = uploadTime;
		}
		public int getConfirmState() {
			return confirmState;
		}
		public void setConfirmState(int confirmState) {
			this.confirmState = confirmState;
		}
}
