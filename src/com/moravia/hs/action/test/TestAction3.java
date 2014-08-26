package com.moravia.hs.action.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.moravia.hs.action.BaseAction;
import com.moravia.hs.base.dao.AbsencerecordDAO;
import com.moravia.hs.base.entity.Absencerecord;
import com.opensymphony.xwork2.ActionSupport;

@Controller("testAction3")
public class TestAction3 extends BaseAction {
	
	@Autowired
	private AbsencerecordDAO absencerecordDAO;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> session = getSession();
		Absencerecord ar = absencerecordDAO.findById(1);
//		System.out.println(ar.getRequeststate().getStateName());
		
		session.put("test_info_ar", ar); 
		
		return SUCCESS;
	}
	
	
	

}
