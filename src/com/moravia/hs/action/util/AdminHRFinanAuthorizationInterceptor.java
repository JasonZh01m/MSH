package com.moravia.hs.action.util;

import java.util.Map;

import com.moravia.hs.base.entity.other.Login;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 验证拦截器，判断用户是否有登录，没有则跳转到登录页面。
 * @author jasonzh
 */
public class AdminHRFinanAuthorizationInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("##进入<<AdminHRFinanAuthorizationInterceptor>>##");
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		
		Login login = (Login) session.get("login");
		
		if(login == null) {
			System.out.println("##AdminHRFinanAuthorizationInterceptor##  请登录");
			return Action.LOGIN;
		} else if (login.getEmp().getRole().getSysRoleId() > 3) {
			// role id > 3, 说明只有 Manager, Normal 的权限
			System.out.println("##权限不够！！！## 登录员工： " + login.getEmp().getEmpLoginId() + "\t权限： " + login.getEmp().getRole().getSysRoleName());
			session.put("globalError", "Sorry, you are not authorized to do that operation.");
			return Action.ERROR;
		} else {
			return invocation.invoke();
		}
	}
	
}
