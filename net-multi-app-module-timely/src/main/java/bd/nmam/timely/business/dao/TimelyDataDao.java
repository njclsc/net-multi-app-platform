package bd.nmam.timely.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import bd.nmam.timely.business.pojo.TreeAreaPojo;
import bd.nmam.timely.business.pojo.UserPojo;

@Repository
public interface TimelyDataDao {

	public List<TreeAreaPojo> findDeviceNode(TreeAreaPojo tap);
	
	
	
}
