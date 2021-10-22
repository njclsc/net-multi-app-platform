package bd.nmam.manager.business.pojo;

import java.util.List;

public class ModifyRoleModularPojo {

	private List<RoleModularPojo> roleModualrPojo;
	private int roleIndex;
	public List<RoleModularPojo> getRoleModualrPojo() {
		return roleModualrPojo;
	}
	public void setRoleModualrPojo(List<RoleModularPojo> roleModualrPojo) {
		this.roleModualrPojo = roleModualrPojo;
	}
	public int getRoleIndex() {
		return roleIndex;
	}
	public void setRoleIndex(int roleIndex) {
		this.roleIndex = roleIndex;
	}
}
