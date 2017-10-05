package cn.ymb.crm.department.web.action;

import java.util.List;

import cn.ymb.crm.base.BaseAction;
import cn.ymb.crm.department.domain.CrmDepartment;

public class DepartmentAction extends BaseAction<CrmDepartment> {

	private static final long serialVersionUID = 657752757574881L;


	public String findAll(){
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
		this.set("allDepartment", allDepartment);
		return "findAll";
	}
	

	public String preAddOrEdit(){
		if(this.getModel().getDepId() != null){
			CrmDepartment findDepartment = this.getDepartmentService().findById(this.getModel().getDepId());
			this.push(findDepartment);
		}
		return "preAddOrEdit";
	}

	public String addOrEdit(){
		this.getDepartmentService().addOrEdit(this.getModel());
		return "addOrEdit";
	}
	
}
