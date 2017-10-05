package cn.ymb.crm.station.web.action;

import java.util.Date;
import java.util.List;

import cn.ymb.crm.base.BaseAction;
import cn.ymb.crm.coursetype.domain.CrmCourseType;
import cn.ymb.crm.staff.domain.CrmStaff;
import cn.ymb.crm.station.domain.CrmStation;
import cn.ymb.crm.student.domain.CrmStudent;

public class StationAction extends BaseAction<CrmStation> {

	private static final long serialVersionUID = -21272742752778L;
	
	public String add(){
		this.getModel().setCreateDate(new Date());
		CrmStaff crmStaff = (CrmStaff) this.sessionGet("loginUser");
		this.getModel().setCrmStaff(crmStaff);
		
		this.getStationService().addStation(this.getModel());
		return "add";
	}
	

	public String findAll(){
		List<CrmStation> allStation = this.getStationService().findAll();
		this.set("allStation", allStation);
		return "findAll";
	}
	

	public String preEditStation(){
		List<CrmCourseType> allCourseType = this.getCourseTypeService().findAll();
		this.put("allCourseType", allCourseType);
		
		CrmStudent findStudent = this.getStudentService().findById(this.getModel().getCrmStudent().getStudentId());
		this.push(findStudent);
				
		return "preEditStation";
	}

}
