package cn.ymb.crm.department.service;

import java.util.List;

import cn.ymb.crm.department.domain.CrmDepartment;

public interface DepartmentService {

	List<CrmDepartment> findAll();


	void addOrEdit(CrmDepartment crmDepartment);

	CrmDepartment findById(String depId);

}
