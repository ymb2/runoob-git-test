package cn.ymb.crm.refer.service;

import java.util.List;

import cn.ymb.crm.refer.domain.CrmRefer;

public interface ReferService {
	
	public void addOrEdit(CrmRefer crmRefer);

	public List<CrmRefer> findAll();

	public List<CrmRefer> findAll(CrmRefer crmRefer);

	public CrmRefer findById(String referId);

	public void addRefer(CrmRefer crmRefer);

	public void updateRefer(CrmRefer crmRefer);

}
