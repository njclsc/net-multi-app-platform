package bd.nmam.history.business.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import bd.nmam.history.business.pojo.AreaPojo;
import bd.nmam.history.business.pojo.FirmwarePojo;

@Repository
public interface StaticSourceDao {

	public void modifyDB(AreaPojo ap);
	public AreaPojo findAreaById(@Param("id") int id);
	public void firmwareOperate(FirmwarePojo fp);
}
