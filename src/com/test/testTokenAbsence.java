package com.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.AbsencerecordDAO;
import com.moravia.hs.base.dao.AbsencerequestitemDAO;
import com.moravia.hs.base.dao.Pagination;
import com.moravia.hs.base.dao.TokenAbsenceDAO;
import com.moravia.hs.base.entity.Absencerecord;
import com.moravia.hs.base.entity.Absencerequestitem;
import com.moravia.hs.base.entity.TokenAbsence;
import com.moravia.hs.base.entity.other.PageBean;

public class testTokenAbsence {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TokenAbsenceDAO tokendao = (TokenAbsenceDAO) context.getBean("tokenAbsenceDAO");
		AbsencerecordDAO ardao = (AbsencerecordDAO) context.getBean("absencerecordDAO");
		
		// 创建ar
//		Absencerecord ar = new Absencerecord();
//		ar.setAbsenceApproverLineManager("JasonL");
//		ar.setAbsenceApproverPm("JasonM");
//		ar.setAbsenceReason("生病请假");
//		ar.setEmpLoginId("JasonZh");
		
		// 创建token
//		TokenAbsence token = new TokenAbsence();
//		token.setTokenState(1);
//		token.setTokenExecutor("JaonL");
//		token.setAbsencerecord(ar);
//		Set<TokenAbsence> tokens = new HashSet<TokenAbsence>();
//		tokens.add(token);
		
//		ar.setTokenAbsences(tokens);
		
//		ardao.save(ar);
//		tokendao.save(token);
		/*TokenAbsence ta = tokendao.findById(3);
		ta.setTokenState(0);
		tokendao.attachDirty(ta);
		*/
		
		/*List<TokenAbsence> tbs = tokendao.findByTokenExecutor("JasonL", 1);
		for (TokenAbsence tb : tbs) {
			System.out.println(tb.getTokenId() + "\t" + tb.getTokenExecutor() + "\t" + tb.getTokenState());
			Absencerecord ar = tb.getAbsencerecord();
			System.out.println("AbsenceRecord Info: " + ar.getEmpLoginId() + "\t" + ar.getAbsenceReason());
			for (Absencerequestitem ai : ar.getAbsencerequestitems()) {
				System.out.println("AbsenceItem: " + ai.getAbsenceType() + "\t" + ai.getVacationtype().getTimeSheetOrderId() + "\t" + ai.getAbsenceStartTime());
			}
		}*/
		
		PageBean pageBean = tokendao.findByTokenExecutorWithPageSize("jasonl", 1, 10, 1);
		for (Object o : pageBean.getList()) {
			TokenAbsence token = (TokenAbsence) o;
			System.out.println(token.getTokenExecutor() + "\t" + token.getTokenState());
		}
		
		
//		PageBean pageBean = tokendao.testqueryForPage(5, 2);
//		PageBean pageBean = tokendao.findByTokenExecutor2("JasonL", 1, 5, 3);
//		List<TokenAbsence> tokens = pageBean.getList();
//		System.out.println("pageBean.getAllRow(): " + pageBean.getAllRow());
//		System.out.println("tokens.size(): " + tokens.size());
//		for (TokenAbsence token : tokens) {
//			System.out.println(token.getTokenId() + "\t" + token.getTokenExecutor());
//		}
		
		
	}
	

}
