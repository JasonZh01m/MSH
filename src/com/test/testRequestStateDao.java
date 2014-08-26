package com.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.AbsencerecordDAO;
import com.moravia.hs.base.dao.EmpDAO;
import com.moravia.hs.base.dao.RequeststateDAO;
import com.moravia.hs.base.dao.TokenAbsenceDAO;
import com.moravia.hs.base.entity.Absencerecord;
import com.moravia.hs.base.entity.Requeststate;
import com.moravia.hs.base.entity.TokenAbsence;

public class testRequestStateDao {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		RequeststateDAO requestDao = (RequeststateDAO) context.getBean("requeststateDAO");
		TokenAbsenceDAO tdao = (TokenAbsenceDAO) context.getBean("tokenAbsenceDAO");
		AbsencerecordDAO adao = (AbsencerecordDAO) context.getBean("absencerecordDAO");
		RequeststateDAO rsdao = (RequeststateDAO) context.getBean("requeststateDAO");
		
		/*List<Requeststate> rss = rsdao.findAll();
		for (Requeststate rs : rss) {
			System.out.println(rs.getStateId() + "\t" + rs.getStateName() + "\t" + rs.getStateDesc());
		}*/
		Requeststate rs = rsdao.findByStateName("Inprog");
		System.out.println(rs.getStateId());
		
//		Requeststate res = new Requeststate();
//		
//		res.setStateName("InProcess");
//		res.setStateDesc("正在流转");
//		requestDao.save(res);
		
		/*TokenAbsence t = new TokenAbsence();
		t.setTokenState(1);
		t.setTokenExecutor("jasonzhs");
		
		TokenAbsence t2 = new TokenAbsence();
		t2.setTokenState(1);
		t2.setTokenExecutor("jasonzh2");
//		t.setAbsencerecord(absencerecord);
//		tdao.save(t);
		
		Set<TokenAbsence> tokenAbsences = new HashSet<TokenAbsence>();
		tokenAbsences.add(t);
		tokenAbsences.add(t2);
		
		Absencerecord ar = new Absencerecord();
		ar.setAbsenceApproverLineManager("jasonl");
		ar.setAbsenceApproverPm("joicy");
		ar.setApplicant("elvisx");
		ar.setAbsenceReason("no reason");
		ar.setEmpLoginId("jasonzh");
		ar.setTokenAbsences(tokenAbsences);
		t.setAbsencerecord(ar);
		t2.setAbsencerecord(ar);
		adao.save(ar);*/
		
		/*Absencerecord ar = adao.findById(3);
		Set<TokenAbsence> tokenAbsences = ar.getTokenAbsences();
		System.out.println(tokenAbsences.size());
		for (TokenAbsence tokenAbsence : tokenAbsences) {
			System.out.println(tokenAbsence.getTokenId() + "\t\t" + tokenAbsence.getTokenExecutor());
		}*/
		
	}
	
}
