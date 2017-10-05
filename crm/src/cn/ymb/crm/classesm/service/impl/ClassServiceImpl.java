package cn.ymb.crm.classesm.service.impl;

import java.util.Date;
import java.util.List;

import cn.ymb.crm.classesm.dao.ClassDao;
import cn.ymb.crm.classesm.service.ClassService;
import cn.ymb.crm.classesm.domain.CrmClass;
import cn.ymb.crm.coursetype.domain.CrmCourseType;

public class ClassServiceImpl implements ClassService {
	
	private ClassDao classDao;
	public void setClassDao(ClassDao classDao) {
		this.classDao = classDao;
	}
	@Override
	public List<CrmClass> findAll() {
		return classDao.findAll();
	}
	@Override
	public CrmClass findById(String classId) {
		return this.classDao.findById(classId);
	}
	@Override
	public void addOrEdit(CrmClass crmClass) {
		this.classDao.saveOrUpdate(crmClass);
	}
	@Override
	public List<CrmClass> findAll(CrmCourseType courseType) {
		
		return this.classDao.findAll("and crmCourseType = ?", courseType);
	}
	@Override
	public void updateSchedule(CrmClass crmClass) {
		CrmClass findClass = this.classDao.findById(crmClass.getClassId());
		findClass.setUploadFilename(crmClass.getUploadFilename());
		findClass.setUploadPath(crmClass.getUploadPath());
		findClass.setUploadTime(new Date());
	}

}
