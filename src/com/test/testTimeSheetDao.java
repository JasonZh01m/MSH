package com.test;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.BasesalarypropertiesDAO;
import com.moravia.hs.base.dao.TimesheetDAO;
import com.moravia.hs.base.entity.Basesalaryproperties;
import com.moravia.hs.base.entity.Timesheet;
import com.moravia.hs.base.entity.other.SumTsInfo;
import com.moravia.hs.base.entity.other.TsInfoGroupByOrderId;
import com.moravia.hs.base.entity.other.TsMonthlyAbsenceInfo;
import com.moravia.hs.base.entity.other.TsSumDiffTime;

public class testTimeSheetDao {

	public static void main(String[] args) throws ParseException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TimesheetDAO tsdao = (TimesheetDAO)context.getBean("timesheetDAO");
		BasesalarypropertiesDAO bspdao = (BasesalarypropertiesDAO)context.getBean("basesalarypropertiesDAO");
//		List<TsGroupLoginNameAndOrderId> l = dao.findAllGroupByLoginNameAndOrderId("2013-03-01", "2013-03-31");
//		System.out.println(l.size());
		/*System.out.println(l.get(0).getNote() + "\t" + l.get(0).getPmName());*/
//		System.out.println("LoginName()\t\tOrderId()\t\tSumDiff()\t\tProjectName()\t\t\t\tPmName()");
//		for (TsGroupLoginNameAndOrderId tstemp : l) {
//			System.out.println(tstemp.getLoginName() + "\t\t" + tstemp.getOrderId() + "\t\t" + tstemp.getSumDiff() + "\t\t" + tstemp.getProjectName() + "\t\t\t\t" + tstemp.getPmName());
//		}
		
		
//		DecimalFormat df = new DecimalFormat("#.00");
//		
		Basesalaryproperties bsp = bspdao.findLastCreated();
		Double totalWorkHrs = bsp.getTotalWorkHours();
//		
//		List<SumTsInfo> sti_List = dao.SummaryTsInfo("2013-06-01", "2013-06-30");
//		System.out.println("sti_List.size(): " + sti_List.size());
//		for (SumTsInfo sumTsInfo : sti_List) {
//			System.out.println(sumTsInfo.getLoginId() + "\t\t" + sumTsInfo.getTsHrs() + "\t\t" + sumTsInfo.getAbsenceHrs() + "\t\t"
//		+ sumTsInfo.getPaidHrs() + "\t\t" + sumTsInfo.getNotPaidHrs() + "\t\t" + (sumTsInfo.getTsHrs() - totalWorkHrs) + "\tOver");
//		}
		
//		List<Timesheet> tsList = dao.findAllByEmpAndDate("abbys", "2013-03-01", "2013-03-31");
//		
//		System.out.println(tsList.size());
//		for (Timesheet ts : tsList) {
//			System.out.println(ts.getOrderId() + "\t" + ts.getProjectName() + "\t" + ts.getDiffTime() + "\t" + ts.getDate());
//		}
		
		
		/*SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String d1 = "12/01/2013";
		String d2 = "12/31/2013";
		Date date = sdf.parse(d1);
		System.out.println(date.toString());*/
		
//		List<TsSumDiffTime> l = dao.findAllByLoginNameAndSumTime("2013-12-01", "2013-12-31");
//		System.out.println("getLoginName()\t\t\tSumTime()\t\t\t工资");
//		for (TsSumDiffTime tsSumDiffTime : l) {
//			System.out.println(tsSumDiffTime.getLoginName() + "\t\t\t" + tsSumDiffTime.getSumTime() + "\t\t\t" + (tsSumDiffTime.getSumTime() * 3500 / 174) + "\t\t\t" + df.format(tsSumDiffTime.getSumTime() * 3500 / 174));
//		}
		
//		List<TsMonthlyAbsenceInfo> l = dao.findTsMonthlyAbsenceInfo("jennifers", "2013-03-01", "2013-03-31");
//		for (TsMonthlyAbsenceInfo tsMonthlyAbsenceInfo : l) {
//			System.out.println(tsMonthlyAbsenceInfo.getDate() + "\t" + tsMonthlyAbsenceInfo.getOrderId() + "\t" + tsMonthlyAbsenceInfo.getSumDiff());
//		}
//		
//		System.out.println(dao.findTsMonthlyOvertimeMoreThan11Hrs("jennifers", "2013-03-01", "2013-03-31"));
		
		/*List l = dao.findAll();
		System.out.println(l.size());*/
//		Date date = new Date();
//		List l2 = dao.findAll2();
//		System.out.println(l2.size());
//		Timestamp tstamp = new Timestamp(new Date().getTime());
//		Timestamp tstamp2 = new Timestamp(System.currentTimeMillis());
//		Timesheet ts = new Timesheet(1, "elvisx", tstamp, tstamp2, tstamp2, 8.0, 61, "Náhradní volno/Paid leave", "MHAJKOVA, LANTOSOVA, RADANAJ", "N/A", "Regular Hours", "Common", "Not to invoice", "Other", "s", "(N/A)", "trip short", "s", "National holiday", "0");
//		Timesheet ts2 = new Timesheet("elvisx", tstamp, tstamp2, tstamp2, 8.0, 61, "Náhradní volno/Paid leave", "MHAJKOVA, LANTOSOVA, RADANAJ", "N/A", "Regular Hours", "Common", "Not to invoice", "Other", "s", "(N/A)", "trip short", "s", "National holiday", "0");
//		Timesheet ts = new Timesheet();
//		ts.setLoginName("jasonzh2");
//		ts.setDate(tstamp);
//		ts.setStart(tstamp2);
//		ts.setStop(tstamp2);
//		dao.save(ts);
//		List list = dao.findAll();
//		System.out.println(list.size());
		
		tsdao.deleteByDate("2013-12-01");
		
	}
	
}
