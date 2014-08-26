package com.test;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.TimesheetDAO;
import com.moravia.hs.base.entity.Timesheet;
import com.moravia.hs.util.TimesheetUtil;

public class BaseTest {
	public static ApplicationContext context;

	private ApplicationContext getContext() {
		if(context == null) {
			context = new ClassPathXmlApplicationContext("applicationContext.xml");
		return context;
		} else {
			return context;
		}
	}
	
	public Object getBean(String beanName) {
		return getContext().getBean(beanName);
	}
	
	/*public static void main(String[] args) throws ParseException, InterruptedException, SQLException {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		TimesheetDAO timesheetDAO = (TimesheetDAO) context.getBean("timesheetDAO");
//		
//		Calendar calendar = Calendar.getInstance();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		// 取得当前日期往前推一个月的时间
//		calendar.add(Calendar.MONTH, -1);
//		
//	    int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH) + 1;
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
////        date = year + "-" + month + "-" + day;
//		
//        Date date = calendar.getTime();
//		Date date = new Date();
//        Date date2 = sdf.parse("1989-06-08");
//        Calendar cal2 = new cal
//        System.out.println(date.compareTo(date2));
//        
//        calendar.compareTo(anotherCalendar)
        
//        
//        Date date2 = new Date();
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("date: " + sdf.format(date));
//        System.out.println("当前时间为： " + sdf2.format(date2));
//		// 在CN数据库中取得特定时间段的内容
//		TimesheetUtil tsu = new TimesheetUtil();
//		List<Timesheet> tss = tsu.getTimeSheetsAfterByDate(sdf.format(date));
//		
//		System.out.println("tss.size(): " + tss.size());
		
		// 删除原有数据库内特定时间段的内容
//		timesheetDAO.deleteByDate(date);
		
		// 保存更新的timeSheet内容
//		timesheetDAO.batchSave(tss);
        
        
        Calendar dob = Calendar.getInstance();  
        dob.setTime(date2);  
        Calendar today = Calendar.getInstance();  
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);  
        System.out.println(age);
        if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
          age--;  
        }
        
        System.out.println(age);
		
		String str = "abc;ddd;eee;fff;ggg;";
		String[] arr = str.split(";");
		for (String string : arr) {
			System.out.println(string);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String str1 = "2014-07-02 18:30";
		String str2 = "2014-07-02 20:00";
		Date date1 = sdf.parse(str1);
		Date date2 = sdf.parse(str2);
//		Calendar c1 = Calendar.getInstance();
//		Calendar c2 = Calendar.getInstance();
//		c1.setTime(date1);
//		c2.setTime(date2);

		//毫秒ms
        long diff = date2.getTime() - date1.getTime();

        long diffMinutesP = diff / (1000 * 60);
        
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);

        System.out.print("两个时间相差：");
        System.out.print(diffDays + " 天, ");
        System.out.print(diffHours + " 小时, ");
        System.out.print(diffMinutes + " 分钟, ");
        System.out.print(diffSeconds + " 秒.");
        
        System.out.print(diffMinutesP + " 分钟。。。.");
	}*/
}
