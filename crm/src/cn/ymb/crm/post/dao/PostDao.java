package cn.ymb.crm.post.dao;

import java.util.List;

import cn.ymb.crm.base.BaseDao;
import cn.ymb.crm.post.domain.CrmPost;

public interface PostDao extends BaseDao<CrmPost>  {

	/**
	 * 通过部门id查询职务
	 * @param depId
	 * @return
	 */
	List<CrmPost> findAll(String depId);

}
