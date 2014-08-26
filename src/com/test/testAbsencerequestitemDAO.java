package com.test;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.AbsencerecordDAO;
import com.moravia.hs.base.dao.AbsencerequestitemDAO;
import com.moravia.hs.base.dao.DepartmentDAO;
import com.moravia.hs.base.entity.Absencerecord;
import com.moravia.hs.base.entity.Absencerequestitem;
import com.moravia.hs.base.entity.TokenAbsence;

public class testAbsencerequestitemDAO {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AbsencerequestitemDAO aidao = (AbsencerequestitemDAO) context.getBean("absencerequestitemDAO");
		AbsencerecordDAO ardao = (AbsencerecordDAO) context.getBean("absencerecordDAO");
		
		
		// 创建ar
		Absencerecord ar = new Absencerecord();
		ar.setAbsenceApproverLineManager("JasonL");
		ar.setAbsenceApproverPm("JasonM");
		ar.setAbsenceReason("生病请假");
		ar.setEmpLoginId("JasonZh");

		// 创建ai
		Absencerequestitem ai1 = new Absencerequestitem();
		ai1.setAbsenceType("SICK LEAVE");
		ai1.setAbsenceHours(2.5);
		ai1.setAbsencerecord(ar);
		
		Absencerequestitem ai2 = new Absencerequestitem();
		ai2.setAbsenceType("SICK LEAVE");
		ai2.setAbsenceHours(2.5);
		ai2.setAbsencerecord(ar);
		
		Set<Absencerequestitem> ais = new HashSet<Absencerequestitem>();
		ais.add(ai1);
		ais.add(ai2);
		ar.setAbsencerequestitems(ais);
		
		// 创建token
		TokenAbsence token = new TokenAbsence();
		token.setTokenState(1);
		token.setTokenExecutor("JaonL");
		token.setAbsencerecord(ar);
		Set<TokenAbsence> tokens = new HashSet<TokenAbsence>();
		tokens.add(token);
		
		ar.setTokenAbsences(tokens);
		
		ardao.save(ar);
	}
	
}
