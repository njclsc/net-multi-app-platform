package bd.nmam.login.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import bd.nmam.login.business.pojo.ModularPojo;
import bd.nmam.login.business.pojo.UserPojo;

@Repository
public interface ILoginDao {

	public UserPojo findUser(UserPojo user);
	public UserPojo loadUserInfo(UserPojo user);
	public Integer deep();
	public List<Integer> loadRole(@Param("userIndex")int userIndex);
	public List<ModularPojo> findModular(@Param("userIndex")int userIndex, @Param("level")int level, @Param("parentId")int parentId);
}
