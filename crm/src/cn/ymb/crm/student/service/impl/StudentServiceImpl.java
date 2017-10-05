package cn.ymb.crm.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.ymb.crm.classesm.dao.ClassDao;
import cn.ymb.crm.constant.CommonConstant;
import cn.ymb.crm.refer.dao.ReferDao;
import cn.ymb.crm.student.dao.StudentDao;
import cn.ymb.crm.student.service.StudentService;
import cn.ymb.crm.classesm.domain.CrmClass;
import cn.ymb.crm.student.domain.CrmStudent;

public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	private ReferDao referDao;
	public void setReferDao(ReferDao referDao) {
		this.referDao = referDao;
	}
	private ClassDao classDao;
	public void setClassDao(ClassDao classDao) {
		this.classDao = classDao;
	}
	@Override
	public void addOrEdit(CrmStudent crmStudent) {
		
		if(crmStudent.getCrmClass() != null){
			if(crmStudent.getCrmClass().getClassId() == null){
				crmStudent.setCrmClass(null);
			}
		}
		if(crmStudent.getCrmRefer() != null){
			this.referDao.findById(crmStudent.getCrmRefer().getReferId()).setStatus(CommonConstant.REFER_STATUS_SIGNUP);
		}
		
		CrmClass crmClass = classDao.findById(crmStudent.getCrmClass().getClassId());
		crmClass.setTotalCount(crmClass.getTotalCount() + 1);
		
		this.studentDao.saveOrUpdate(crmStudent);
	}
	@Override
	public List<CrmStudent> findAll() {
		return this.studentDao.findAll();
	}
	@Override
	public CrmStudent findById(String studentId) {
		return this.studentDao.findById(studentId);
	}
	@Override
	public List<CrmStudent> findAll(CrmStudent crmStudent) {
		
		StringBuilder builder = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		if(crmStudent.getCrmClass() != null){
			String classId = crmStudent.getCrmClass().getClassId();
			if(classId != null && !"".equals(classId)){
				builder.append(" and crmClass = ?");
				paramsList.add(crmStudent.getCrmClass());
			} else {
				if(crmStudent.getCrmClass().getCrmCourseType() != null){
					String courseTypeId = crmStudent.getCrmClass().getCrmCourseType().getCourseTypeId();
					if(courseTypeId != null && !"".equals(courseTypeId)){
						builder.append(" and crmClass.crmCourseType = ?");
						paramsList.add(crmStudent.getCrmClass().getCrmCourseType());
					}
				}
			}
		}
		if(crmStudent.getCondition() != null && !"".equals(crmStudent.getCondition())){
			
			builder.append(" and (name like ?");
			paramsList.add("%"+crmStudent.getCondition()+"%");
			builder.append(" or qq like ?");
			paramsList.add("%"+crmStudent.getCondition()+"%");
			builder.append(" or telephone like ?");
			paramsList.add("%"+crmStudent.getCondition()+"%");
			builder.append(" or gender = ? )");
			paramsList.add(crmStudent.getCondition());
			
			
		}
		
		builder.append(" order by status");
		
		return this.studentDao.findAll(builder.toString(), paramsList.toArray());
	}
	@Override
	public List<CrmStudent> findAll(String classId) {		
		
		return this.studentDao.findAll(" and crmClass.classId = ? and status != ?", classId,CommonConstant.STUDENT_STATUS_RUNOFF);
	}
	
	
	

}
