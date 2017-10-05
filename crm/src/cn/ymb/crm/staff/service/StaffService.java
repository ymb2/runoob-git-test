package cn.ymb.crm.staff.service;

import java.util.List;

import cn.ymb.crm.staff.domain.CrmStaff;

public interface StaffService {

	public CrmStaff login(CrmStaff crmStaff);


	public List<CrmStaff> findAll();

	public List<CrmStaff> findAll(CrmStaff crmStaff);

	public void updatePassword(String staffId, String newPassword);


	public CrmStaff findById(String staffId);

	public void updateStaff(CrmStaff crmStaff);


	public void addStaff(CrmStaff crmStaff);

}
