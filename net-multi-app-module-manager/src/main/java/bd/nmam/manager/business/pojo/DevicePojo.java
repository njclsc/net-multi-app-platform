package bd.nmam.manager.business.pojo;

public class DevicePojo {
	private int id;
	private String dev_id;
	private String dev_local_ip;
	private int dev_local_port;
	private String dev_target_ip;
	private int dev_target_port;
	private int devType;
	private String devName;
	private String typeName;
	private int parentId;
	private int areaIndex;
	private int page;
	private int rows;
	private String areaName;
	private int areaLevel;
	private int beginRow;
	public int getPage() {
		return page;
	}
	public String getAreaName() {
		return areaName;
	}

	public int getAreaLevel() {
		return areaLevel;
	}
	public void setAreaLevel(int areaLevel) {
		this.areaLevel = areaLevel;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
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
	public int getBeginRow() {
		return beginRow;
	}
	public void setBeginRow(int beginRow) {
		this.beginRow = beginRow;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDev_local_port() {
		return dev_local_port;
	}
	public void setDev_local_port(int dev_local_port) {
		this.dev_local_port = dev_local_port;
	}
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getDev_target_port() {
		return dev_target_port;
	}
	public void setDev_target_port(int dev_target_port) {
		this.dev_target_port = dev_target_port;
	}
	public int getDevType() {
		return devType;
	}
	public void setDevType(int devType) {
		this.devType = devType;
	}
	public String getDev_id() {
		return dev_id;
	}
	public void setDev_id(String dev_id) {
		this.dev_id = dev_id;
	}
	public String getDev_local_ip() {
		return dev_local_ip;
	}
	public int getAreaIndex() {
		return areaIndex;
	}
	public void setAreaIndex(int areaIndex) {
		this.areaIndex = areaIndex;
	}
	public void setDev_local_ip(String dev_local_ip) {
		this.dev_local_ip = dev_local_ip;
	}
	
	public String getDev_target_ip() {
		return dev_target_ip;
	}
	public void setDev_target_ip(String dev_target_ip) {
		this.dev_target_ip = dev_target_ip;
	}

	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
}
