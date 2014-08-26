package com.test;

import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.AbsencerecordDAO;
import com.moravia.hs.base.dao.RequeststateDAO;
import com.moravia.hs.base.entity.Absencerecord;
import com.moravia.hs.base.entity.Absencerequestitem;
import com.moravia.hs.base.entity.Absencerequestlog;
import com.moravia.hs.base.entity.Requeststate;
import com.moravia.hs.base.entity.other.PageBean;
import com.moravia.hs.base.entity.other.VacationUsedInfo;

public class testAbsenceRecord {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AbsencerecordDAO ardao = (AbsencerecordDAO) context.getBean("absencerecordDAO");
		RequeststateDAO rsdao = (RequeststateDAO) context.getBean("requeststateDAO");
		
//		List<Absencerecord> ars = ardao.findByEmpLoginId("jasonzh");
//		
//		for (Absencerecord ar : ars) {
//			System.out.println(ar.getAbsenceRecordId() + "\t" + ar.getAbsenceApproverPm());
//		}
//		List<Absencerecord> ars = null;
		/*List<Requeststate> rss = rsdao.findAll();
		for (Requeststate rs : rss) {
			if(rs.getStateName().equals("InProg")) {
			 	ars = ardao.findByEmpLoginIdAndRequestState("JasonZh", rs);
			}
		}*/
//		ars = ardao.findAll();
		
//		for (Absencerecord ar : ars) {
//			System.out.println(ar.getEmpLoginId() + "\t" + ar.getAbsenceApproverPm() + "\t");
//		}
		
//		Absencerecord ar = ardao.findById(1);
//		System.out.println(ar.getEmpLoginId() + "\t");
//		System.out.println(ar.getRequeststate());
//		Set<Absencerequestitem> items = ar.getAbsencerequestitems();
//		for (Absencerequestitem ai : items) {
//			System.out.println(ai.getAbsenceType());
//		}
		
//		List<Absencerecord> ars = ardao.findByEmpLoginId("jasonzh");
		
//		System.out.println(ars.size());
		/*for (Absencerecord ar : ars) {
			System.out.println(ar.getAbsenceRecordId() + "\t" + ar.getAbsenceApproverLineManager() + "\t" + ar.getRequeststate().getStateName());
		}*/
//		Set<Absencerequestlog> logs = ardao.findById(19).getAbsencerequestlogs();
//		
//		for (Absencerequestlog log : logs) {
//			System.out.println(log.getLogId() + "\t" + log.getChangeDate());
//		}
		
//		PageBean pageBean = ardao.findByEmpLoginId("AlvinZ", 10, 0);
//		
//		System.out.println(pageBean.getAllRow() + "\t" + pageBean.getTotalPage());
//		List<Absencerecord> ars = pageBean.getList();
//		for (Absencerecord ar : ars) {
//			System.out.println(ar.getAbsenceRecordId() + "\t" + ar.getAbsenceReason() + "\t" + ar.getRequeststate().getStateName());
//		}
		
		
		/*List<Absencerecord> ars = ardao.findByEmpLoginId("jasonzh");
		for (Absencerecord ar : ars) {
			System.out.println(ar.getAbsenceRecordId() + "\t" + ar.getAbsenceReason());
		}*/
		
		VacationUsedInfo vci = ardao.findVacationUsedInfo("jasonzh", "2014-07-01 00:00:00", "2014-07-31 00:00:00");
		System.out.println("vci.getAnnualLeave(): " + vci.getAnnualLeave());
		System.out.println("vci.getCompensatory(): " + vci.getCompensatory());
		System.out.println("vci.getPersonalLeave(): " + vci.getPersonalLeave());
		System.out.println("vci.getSickMateryBreaveLeave(): " + vci.getSickMateryBreaveLeave());
		System.out.println("vci.getLongSickMarriageLeave(): " + vci.getLongSickMarriageLeave());
		
		/*PageBean pagebean = ardao.findByEmpLoginId("alvin", 10, 1);
		
		List<Absencerecord> ars = pagebean.getList();
		System.out.println(pagebean.getTotalPage());
		for (Absencerecord ar : ars) {
			System.out.println(ar.getAbsenceRecordId() + "\t" + ar.getAbsenceReason());
		}*/
		
//		ardao.delete(ardao.findById(18));
		
//		System.out.println(.getEmpLoginId());
		
	}

}
