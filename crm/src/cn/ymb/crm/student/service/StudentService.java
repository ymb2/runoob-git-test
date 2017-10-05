package cn.ymb.crm.student.service;

import java.util.List;

import cn.ymb.crm.student.domain.CrmStudent;

public interface StudentService {

	public void addOrEdit(CrmStudent crmStudent);
	

	public List<CrmStudent> findAll();
	

	public List<CrmStudent> findAll(CrmStudent crmStudent);
	

	public CrmStudent findById(String studentId);


	public List<CrmStudent> findAll(String classId);
}
