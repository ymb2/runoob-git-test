package cn.ymb.crm.station.service;

import java.util.List;

import cn.ymb.crm.station.domain.CrmStation;

public interface StationService {

	void addStation(CrmStation crmStation);
	
	List<CrmStation> findAll();

}
