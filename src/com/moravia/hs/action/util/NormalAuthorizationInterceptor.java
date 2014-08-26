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
public class NormalAuthorizationInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("##进入<<NormalAuthorizationInterceptor>>##");
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		
		Login login = (Login) session.get("login");
		
		if(login == null) {
			System.out.println("##NormalAuthorizationInterceptor##  请登录");
			return Action.LOGIN;
		} else {
			return invocation.invoke();
		}
	}
	
}
