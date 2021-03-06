package bd.nmam.manager.business.pojo;

import java.util.List;

public class DeviceTreePojo {
	private String id;
	private String label;
	private String icon;
	private List<DeviceTreePojo> children;
	/*
	 * 组织，区域，设备【根据类型不同，设置以上三项数据】
	 * nodeType = organization; 那么 id,label是 组织表数据，area；区域表数据，
	 * 
	 * */
	private String nodeType;
	//组织
	private int organ_id;
	private String organ_organizationName;
	private String organ_organizationCode;
	private int organ_organizationLevel;
	private String organ_parentOrganizationCode;
	private int organ_districtIndex;
	//区域
	private int area_id;
	private String area_areaName;
	private int area_districtId;
	private int area_areaLevel;
	private String area_areaCode;
	private String area_address;
	private String area_parentAreaCode;
	//设备
	private int device_id;
	private String device_dev_id;
	private int device_devType;
	private String device_devName;
	private String device_areaCode;
	private String device_deviceCode;
	private String device_parentDeviceCode;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDevice_deviceCode() {
		return device_deviceCode;
	}
	public void setDevice_deviceCode(String device_deviceCode) {
		this.device_deviceCode = device_deviceCode;
	}
	public String getDevice_parentDeviceCode() {
		return device_parentDeviceCode;
	}
	public void setDevice_parentDeviceCode(String device_parentDeviceCode) {
		this.device_parentDeviceCode = device_parentDeviceCode;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public List<DeviceTreePojo> getChildren() {
		return children;
	}
	public void setChildren(List<DeviceTreePojo> children) {
		this.children = children;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public int getOrgan_id() {
		return organ_id;
	}
	public void setOrgan_id(int organ_id) {
		this.organ_id = organ_id;
	}
	public String getOrgan_organizationName() {
		return organ_organizationName;
	}
	public void setOrgan_organizationName(String organ_organizationName) {
		this.organ_organizationName = organ_organizationName;
	}
	public String getOrgan_organizationCode() {
		return organ_organizationCode;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public void setOrgan_organizationCode(String organ_organizationCode) {
		this.organ_organizationCode = organ_organizationCode;
	}
	public int getOrgan_organizationLevel() {
		return organ_organizationLevel;
	}
	public void setOrgan_organizationLevel(int organ_organizationLevel) {
		this.organ_organizationLevel = organ_organizationLevel;
	}
	public String getOrgan_parentOrganizationCode() {
		return organ_parentOrganizationCode;
	}
	public void setOrgan_parentOrganizationCode(String organ_parentOrganizationCode) {
		this.organ_parentOrganizationCode = organ_parentOrganizationCode;
	}
	public int getOrgan_districtIndex() {
		return organ_districtIndex;
	}
	public void setOrgan_districtIndex(int organ_districtIndex) {
		this.organ_districtIndex = organ_districtIndex;
	}
	public int getArea_id() {
		return area_id;
	}
	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}
	public String getArea_areaName() {
		return area_areaName;
	}
	public void setArea_areaName(String area_areaName) {
		this.area_areaName = area_areaName;
	}
	public int getArea_districtId() {
		return area_districtId;
	}
	public void setArea_districtId(int area_districtId) {
		this.area_districtId = area_districtId;
	}
	public int getArea_areaLevel() {
		return area_areaLevel;
	}
	public void setArea_areaLevel(int area_areaLevel) {
		this.area_areaLevel = area_areaLevel;
	}
	
	public String getArea_areaCode() {
		return area_areaCode;
	}
	public void setArea_areaCode(String area_areaCode) {
		this.area_areaCode = area_areaCode;
	}
	public String getArea_address() {
		return area_address;
	}
	public void setArea_address(String area_address) {
		this.area_address = area_address;
	}
	public String getArea_parentAreaCode() {
		return area_parentAreaCode;
	}
	public void setArea_parentAreaCode(String area_parentAreaCode) {
		this.area_parentAreaCode = area_parentAreaCode;
	}
	public int getDevice_id() {
		return device_id;
	}
	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}
	public String getDevice_dev_id() {
		return device_dev_id;
	}
	public void setDevice_dev_id(String device_dev_id) {
		this.device_dev_id = device_dev_id;
	}
	public int getDevice_devType() {
		return device_devType;
	}
	public void setDevice_devType(int device_devType) {
		this.device_devType = device_devType;
	}
	public String getDevice_devName() {
		return device_devName;
	}
	public void setDevice_devName(String device_devName) {
		this.device_devName = device_devName;
	}
	public String getDevice_areaCode() {
		return device_areaCode;
	}
	public void setDevice_areaCode(String device_areaCode) {
		this.device_areaCode = device_areaCode;
	}
}
