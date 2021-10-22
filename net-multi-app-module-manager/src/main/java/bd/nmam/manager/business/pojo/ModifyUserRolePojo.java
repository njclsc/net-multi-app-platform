package bd.nmam.manager.business.pojo;

import java.util.List;

public class ModifyUserRolePojo {
	private List<UserRolePojo> userModualrPojo;
	private int userIndex;
	public List<UserRolePojo> getUserModualrPojo() {
		return userModualrPojo;
	}
	public void setUserModualrPojo(List<UserRolePojo> userModualrPojo) {
		this.userModualrPojo = userModualrPojo;
	}
	public int getUserIndex() {
		return userIndex;
	}
	public void setUserIndex(int userIndex) {
		this.userIndex = userIndex;
	}
}
