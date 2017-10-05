package cn.ymb.crm.post.dao.impl;

import java.util.List;

import cn.ymb.crm.post.dao.PostDao;
import cn.ymb.crm.base.impl.BaseDaoImpl;
import cn.ymb.crm.post.domain.CrmPost;

public class PostDaoImpl extends BaseDaoImpl<CrmPost> implements PostDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<CrmPost> findAll(String depId) {
		return this.getHibernateTemplate().find("from CrmPost p where p.crmDepartment.depId = ?" , depId);
	}

}
