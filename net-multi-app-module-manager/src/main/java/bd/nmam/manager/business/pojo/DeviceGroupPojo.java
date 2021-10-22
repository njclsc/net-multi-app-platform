package bd.nmam.manager.business.pojo;

import java.util.List;

public class DeviceGroupPojo {
	private int id;
	private String groupName;
	private String modularName;
	private int page;
	private int rows;
	private int beginRows;
	private int userIndex;
	private int[] groupIndexs;
	private int[] deviceIndexs;
	private List<DeviceGroupPojo> have;
	private List<DeviceGroupPojo> havnt;
	private int operate = 0; //0=查询，1=修改
	public int getId() {
		return id;
	}
	public int getUserIndex() {
		return userIndex;
	}
	public void setUserIndex(int userIndex) {
		this.userIndex = userIndex;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModularName() {
		return modularName;
	}
	public void setModularName(String modularName) {
		this.modularName = modularName;
	}
	public List<DeviceGroupPojo> getHave() {
		return have;
	}
	public void setHave(List<DeviceGroupPojo> have) {
		this.have = have;
	}
	public List<DeviceGroupPojo> getHavnt() {
		return havnt;
	}
	public void setHavnt(List<DeviceGroupPojo> havnt) {
		this.havnt = havnt;
	}
	public int getBeginRows() {
		return beginRows;
	}
	
	public int[] getGroupIndexs() {
		return groupIndexs;
	}
	public void setGroupIndexs(int[] groupIndexs) {
		this.groupIndexs = groupIndexs;
	}
	public void setBeginRows(int beginRows) {
		this.beginRows = beginRows;
	}
	public int[] getDeviceIndexs() {
		return deviceIndexs;
	}
	public void setDeviceIndexs(int[] deviceIndexs) {
		this.deviceIndexs = deviceIndexs;
	}
	public int getOperate() {
		return operate;
	}
	public void setOperate(int operate) {
		this.operate = operate;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
}
