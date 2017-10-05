package cn.ymb.crm.runoff.service.impl;

import java.util.List;

import cn.ymb.crm.classesm.dao.ClassDao;
import cn.ymb.crm.constant.CommonConstant;
import cn.ymb.crm.runoff.dao.RunOffDao;
import cn.ymb.crm.runoff.service.RunOffService;
import cn.ymb.crm.classesm.domain.CrmClass;
import cn.ymb.crm.runoff.domain.CrmRunOff;
import cn.ymb.crm.student.dao.StudentDao;
import cn.ymb.crm.student.domain.CrmStudent;

public class RunOffServiceImpl implements RunOffService {
	
	private RunOffDao runOffDao;
	public void setRunOffDao(RunOffDao runOffDao) {
		this.runOffDao = runOffDao;
	}
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	private ClassDao classDao;
	public void setClassDao(ClassDao classDao) {
		this.classDao = classDao;
	}
	@Override
	public void addRunoff(CrmRunOff crmRunOff) {
		CrmStudent crmStudent = this.studentDao.findById(crmRunOff.getCrmStudent().getStudentId());
		crmStudent.setStatus(CommonConstant.STUDENT_STATUS_RUNOFF);
		
		CrmClass findClass = this.classDao.findById(crmStudent.getCrmClass().getClassId());
		findClass.setRunoffCount(findClass.getRunoffCount() + 1);
		
		findClass.setTotalCount(findClass.getTotalCount() - 1);
		

		
		this.runOffDao.save(crmRunOff);
	}
	@Override
	public List<CrmRunOff> findAll() {
		return this.runOffDao.findAll();
	}
	

}
