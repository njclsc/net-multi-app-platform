package bd.nmam.login.business.pojo;

import java.util.ArrayList;
import java.util.List;

public class UIIndexMenuPojo {
	private String path;
	private String name;
	private MetaPojo meta;
	private List<UIIndexMenuPojo> children = new ArrayList<>();
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MetaPojo getMeta() {
		return meta;
	}
	public void setMeta(MetaPojo meta) {
		this.meta = meta;
	}
	public List<UIIndexMenuPojo> getChildren() {
		return children;
	}
	public void setChildren(List<UIIndexMenuPojo> children) {
		this.children = children;
	}
}
