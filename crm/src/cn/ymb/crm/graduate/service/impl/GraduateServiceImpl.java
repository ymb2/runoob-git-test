package cn.ymb.crm.graduate.service.impl;

import java.util.List;

import cn.ymb.crm.constant.CommonConstant;
import cn.ymb.crm.graduate.dao.GraduateDao;
import cn.ymb.crm.graduate.service.GraduateService;
import cn.ymb.crm.graduate.domain.CrmGraduate;
import cn.ymb.crm.student.dao.StudentDao;
import cn.ymb.crm.student.domain.CrmStudent;

public class GraduateServiceImpl implements GraduateService {
	
	private GraduateDao graduateDao;
	public void setGraduateDao(GraduateDao graduateDao) {
		this.graduateDao = graduateDao;
	}
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	@Override
	public List<CrmGraduate> findAll() {
		return this.graduateDao.findAll();
	}
	@Override
	public void addOrEdit(CrmGraduate crmGraduate) {
		//更新学生状态
		CrmStudent crmStudent = this.studentDao.findById(crmGraduate.getCrmStudent().getStudentId());
		crmStudent.setStatus(CommonConstant.STUDENT_STATUS_GRADUATE);
		
		this.graduateDao.saveOrUpdate(crmGraduate);
	}
	
	
	

}
