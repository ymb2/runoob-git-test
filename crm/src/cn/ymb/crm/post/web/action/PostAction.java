package cn.ymb.crm.post.web.action;

import java.util.List;

import cn.ymb.crm.base.BaseAction;
import cn.ymb.crm.department.domain.CrmDepartment;
import cn.ymb.crm.post.domain.CrmPost;

public class PostAction extends BaseAction<CrmPost> {
	
	private static final long serialVersionUID = -6743434342449L;
	
	public String ajaxGetPostion(){

		String depId = this.getModel().getCrmDepartment().getDepId();
		List<CrmPost> allPost = this.getPostService().findAll(depId);
		this.set("allPost", allPost);
		
		return "ajaxGetPostion";
	}
	

	public String findAll(){
		List<CrmPost> allPost = this.getPostService().findAll();
		this.set("allPost", allPost);
		
		return "findAll";
	}
	

	public String preAddOrEdit(){

		if(this.getModel().getPostId() != null){
			CrmPost findPost = this.getPostService().findById(this.getModel().getPostId());
			this.push(findPost);
		}

		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();

		this.put("allDepartment", allDepartment);
		
		return "preAddOrEdit";
	}
	

	public String addOrEdit(){
		this.getPostService().addOrEdit(this.getModel());
		return "addOrEdit";
	}
	
	
}
