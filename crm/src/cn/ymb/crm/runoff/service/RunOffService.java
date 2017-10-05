package cn.ymb.crm.runoff.service;

import java.util.List;

import cn.ymb.crm.runoff.domain.CrmRunOff;

public interface RunOffService {

	void addRunoff(CrmRunOff crmRunOff);

	List<CrmRunOff> findAll();


}
