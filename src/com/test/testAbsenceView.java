package com.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.moravia.hs.base.dao.AbsenceinfoviewDAO;
import com.moravia.hs.base.entity.view.Absenceinfoview;

public class testAbsenceView {

	public static void main(String[] args) throws ParseException {
		
		BaseTest bt = new BaseTest();
		AbsenceinfoviewDAO dao = (AbsenceinfoviewDAO) bt.getBean("absenceinfoviewDAO");
		
		List<AbsenceinfoviewDAO> avs = dao.findAll();
		
		/*SimpleDateFormat tssdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat datesdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date startdate = datesdf.parse("2014-08-01");
		Date enddate = datesdf.parse("2014-08-31");
		
		Calendar endcal = Calendar.getInstance();
		endcal.setTime(enddate);
		endcal.add(Calendar.DAY_OF_MONTH, 1);
		
		enddate = endcal.getTime();
		
		Timestamp startTime = new Timestamp(startdate.getTime());
		Timestamp endTime = new Timestamp(enddate.getTime());
		
		System.out.println("startTime: " + startTime);
		System.out.println("endTime: " + endTime);
		
		System.out.println(avs.size());
		List<Absenceinfoview> list2 = dao.findByEmp("jasonzh", startTime, endTime, "inprog");
		System.out.println(list2.size());
		for (Absenceinfoview av : list2) {
			
			System.out.println(av.getEmpLoginId() + "\t" + av.getAbsenceHours() + "\t" + av.getVacationTypeName() + "\t" + av.getTypeId() + "\t" + av.getTimeSheetOrderId());
			
		}*/
		
		// 取得今年年初跟年终的时间，计算员工所有假期的使用情况。 
		Date date = new Date();
		SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdfyear = new SimpleDateFormat("yyyy");
		Calendar castart = Calendar.getInstance();
		Calendar caend = Calendar.getInstance();
		castart.set(Integer.parseInt(sdfyear.format(date)), 0, 0, 0, 0, 0);
		castart.add(Calendar.DATE, 1);
		caend.set(Integer.parseInt(sdfyear.format(date)) + 1, 0, 0, 0, 0, 0);
		
		Timestamp startTime = new Timestamp(castart.getTimeInMillis());
		Timestamp endTime = new Timestamp(caend.getTimeInMillis());
		
		List<Absenceinfoview> avs2 = dao.findByEmpAllState("jasonzh", startTime, endTime);
		
		double annualLeave = 0.0;
		double compensatory = 0.0;
		double personalLeave = 0.0;
		double longSickMarriageLeave = 0.0;
		double sickMateryBreaveLeave = 0.0;
		
		double annualLeave_inprog = 0.0;
		double compensatory_inprog = 0.0;
		double personalLeave_inprog = 0.0;
		double longSickMarriageLeave_inprog = 0.0;
		double sickMateryBreaveLeave_inprog = 0.0;
		
		double annualLeave_reject = 0.0;
		double compensatory_reject = 0.0;
		double personalLeave_reject = 0.0;
		double longSickMarriageLeave_reject = 0.0;
		double sickMateryBreaveLeave_reject = 0.0;
		
		
		for (Absenceinfoview av : avs2) {
			if(av.getStateName().equalsIgnoreCase("Done")) {
				switch (av.getVacationTypeName()) {
					case "Personal_Unpaid_Leave":
						// 事假
						personalLeave += av.getAbsenceHours();
						break;
						
					case "Long_Sick_Marriage_Leave":
						// 长病假
						longSickMarriageLeave += av.getAbsenceHours();
						break;
						
					case "Sick_Maternity_Breavement_Leave":
						// 病假/哺乳假
						sickMateryBreaveLeave += av.getAbsenceHours();
						break;
						
					case "Compensatory_Leave":
						// 调休假
						compensatory += av.getAbsenceHours();
						break;
						
					case "Annual_Leave":
						// 年假
						annualLeave += av.getAbsenceHours();
						break;
	
					default:
						break;
				}
			} else if (av.getStateName().equalsIgnoreCase("Rejected")) {
				switch (av.getVacationTypeName()) {
					case "Personal_Unpaid_Leave":
						// 事假
						personalLeave_reject += av.getAbsenceHours();
						break;
						
					case "Long_Sick_Marriage_Leave":
						// 长病假
						longSickMarriageLeave_reject += av.getAbsenceHours();
						break;
						
					case "Sick_Maternity_Breavement_Leave":
						// 病假/哺乳假
						sickMateryBreaveLeave_reject += av.getAbsenceHours();
						break;
						
					case "Compensatory_Leave":
						// 调休假
						compensatory_reject += av.getAbsenceHours();
						break;
						
					case "Annual_Leave":
						// 年假
						annualLeave_reject += av.getAbsenceHours();
						break;
	
					default:
						break;
				}
				
			} else if (av.getStateName().equalsIgnoreCase("InProg")) {
				switch (av.getVacationTypeName()) {
					case "Personal_Unpaid_Leave":
						// 事假
						personalLeave_inprog += av.getAbsenceHours();
						break;
						
					case "Long_Sick_Marriage_Leave":
						// 长病假
						longSickMarriageLeave_inprog += av.getAbsenceHours();
						break;
						
					case "Sick_Maternity_Breavement_Leave":
						// 病假/哺乳假
						sickMateryBreaveLeave_inprog += av.getAbsenceHours();
						break;
						
					case "Compensatory_Leave":
						// 调休假
						compensatory_inprog += av.getAbsenceHours();
						break;
						
					case "Annual_Leave":
						// 年假
						annualLeave_inprog += av.getAbsenceHours();
						break;
	
					default:
						break;
				}
			
			}
		}
	
		System.out.println("personalLeave: " + personalLeave);
		System.out.println("personalLeave: " + personalLeave_inprog);
		System.out.println("personalLeave: " + personalLeave_reject);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
