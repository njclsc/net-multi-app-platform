package bd.nmam.collection.business.pojo.beidian;

import java.util.ArrayList;
import java.util.List;

public class DeviceCommandPojo {
	private String deviceId;
	private String address;
	private String port;
	//private CopyOnWriteArrayList<String> CMD = new CopyOnWriteArrayList<String>();
//	private String CMD;
	//缓存指令下发标志位 0:不下发 1:下发 
	private int issueFlag = 0;
	//下发更新
	private List<String> _CMD = new ArrayList<String>();
	private List<String> _INDEX = new ArrayList<String>();
	private int baseSEQ = 0;
//	public CopyOnWriteArrayList<String> getCMD() {
//		return CMD;
//	}
//	public void setCMD(CopyOnWriteArrayList<String> cMD) {
//		CMD = cMD;
//	}
	
	public int getIssueFlag() {
		return issueFlag;
	}
	
	public List<String> get_INDEX() {
		return _INDEX;
	}

	public void set_INDEX(List<String> _INDEX) {
		this._INDEX = _INDEX;
	}

	public List<String> get_CMD() {
		return _CMD;
	}
	public void set_CMD(List<String> _CMD) {
		this._CMD = _CMD;
	}
	public void setIssueFlag(int issueFlag) {
		this.issueFlag = issueFlag;
	}
	private CommandPojo cp;
//	public String getCMD() {
//		return CMD;
//	}
//	public void setCMD(String cMD) {
//		CMD = cMD;
//	}
	public CommandPojo getCp() {
		return cp;
	}
	public int getBaseSEQ() {
		return baseSEQ;
	}

	public void setBaseSEQ(int baseSEQ) {
		this.baseSEQ = baseSEQ;
	}

	public void setCp(CommandPojo cp) {
		this.cp = cp;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
}
