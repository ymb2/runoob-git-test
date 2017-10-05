package cn.ymb.crm.classesm.service;

import java.util.List;

import cn.ymb.crm.classesm.domain.CrmClass;
import cn.ymb.crm.coursetype.domain.CrmCourseType;

public interface ClassService {


	List<CrmClass> findAll();


	CrmClass findById(String classId);

	void addOrEdit(CrmClass crmClass);


	List<CrmClass> findAll(CrmCourseType courseType);


	void updateSchedule(CrmClass model);

}
