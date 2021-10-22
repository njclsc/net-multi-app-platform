package bd.nmam.collection.business.pojo.jiangxi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
//指令
public class DevicePojo {
	private int id;
	private String dev_id;
	private String dev_local_ip;
	private int dev_local_port;
	private String dev_target_ip;
	private int dev_target_port;
	private int devType;
	private int parentId;
	private long refreshTime = 0L;
	private HashMap<String, DevicePojo> clientDev = new HashMap<String, DevicePojo>();

	

	public int getId() {
		return id;
	}

	public HashMap<String, DevicePojo> getClientDev() {
		return clientDev;
	}

	public void setClientDev(HashMap<String, DevicePojo> clientDev) {
		this.clientDev = clientDev;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setDev_local_ip(String dev_local_ip) {
		this.dev_local_ip = dev_local_ip;
	}

	public int getDev_local_port() {
		return dev_local_port;
	}
	public void setDev_local_port(int dev_local_port) {
		this.dev_local_port = dev_local_port;
	}

	public String getDev_target_ip() {
		return dev_target_ip;
	}

	public void setDev_target_ip(String dev_target_ip) {
		this.dev_target_ip = dev_target_ip;
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

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	public long getRefreshTime() {
		return refreshTime;
	}

	public void setRefreshTime(long refreshTime) {
		this.refreshTime = refreshTime;
	}
	
	
}
