package cn.ymb.crm.refer.web.action;

import java.util.Date;
import java.util.List;

import cn.ymb.crm.constant.CommonConstant;
import cn.ymb.crm.base.BaseAction;
import cn.ymb.crm.coursetype.domain.CrmCourseType;
import cn.ymb.crm.refer.domain.CrmRefer;
import cn.ymb.crm.staff.domain.CrmStaff;

public class ReferAction extends BaseAction<CrmRefer> {
	private static final long serialVersionUID = -527375275757575755L;
	
	public String findAll(){
		List<CrmRefer> allRefer = this.getReferService().findAll(this.getModel());
		this.set("allRefer", allRefer);
		return "findAll";
	}
	

	public String preAddOrEdit(){
		
		List<CrmCourseType> allCourseType = this.getCourseTypeService().findAll();
		this.put("allCourseType", allCourseType);
		
		if(this.getModel().getReferId() != null){
			CrmRefer findRefer = this.getReferService().findById(this.getModel().getReferId());
			this.push(findRefer);
		}
		return "preAddOrEdit";
	}
	

	public String addOrEdit(){	
		if(this.getModel().getReferId() == null){
			this.getModel().setCreateDate(new Date());
			CrmStaff crmStaff = (CrmStaff) this.sessionGet("loginUser");
			this.getModel().setCrmStaff(crmStaff);
			this.getModel().setStatus(CommonConstant.REFER_STATUS_DEFAULT);
		}
		this.getReferService().addOrEdit(this.getModel());
		return "addOrEdit";
	}
	

	public String findById(){
		CrmRefer findRefer = this.getReferService().findById(this.getModel().getReferId());
		this.push(findRefer);
		return "findById";
	}

	public String preAdd(){
		
		List<CrmCourseType> allCourseType = this.getCourseTypeService().findAll();
		this.put("allCourseType", allCourseType);
		
		return "preAdd";
	}
	
	public String add(){	
		this.getModel().setCreateDate(new Date());
		CrmStaff crmStaff = (CrmStaff) this.sessionGet("loginUser");
		this.getModel().setCrmStaff(crmStaff);
		this.getModel().setStatus(CommonConstant.REFER_STATUS_DEFAULT);
		
		this.getReferService().addRefer(this.getModel());
		return "add";
	}

	public String preEdit(){
		
		List<CrmCourseType> allCourseType = this.getCourseTypeService().findAll();
		this.put("allCourseType", allCourseType);
		
		CrmRefer findRefer = this.getReferService().findById(this.getModel().getReferId());
		this.push(findRefer);
		
		return "preEdit";
	}
	

	public String edit(){	
		this.getReferService().updateRefer(this.getModel());
		return "edit";
	}
	
	
	public String preAddStudent(){
		CrmRefer findRefer = this.getReferService().findById(this.getModel().getReferId());
		this.push(findRefer);
		return "preAddStudent";
	}
	
	
	public String addStudent(){
		return "addStudent";
	}
	
}
