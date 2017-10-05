package cn.ymb.crm.follow.service.impl;

import cn.ymb.crm.follow.dao.FollowDao;
import cn.ymb.crm.follow.service.FollowService;
import cn.ymb.crm.follow.domain.CrmFollow;

public class FollowServiceImpl implements FollowService {
	
	private FollowDao followDao;
	public void setFollowDao(FollowDao followDao) {
		this.followDao = followDao;
	}
	
	public void addOrEdit(CrmFollow crmFollow){
		this.followDao.saveOrUpdate(crmFollow);
	}

	@Override
	public CrmFollow findById(String followId) {
		return this.followDao.findById(followId);
	}

}
