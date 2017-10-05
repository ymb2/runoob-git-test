package cn.ymb.crm.student.web.action;

import java.util.List;

import cn.ymb.crm.constant.CommonConstant;
import cn.ymb.crm.base.BaseAction;
import cn.ymb.crm.classesm.domain.CrmClass;
import cn.ymb.crm.coursetype.domain.CrmCourseType;
import cn.ymb.crm.student.domain.CrmStudent;

public class StudentAction extends BaseAction<CrmStudent> {

	private static final long serialVersionUID = 375737372727401L;
	

	public String findAll(){
		
		List<CrmCourseType> allCourseType = this.getCourseTypeService().findAll();
		this.set("allCourseType", allCourseType);
		
		if(this.getModel().getCrmClass() != null){
			CrmCourseType crmCourseType = this.getModel().getCrmClass().getCrmCourseType();
			if( crmCourseType != null){
				List<CrmClass> allClass = this.getClassService().findAll(crmCourseType);
				this.set("allClass", allClass);
			}
		}
		
		List<CrmStudent> allStudent = this.getStudentService().findAll(this.getModel());
		this.set("allStudent", allStudent);
		return "findAll";
	}
	

	public String preAddOrEdit(){
		List<CrmCourseType> allCourseType = this.getCourseTypeService().findAll();
		this.put("allCourseType", allCourseType);
		
		
		if(this.getModel().getStudentId() != null){
			CrmStudent findStudent = this.getStudentService().findById(this.getModel().getStudentId());
			this.push(findStudent);
			
			if(findStudent.getCrmClass() != null){
				CrmCourseType crmCourseType = findStudent.getCrmClass().getCrmCourseType();
				if( crmCourseType != null){
					List<CrmClass> allClass = this.getClassService().findAll(crmCourseType);
					this.set("allClass", allClass);
				}
			}
		}
		return "preAddOrEdit";
	}
	/**
	 * 添加或编辑
	 * @return
	 */
	public String addOrEdit(){
		if(this.getModel().getStatus() == null){
			this.getModel().setStatus(CommonConstant.STUDENT_STATUS_DEFAULT);
		}
		
		this.getStudentService().addOrEdit(this.getModel());
		return "addOrEdit";
	}

	public String findById(){
		CrmStudent findStudent = this.getStudentService().findById(this.getModel().getStudentId());
		this.push(findStudent);
		return "findById";
	}
	

	public String ajaxGetStudent(){
		List<CrmStudent> allStudent = this.getStudentService().findAll(this.getModel().getCrmClass().getClassId());
		this.set("allStudent", allStudent);
		
		return "ajaxGetStudent";
	}
	

}
