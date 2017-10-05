package cn.ymb.crm.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.ymb.crm.staff.domain.CrmStaff;
import cn.ymb.crm.staff.service.StaffService;
import cn.ymb.crm.utils.StringUtils;

public class InitFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		String initAdmin = filterConfig.getInitParameter("initAdmin");
		if(Boolean.valueOf(initAdmin)){
			CrmStaff crmStaff = new CrmStaff();
			crmStaff.setLoginName("jack");
			crmStaff.setLoginPwd("1234");
			crmStaff.setStaffName("管理员");
			
			WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
			StaffService staffService = (StaffService) webApplicationContext.getBean("staffService");
			CrmStaff findStaff = staffService.login(crmStaff);
			if(findStaff == null){
				staffService.addStaff(crmStaff);
			}
		}
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		
	}

	@Override
	public void destroy() {

	}

}
