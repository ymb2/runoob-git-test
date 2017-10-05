package cn.ymb.crm.staff.dao.impl;

import java.util.List;

import cn.ymb.crm.staff.dao.StaffDao;
import cn.ymb.crm.base.impl.BaseDaoImpl;
import cn.ymb.crm.staff.domain.CrmStaff;

public class StaffDaoImpl extends BaseDaoImpl<CrmStaff> implements StaffDao{

	@Override
	@SuppressWarnings("unchecked")
	public CrmStaff find(String loginName, String loginPwd) {
		List<CrmStaff> allUser = this.getHibernateTemplate().find("from CrmStaff where loginName = ? and loginPwd = ?", loginName,loginPwd);
		
//		List<CrmStaff> allUser = this.getHibernateTemplate().find("from CrmStaff");
		if(allUser != null && allUser.size() > 0){
			return allUser.get(0);
		}
		return null;
	}

}
