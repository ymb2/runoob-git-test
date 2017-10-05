package cn.ymb.crm.staff.web.action;

import java.util.List;

import cn.ymb.crm.base.BaseAction;
import cn.ymb.crm.department.domain.CrmDepartment;
import cn.ymb.crm.post.domain.CrmPost;
import cn.ymb.crm.staff.domain.CrmStaff;
import cn.ymb.crm.utils.StringUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class StaffAction extends BaseAction<CrmStaff> {

	private static final long serialVersionUID = 5233838527571L;
	
	
	/**
	 * 一般有两种注解法

1.直接注在get方法上面，像这种

@RequiredStringValidator(message="Supply password")
 
public String getPassword() {
        
return password;
    }
 
2.注在方法上面，like

@Validations( 
requiredStrings={ 
@RequiredStringValidator(fieldName="username",message="用户名不能为空!"), 
@RequiredStringValidator(fieldName="telNum",message="电话号码不能为空!") 
}, 
regexFields={@RegexFieldValidator(fieldName="telNum",expression="^(\\+86|0|1)\\d{10,11}$", 
message="电话号码格式不正确！")} 
) 
 
但无论是哪种注解，默认情况下都是对这个action的所有方法进行验证。

如果验证不通过，将跳回result name 为 “input”的视图。错误信息是在 FieldError 里， 当然我们也可以用@InputConfig(resultName=“xxx”)，设置验证不通过跳回的视图.

@SkipValidation 如果某个方法不想验证，那么就可以用这个标签了

默认配置下，验证框架是对所有方法都进行了验证，其实我们可以对不需要验证的方法上写了@SkipValidation注解。。但这样又出现了问题，若有两个方法都需要进行验证但参数又不相同，那怎么办呢?那就是开启方法级别的验证啦
	 */
	@InputConfig(resultName="login")  //--------------方法验证器验证参数验证不成功返回的action
	public String login(){
		CrmStaff loginUser = this.getStaffService().login(this.getModel());
		if(loginUser != null){
			this.sessionPut("loginUser", loginUser);
			return "success";
		} else {
			// 登录不成功
			this.addFieldError("loginName", "账号和密码不匹配");//----------------验证成功   但  不匹配返回的action
			return "login";
		}
	}
	
	/**
	 * 查询所有用户（员工）
	 * @return
	 */
	public String findAll(){
		
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
		this.set("allDepartment", allDepartment);
		
		List<CrmPost> allPost = this.getPostService().findAll();
		this.set("allPost", allPost);
		
		List<CrmStaff> allUser = this.getStaffService().findAll(this.getModel());
		this.set("allUser", allUser);
		
		return "findAll";
	}
	
	

	public String logout(){
		ActionContext.getContext().getSession().remove("loginUser");
		return "login";
	}
	

	public void validateEditPassword() {
		CrmStaff loginStaff =  (CrmStaff) ActionContext.getContext().getSession().get("loginUser");
		String oldPassword = StringUtils.getMD5Value(this.getModel().getOldPassword());
		if(! loginStaff.getLoginPwd().equals(oldPassword)){
			this.addFieldError("loginName", "原始密码不正确");
		}
	}

	@InputConfig(resultName="pwdInput")//--------------方法验证器验证参数验证不成功返回的action
	public String editPassword(){
		CrmStaff loginStaff =  (CrmStaff) this.sessionGet("loginUser");
		
		this.getStaffService().updatePassword(loginStaff.getStaffId() , this.getModel().getNewPassword());
		
		return "editPassword";
	}
	

	public String preEdit(){
		
		CrmStaff findStaff = this.getStaffService().findById(this.getModel().getStaffId());
		ActionContext.getContext().getValueStack().push(findStaff);
		
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
		this.put("allDepartment", allDepartment);
		return "preEdit";
	}
	

	public String edit(){
		this.getStaffService().updateStaff(this.getModel());
		return "edit";
	}

	public String preAdd(){
		
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
		this.put("allDepartment", allDepartment);
		
		return "preAdd";
	}

	public String add(){
		this.getStaffService().addStaff(this.getModel());
		
		return "add";
	}
	
	
	
	
}
