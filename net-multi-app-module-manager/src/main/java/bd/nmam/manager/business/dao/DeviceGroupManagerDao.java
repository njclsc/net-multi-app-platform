package bd.nmam.manager.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import bd.nmam.manager.business.pojo.DeviceGroupPojo;
import bd.nmam.manager.business.pojo.DeviceTreePojo;
import bd.nmam.manager.business.pojo.GroupDeviceRelationPojo;

@Repository
public interface DeviceGroupManagerDao {
	
	public void groupAdd(DeviceGroupPojo dgp);
	public void groupRemove(DeviceGroupPojo dgp);
	public void groupModify(DeviceGroupPojo dgp);
	public List<DeviceGroupPojo> groupFind(DeviceGroupPojo dgp);
	public int groupFindCount(DeviceGroupPojo dgp);
	public void groupDeviceRelation(DeviceGroupPojo dgp);
	public void groupDeviceUnRelation(DeviceGroupPojo dgp);
	public void groupUserRelation(DeviceGroupPojo dgp);
	
	public void groupUserUnRelation(DeviceGroupPojo dgp);
	public List<DeviceGroupPojo> groupUserRelationHave(DeviceGroupPojo dgp);
	public List<DeviceGroupPojo> groupUserRelationHavnt(DeviceGroupPojo dgp);
	//
	public List<DeviceTreePojo> findOrganization(DeviceTreePojo dtp);
	public List<DeviceTreePojo> findArea(DeviceTreePojo dtp);
	public List<DeviceTreePojo> findDevice(DeviceTreePojo dtp);
	public List<String> findAllOrganizationOfArea();
	public List<String> findAllAreaOfDevice();
	public String[] groupDeviceRelationEd(GroupDeviceRelationPojo gdrp);
	public void groupDeviceRelation1(GroupDeviceRelationPojo gdrp);
	public void removeGroupDeviceRelation(GroupDeviceRelationPojo gdrp);
}
