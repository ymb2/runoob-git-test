package cn.ymb.crm.student.dao.impl;

import java.util.List;

import cn.ymb.crm.student.dao.StudentDao;
import cn.ymb.crm.base.impl.BaseDaoImpl;
import cn.ymb.crm.student.domain.CrmStudent;

public class StudentDaoImpl extends BaseDaoImpl<CrmStudent> implements StudentDao {

//	@Override
//	public void saveOrUpdate(CrmStudent crmStudent) {
//		this.getHibernateTemplate().saveOrUpdate(crmStudent);
//	}
//
	@SuppressWarnings("unchecked")
	@Override
	public List<CrmStudent> findAll() {
		return this.getHibernateTemplate().find("from CrmStudent order by status");
	}
//
//	@Override
//	public CrmStudent findById(String studentId) {
//		return this.getHibernateTemplate().get(CrmStudent.class, studentId);
//	}

}
