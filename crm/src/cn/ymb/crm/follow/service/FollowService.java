package cn.ymb.crm.follow.service;

import cn.ymb.crm.follow.domain.CrmFollow;

public interface FollowService {
	

	public void addOrEdit(CrmFollow crmFollow);


	public CrmFollow findById(String followId);

}
