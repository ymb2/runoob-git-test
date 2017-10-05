package cn.ymb.crm.post.service.impl;

import java.util.List;

import cn.ymb.crm.post.dao.PostDao;
import cn.ymb.crm.post.service.PostService;
import cn.ymb.crm.post.domain.CrmPost;

public class PostServiceImpl implements PostService {

	private PostDao postDao;
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	
	@Override
	public List<CrmPost> findAll(String depId) {
		return postDao.findAll(depId);
	}
	@Override
	public List<CrmPost> findAll() {
		return postDao.findAll();
	}
	@Override
	public CrmPost findById(String postId) {
		return postDao.findById(postId);
	}
	@Override
	public void addOrEdit(CrmPost crmPost) {
		postDao.saveOrUpdate(crmPost);
	}

}
