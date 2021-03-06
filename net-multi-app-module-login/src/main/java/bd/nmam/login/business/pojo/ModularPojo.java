package bd.nmam.login.business.pojo;

import java.util.List;

public class ModularPojo {
	private int id;
	private String modularName;
	private int parentId;
	private int modularLevel;
	private int modularIndex;
	private String url = "";
	private String icon = "";
	private String uiName = "";
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUiName() {
		return uiName;
	}
	public void setUiName(String uiName) {
		this.uiName = uiName;
	}
	private List<ModularPojo> children;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModularName() {
		return modularName;
	}
	public void setModularName(String modularName) {
		this.modularName = modularName;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getModularLevel() {
		return modularLevel;
	}
	public void setModularLevel(int modularLevel) {
		this.modularLevel = modularLevel;
	}
	public int getModularIndex() {
		return modularIndex;
	}
	public void setModularIndex(int modularIndex) {
		this.modularIndex = modularIndex;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<ModularPojo> getChildren() {
		return children;
	}
	public void setChildren(List<ModularPojo> children) {
		this.children = children;
	}
}
