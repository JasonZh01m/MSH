package com.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.AbsencerecordDAO;
import com.moravia.hs.base.dao.AbsencerequestitemDAO;
import com.moravia.hs.base.dao.AbsencerequestlogDAO;
import com.moravia.hs.base.dao.RequeststateDAO;
import com.moravia.hs.base.entity.Absencerecord;
import com.moravia.hs.base.entity.Absencerequestitem;
import com.moravia.hs.base.entity.Absencerequestlog;

public class testAbsenceRequestLog {

	public static void main(String[] args) throws InterruptedException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AbsencerequestlogDAO aldao = (AbsencerequestlogDAO) context.getBean("absencerequestlogDAO");
		AbsencerequestitemDAO aidao = (AbsencerequestitemDAO) context.getBean("absencerequestitemDAO");
		AbsencerecordDAO ardao = (AbsencerecordDAO) context.getBean("absencerecordDAO");
		RequeststateDAO rsdao = (RequeststateDAO) context.getBean("requeststateDAO");
		
//		Absencerequestitem ai = new Absencerequestitem();
//		ai.setAbsenceHours(2.5);
//		aidao.save(ai);
		
//		Absencerequestlog al = new Absencerequestlog();
//		al.setLogDesc("this is desc");
//		aldao.save(al);
		
		/*Absencerequestlog a1 = new Absencerequestlog();
		Absencerequestlog a2 = new Absencerequestlog();
		Absencerecord ar = ardao.findById(1);
		
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		a1.setAbsencerecord(ar);
		a1.setChangeDate(ts);
		a1.setChangePeople("JasonZh");
		a1.setRequeststate(rsdao.findById(1));
		a1.setLogDesc("Approved by JasonZh");
		a1.setLogId(1);
//		
//		aldao.save(a1);
		
		// 睡眠2秒
		Thread.sleep(2000);
		
		Date date2 = new Date();
		Timestamp ts2 = new Timestamp(date2.getTime());
//		a2.setAbsencerecord(ar);
		a2.setChangeDate(ts2);
		a2.setChangePeople("JasonL");
		a2.setRequeststate(rsdao.findById(3));
		a2.setLogDesc("Approved by JasonL");
		
		aldao.save(a1);
		aldao.save(a2);*/
		
		
		List<Absencerequestlog> logs = aldao.findByAbsenceRecord(19);
		for (Absencerequestlog log : logs) {
			System.out.println(log.getLogId() + "\t" + log.getChangePeople() + "\t" + log.getChangeDate());
		}
		
		
	}
	
}
