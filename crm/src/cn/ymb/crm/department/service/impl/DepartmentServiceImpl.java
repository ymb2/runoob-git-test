package cn.ymb.crm.department.service.impl;

import java.util.List;

import cn.ymb.crm.department.dao.DepartmentDao;
import cn.ymb.crm.department.service.DepartmentService;
import cn.ymb.crm.department.domain.CrmDepartment;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	@Override
	public List<CrmDepartment> findAll() {
		return departmentDao.findAll();
	}

	@Override
	public void addOrEdit(CrmDepartment crmDepartment) {
		departmentDao.saveOrUpdate(crmDepartment);
	}

	@Override
	public CrmDepartment findById(String depId) {
		return departmentDao.findById(depId);
	}

}
