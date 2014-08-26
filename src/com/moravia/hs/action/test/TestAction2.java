package com.moravia.hs.action.test;

import java.io.IOException;
import java.security.Key;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;
import org.springframework.stereotype.Controller;

import com.moravia.hs.action.BaseAction;
import com.moravia.hs.base.dao.EmpDAO;
import com.moravia.hs.base.dao.LoginviewDAO;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.view.Loginview;
import com.moravia.hs.util.DesUtil;
import com.moravia.hs.util.LoginAuthentification;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//import org.springframework.web.struts.ActionSupport;
@Controller("testAction2")
public class TestAction2 extends BaseAction {

	private String fsip_customChooseEmp;
	private String forTest;

	public String getFsip_customChooseEmp() {
		return fsip_customChooseEmp;
	}

	public void setFsip_customChooseEmp(String fsip_customChooseEmp) {
		this.fsip_customChooseEmp = fsip_customChooseEmp;
	}

	public String getForTest() {
		return forTest;
	}

	public void setForTest(String forTest) {
		this.forTest = forTest;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("fsip_customChooseEmp: " + fsip_customChooseEmp);
		
		System.out.println("forTest: " + forTest);
		
		return SUCCESS;
	}

}
