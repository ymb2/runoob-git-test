package cn.ymb.crm.staff.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.ymb.crm.staff.dao.StaffDao;
import cn.ymb.crm.staff.service.StaffService;
import cn.ymb.crm.staff.domain.CrmStaff;
import cn.ymb.crm.utils.StringUtils;

public class StaffServiceImpl implements StaffService {
	
	private StaffDao staffDao;
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	@Override
	public CrmStaff login(CrmStaff crmStaff) {
		String loginPwd = crmStaff.getLoginPwd();
		loginPwd = StringUtils.getMD5Value(loginPwd);
		return staffDao.find(crmStaff.getLoginName(), loginPwd);
	}

	@Override
	public List<CrmStaff> findAll() {
		return staffDao.findAll();
	}
	
	@Override
	public List<CrmStaff> findAll(CrmStaff crmStaff) {
		
		StringBuilder builder = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		if(crmStaff.getCrmPost() != null && crmStaff.getCrmPost().getCrmDepartment() != null){
			if(org.apache.commons.lang3.StringUtils.isNotBlank(crmStaff.getCrmPost().getCrmDepartment().getDepId())){
				builder.append(" and crmPost.crmDepartment.depId = ? ");
				paramsList.add(crmStaff.getCrmPost().getCrmDepartment().getDepId());
			}
		}
		if(crmStaff.getCrmPost() != null){
			if(org.apache.commons.lang3.StringUtils.isNotBlank(crmStaff.getCrmPost().getPostId())){
				builder.append(" and crmPost.postId = ? ");
				paramsList.add(crmStaff.getCrmPost().getPostId());
			}
		} 
		if(org.apache.commons.lang3.StringUtils.isNotBlank(crmStaff.getStaffName())){
			builder.append(" and staffName = ? ");
			paramsList.add(crmStaff.getStaffName());
		}
		
		String condition = builder.toString();
		Object[] params = paramsList.toArray();
		
		return staffDao.findAll(condition, params);
	}

	@Override
	public void updatePassword(String staffId, String newPassword) {
		String loginPwd = StringUtils.getMD5Value(newPassword);
		CrmStaff crmStaff = staffDao.findById(staffId);
		crmStaff.setLoginPwd(loginPwd);
	}

	@Override
	public CrmStaff findById(String staffId) {
		return staffDao.findById(staffId);
	}


	public void updateStaff(CrmStaff crmStaff) {
		String loginPwd = crmStaff.getLoginPwd();
		if(loginPwd.length() != 32){
			loginPwd = StringUtils.getMD5Value(loginPwd);
			crmStaff.setLoginPwd(loginPwd);
		}
		this.staffDao.update(crmStaff);
	}

	@Override
	public void addStaff(CrmStaff crmStaff) {
		String loginPwd = crmStaff.getLoginPwd();
		loginPwd = StringUtils.getMD5Value(loginPwd);
		crmStaff.setLoginPwd(loginPwd);
		
		this.staffDao.save(crmStaff);
	}


}
