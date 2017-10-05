package cn.ymb.crm.graduate.web.action;

import java.util.List;

import cn.ymb.crm.base.BaseAction;
import cn.ymb.crm.classesm.domain.CrmClass;
import cn.ymb.crm.graduate.domain.CrmGraduate;

public class GraduateAction extends BaseAction<CrmGraduate> {

	private static final long serialVersionUID = -573675757575790L;
	

	public String findAll(){

		List<CrmGraduate> allGraduate = this.getGraduateService().findAll();
		this.set("allGraduate", allGraduate);
		
		return "findAll";
	}
	

	public String preAddOrEdit(){

		List<CrmClass> allClass = this.getClassService().findAll();
		this.set("allClass", allClass);
		
		return "preAddOrEdit";
	}

	public String addOrEdit(){
		this.getGraduateService().addOrEdit(this.getModel());
		return "addOrEdit";
	}

}
