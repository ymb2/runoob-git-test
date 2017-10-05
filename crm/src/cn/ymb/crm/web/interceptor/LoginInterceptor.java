package cn.ymb.crm.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 46464674446346L;

	public String doIntercept(ActionInvocation invocation) throws Exception {
		Object loginUser = ActionContext.getContext().getSession().get("loginUser");
		if(loginUser == null){
			Object action = invocation.getAction();
			if(action instanceof ActionSupport){
				ActionSupport actionSupport = (ActionSupport) action;
				actionSupport.addFieldError("logonName", "请登录");
			}
			return "nonLogin";
		}
		return invocation.invoke();
	}

}
