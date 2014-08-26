package com.moravia.hs.util;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.moravia.hs.base.dao.EmpDAO;
import com.moravia.hs.base.dao.TimesheetDAO;
import com.moravia.hs.base.entity.Timesheet;
import com.sun.org.apache.bcel.internal.generic.DALOAD;

public class UpdateTSTable {
	private static final Logger log = LoggerFactory.getLogger(EmpDAO.class);
	
	@Resource(name = "timesheetDAO")
	private TimesheetDAO timesheetDAO;
	
	@Resource(name = "timesheetUtil")
	private TimesheetUtil timesheetUtil;
	
	/**
	 * This method is designed to schedule update TimeSheet Table.
	 * @throws JobExecutionException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public void update() throws JobExecutionException, SQLException, ParseException {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		// 取得当前日期往前推一个月加10天的时间
		calendar.add(Calendar.MONTH, -1);
		calendar.add(Calendar.DATE, -10);
		
	    int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        
        Date startDate = calendar.getTime();
        
        Date nowDate = new Date();
//        System.out.println("当前时间为： " + nowDate);
//        System.out.println("提前一个月的时间为： " + startDate);

//        Long t1 = System.currentTimeMillis();
        // 在CN数据库中取得特定时间段的内容
		List<Timesheet> tss = timesheetUtil.getTimeSheetsAfterByDate(sdf.format(startDate));
		log.debug(nowDate + "\ttimesheetUtil.getTimeSheetsAfterByDate(" + sdf.format(startDate) + ")\tsize: " + tss.size());
//		System.out.println("tss.size(): " + tss.size() + "\t" + startDate);
		
//		Long t2 = System.currentTimeMillis();
//		System.out.println("查询时间为：" + (t2 - t1));
		
		// 删除原有数据库内特定时间段的内容
		timesheetDAO.deleteByDate(sdf.format(startDate));
		log.debug(nowDate + "\ttimesheetDAO.deleteByDate(" + sdf.format(startDate) + ")");
//		Long t3 = System.currentTimeMillis();
//		System.out.println("删除时间为：" + (t3 - t2));
		
		// 保存更新的timeSheet内容
		timesheetDAO.batchSave(tss);
		log.debug(nowDate + "\ttimesheetDAO.batchSave(tss)\tsize: " + tss.size());
//		Long t4 = System.currentTimeMillis();
//		System.out.println("保存时间为：" + (t4 - t3));
	}
}
