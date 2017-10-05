package cn.ymb.crm.graduate.service;

import java.util.List;

import cn.ymb.crm.graduate.domain.CrmGraduate;

public interface GraduateService {

	List<CrmGraduate> findAll();

	void addOrEdit(CrmGraduate crmGraduate);

}
