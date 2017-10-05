package cn.ymb.crm.runoff.web.action;

import java.util.Date;
import java.util.List;

import cn.ymb.crm.constant.CommonConstant;
import cn.ymb.crm.base.BaseAction;
import cn.ymb.crm.runoff.domain.CrmRunOff;
import cn.ymb.crm.staff.domain.CrmStaff;
import cn.ymb.crm.student.domain.CrmStudent;

public class RunoffAction extends BaseAction<CrmRunOff> {

	private static final long serialVersionUID = -2573742472752745278L;
	

	public String preAdd(){
		CrmStudent findStudent = this.getStudentService().findById(this.getModel().getCrmStudent().getStudentId());
		this.push(findStudent);
		return "preAdd";
	}
	

	public String add(){
		CrmStaff crmStaff = (CrmStaff) this.sessionGet("loginUser"); 
		this.getModel().setCrmStaff(crmStaff);
		this.getModel().setCreateDate(new Date());
		if(CommonConstant.RUNOFF_REFUND_NOT.equals(this.getModel().getIsRefund())){
			this.getModel().setRefundAmount("");
		}
		
		this.getRunOffService().addRunoff(this.getModel());
		
		return "add";
	}
	

	public String findAll(){
		List<CrmRunOff> allRunOff = this.getRunOffService().findAll();
		this.set("allRunOff", allRunOff);
		
		return "findAll";
	}

}
