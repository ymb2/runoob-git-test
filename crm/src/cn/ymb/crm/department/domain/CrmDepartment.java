package cn.ymb.crm.department.domain;

import java.util.HashSet;
import java.util.Set;

import cn.ymb.crm.post.domain.CrmPost;

/**
 * 部门
 * @author Administrator
 *
 */
public class CrmDepartment implements java.io.Serializable {

	private static final long serialVersionUID = 1094837870560118027L;
	
	private String depId;
	private String depName;		//部门名称
	
	//一对多：一个部门 拥有【多个职务】
	private Set<CrmPost> crmPostSet = new HashSet<CrmPost>();

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Set<CrmPost> getCrmPostSet() {
		return crmPostSet;
	}

	public void setCrmPostSet(Set<CrmPost> crmPostSet) {
		this.crmPostSet = crmPostSet;
	}
	
	
	

}