package cn.ymb.crm.coursetype.web.action;

import java.util.List;

import cn.ymb.crm.base.BaseAction;
import cn.ymb.crm.coursetype.domain.CrmCourseType;

public class CourseTypeAction extends BaseAction<CrmCourseType> {

	private static final long serialVersionUID = 4254225275757572L;


	public String findAll(){

		List<CrmCourseType> allCourseType = this.getCourseTypeService().findAll(this.getModel());
		this.set("allCourseType", allCourseType);
		return "findAll";
	}
	
	public String preAddOrEdit(){
		if(this.getModel().getCourseTypeId() != null){

			CrmCourseType findLessontype = this.getCourseTypeService().findById(this.getModel().getCourseTypeId());

			this.push(findLessontype);
		}
		return "preAddOrEdit";
	}
	

	public String addOrEdit(){
		this.getCourseTypeService().addOrEdit(this.getModel());
		return "addOrEdit";
	}

	
}
