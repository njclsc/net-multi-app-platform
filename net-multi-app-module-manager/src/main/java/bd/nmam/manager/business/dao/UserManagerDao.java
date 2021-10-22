package bd.nmam.manager.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import bd.nmam.manager.business.pojo.RoleModularPojo;
import bd.nmam.manager.business.pojo.RolePojo;
import bd.nmam.manager.business.pojo.UserPojo;
import bd.nmam.manager.business.pojo.UserRolePojo;

@Repository
public interface UserManagerDao {

	public void add(UserPojo user);
	public void remove(UserPojo user);
	public void modify(UserPojo user);
	public List<UserPojo> find(UserPojo user);
	public int findCount(UserPojo user);
	public int count(UserPojo user);
	public List<RolePojo> showUserAndRole(UserPojo user);
//	public void updateUserAndRole(List<UserRolePojo> userRole);
	public List<RolePojo> haveUserAndRole(UserPojo user);
//	public void removeUserAndRole(UserRolePojo user);
	public void modifyUserAndRole(UserRolePojo roleModular);
	public void deleteUserAndRole(UserRolePojo roleModular);
	
}
