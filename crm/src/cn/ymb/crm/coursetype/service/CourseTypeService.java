package cn.ymb.crm.coursetype.service;

import java.util.List;

import cn.ymb.crm.coursetype.domain.CrmCourseType;

public interface CourseTypeService {


	List<CrmCourseType> findAll();


	void addOrEdit(CrmCourseType crmCourseType);

	CrmCourseType findById(String courseTypeId);

	List<CrmCourseType> findAll(CrmCourseType crmCourseType);
}
