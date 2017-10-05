package cn.ymb.crm.post.service;

import java.util.List;

import cn.ymb.crm.post.domain.CrmPost;

public interface PostService {

	List<CrmPost> findAll(String depId);

	List<CrmPost> findAll();

	CrmPost findById(String postId);


	void addOrEdit(CrmPost crmPost);

}
