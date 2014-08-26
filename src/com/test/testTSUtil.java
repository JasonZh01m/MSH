package com.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.TimesheetDAO;
import com.moravia.hs.base.entity.Timesheet;
import com.moravia.hs.util.TimesheetUtil;

public class testTSUtil {
	
	public static void main(String[] args) throws SQLException, ParseException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TimesheetDAO timesheetDAO = (TimesheetDAO)context.getBean("timesheetDAO");
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Long t1 = System.currentTimeMillis();
//		timesheetDAO.deleteByDate("2014-04-30");
		Long t2 = System.currentTimeMillis();
		Date date1 = new Date(t2 - t1); 
		System.out.println("删除时间为：" + sdf.format(date1));
		TimesheetUtil tsu = new TimesheetUtil();
		List<Timesheet> tss = tsu.getTimeSheetsAfterByDate("2014-04-01");
		Long t3 = System.currentTimeMillis();
		Date date2 = new Date(t3 - t2);
		System.out.println("查询时间为：" + sdf.format(date2));
		
		System.out.println("tss.size(): " + tss.size());
		
//		timesheetDAO.batchSave(tss);
		
//		for (Timesheet ts : tss) {
//			timesheetDAO.save(ts);
//		}
		Long t4 = System.currentTimeMillis();
		Date date3 = new Date(t4 - t3);
		System.out.println("插入时间为：" + sdf.format(date3));
		// 5117
	}

}
