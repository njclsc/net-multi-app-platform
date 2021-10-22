package bd.nmam.manager.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import bd.nmam.manager.business.pojo.DevicePojo;
import bd.nmam.manager.business.pojo.DeviceTypePojo;

@Repository
public interface IDeviceManagerDao {

	public List<DeviceTypePojo> loadDeviceType(DeviceTypePojo dtp);
	public void add(DeviceTypePojo dtp);
	public void remove(DeviceTypePojo dtp);
	public void modify(DeviceTypePojo dtp);
	
	public void addHardware(DevicePojo dp);
	public void removeHardware(DevicePojo dp);
	public void modifyHardware(DevicePojo dp);
	public List<DevicePojo> findHardware(DevicePojo dp);
	public int findHardwareCount(DevicePojo dp);
}
