package com.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.moravia.hs.base.dao.OvertimeinfoviewDAO;
import com.moravia.hs.base.entity.view.Overtimeinfoview;

public class testOvertimeView {

	public static void main(String[] args) throws ParseException {
		
		BaseTest bt = new BaseTest();
		OvertimeinfoviewDAO dao = (OvertimeinfoviewDAO) bt.getBean("overtimeinfoviewDAO");
		
		List<Overtimeinfoview> ovs = dao.findAll();
		
		SimpleDateFormat tssdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat datesdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date startdate = datesdf.parse("2014-08-01");
		Date enddate = datesdf.parse("2014-08-31");
		
		Calendar endcal = Calendar.getInstance();
		endcal.setTime(enddate);
		endcal.add(Calendar.DAY_OF_MONTH, 1);
		
		enddate = endcal.getTime();
		
		Timestamp startTime = new Timestamp(startdate.getTime());
		Timestamp endTime = new Timestamp(enddate.getTime());
		
		System.out.println(ovs.size());
		List<Overtimeinfoview> list2 = dao.findByEmp("jasonzh", startTime, endTime, "done");
		System.out.println("startTime.toString(): " + startTime.toString());
		System.out.println(list2.size());
		for (Overtimeinfoview oiv : list2) {
			
			System.out.println(oiv.getCostcenter() + "\t" + oiv.getEmploginid() + "\t" + oiv.getHours());
			
		}
		
	}
	
}
