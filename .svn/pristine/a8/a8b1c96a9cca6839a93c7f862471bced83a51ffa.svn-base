package bd.nmam.manager.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import bd.nmam.manager.business.pojo.ModularPojo;
import bd.nmam.manager.business.pojo.RoleModularPojo;
import bd.nmam.manager.business.pojo.RolePojo;


@Repository
public interface RoleManagerDao {
	public void add(RolePojo Role);
	public void remove(RolePojo Role);
	public void modify(RolePojo Role);
	public List<RolePojo> find(RolePojo Role);
	public int findCount(RolePojo Role);
	public int count(RolePojo Role);
	//小菜单管理
	public List<ModularPojo> showRoleAndModular_1(RolePojo role);
	public List<ModularPojo> haveRoleAndModular_1(RolePojo role);
	public void modifyRoleAndModular_1(RoleModularPojo roleModular);
	public void deleteRoleAndModular_1(RoleModularPojo roleModular);
	public ModularPojo findModular(@Param("modularIndex") int modularIndex);
	//大菜单管理
	public List<ModularPojo> showRoleAndModular(RolePojo role);
	public void modifyRoleAndModular(RoleModularPojo roleModular);
	public void deleteRoleAndModular(RoleModularPojo roleModular);
//	public void updateRoleAndModular(List<RoleModularPojo> role);
	public List<ModularPojo> haveRoleAndModular(RolePojo role);
//	public void removeRoleAndModular(RoleModularPojo role);
}
