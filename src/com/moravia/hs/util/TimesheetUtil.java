package com.moravia.hs.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.TimesheetDAO;
import com.moravia.hs.base.entity.Timesheet;

public class TimesheetUtil {

	static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// com.microsoft.sqlserver.jdbc.SQLServerDriver
	static final String URL = "jdbc:sqlserver://10.20.1.26:1433;databasename=moravia_cn;integratedSecurity=true";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = (Connection) DriverManager.getConnection(URL);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * This method can get a list contains timesheets from moravia_cn database by a formatted date string.
	 * All the timesheets will be late than the date defined.
	 * @return
	 * @throws SQLException
	 */
	public List<Timesheet> getTimeSheetsAfterByDate(String startDate) throws SQLException {
		List<Timesheet> timesheets = new ArrayList<Timesheet>();
        Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT VIEW_WatchDog_PM_CN.LoginName, VIEW_WatchDog_PM_CN.Date, VIEW_WatchDog_PM_CN.Start, VIEW_WatchDog_PM_CN.Stop, VIEW_WatchDog_PM_CN.DiffTime, VIEW_WatchDog_PM_CN.OrderID, VIEW_WatchDog_PM_CN.Project_Name, VIEW_WatchDog_PM_CN.PM_Name, VIEW_WatchDog_PM_CN.Language, VIEW_WatchDog_PM_CN.Type, VIEW_WatchDog_PM_CN.Activity_Group, VIEW_WatchDog_PM_CN.Invoicing_Indicator, VIEW_WatchDog_PM_CN.Role, VIEW_WatchDog_PM_CN.Position, VIEW_WatchDog_PM_CN.Tool, VIEW_WatchDog_PM_CN.Task, VIEW_WatchDog_PM_CN.Custom, VIEW_WatchDog_PM_CN.Note, VIEW_WatchDog_PM_CN.Lock  FROM Moravia_CN.dbo.VIEW_WatchDog_PM_CN VIEW_WatchDog_PM_CN  WHERE (VIEW_WatchDog_PM_CN.Date>={ts '" + startDate + " 00:00:00'})");
        
        Timesheet ts = null;
		
		String loginName = null;
		Date date = null;
		Time start = null;
		Time stop = null;
		Double diffTime = null;
		Integer orderId = null;
		String projectName = null;
		String pmName = null;
		String language = null;
		String type = null;
		String activityGroup = null;
		String invoicingIndicator = null;
		String role = null;
		String position = null;
		String tool = null;
		String task = null;
		String custom = null;
		String note = null;
		String tsLock = null;
		
		while (rs.next()) {
			loginName = rs.getString("LoginName");
			date = rs.getDate("Date");
			start = rs.getTime("Start");
			stop = rs.getTime("Stop");
			diffTime = rs.getDouble("DiffTime");
			orderId = rs.getInt("OrderID");
			projectName = rs.getString("Project_Name");
			pmName = rs.getString("PM_Name");
			language = rs.getString("Language");
			type = rs.getString("Type");
			activityGroup = rs.getString("Activity_Group");
			invoicingIndicator = rs.getString("Invoicing_Indicator");
			role = rs.getString("Role");
			position = rs.getString("Position");
			tool = rs.getString("Tool");
			task = rs.getString("Task");
			custom = rs.getString("Custom");
			note = rs.getString("Note");
			tsLock = rs.getString("Lock");
			
			ts = new Timesheet(loginName, date, start, stop, diffTime, orderId, projectName, pmName, language, type, activityGroup, invoicingIndicator, role, position, tool, task, custom, note, tsLock);
			timesheets.add(ts);
		}
		return timesheets;
	}

//	public static void main(String[] args) throws SQLException, IOException {
//		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml" );
//         TimesheetDAO dao = (TimesheetDAO)context.getBean("timesheetDAO");
//		String startDate = "2014-04-01";
//		String endDate = "2014-04-30";
//		Statement stmt = getConnection().createStatement();
//		ResultSet rs = stmt.executeQuery("SELECT VIEW_WatchDog_PM_CN.LoginName, VIEW_WatchDog_PM_CN.Date, VIEW_WatchDog_PM_CN.Start, VIEW_WatchDog_PM_CN.Stop, VIEW_WatchDog_PM_CN.DiffTime, VIEW_WatchDog_PM_CN.OrderID, VIEW_WatchDog_PM_CN.Project_Name, VIEW_WatchDog_PM_CN.PM_Name, VIEW_WatchDog_PM_CN.Language, VIEW_WatchDog_PM_CN.Type, VIEW_WatchDog_PM_CN.Activity_Group, VIEW_WatchDog_PM_CN.Invoicing_Indicator, VIEW_WatchDog_PM_CN.Role, VIEW_WatchDog_PM_CN.Position, VIEW_WatchDog_PM_CN.Tool, VIEW_WatchDog_PM_CN.Task, VIEW_WatchDog_PM_CN.Custom, VIEW_WatchDog_PM_CN.Note, VIEW_WatchDog_PM_CN.Lock  FROM Moravia_CN.dbo.VIEW_WatchDog_PM_CN VIEW_WatchDog_PM_CN  WHERE (VIEW_WatchDog_PM_CN.Date>={ts '" + startDate + " 00:00:00'} And VIEW_WatchDog_PM_CN.Date<={ts '" + endDate + " 23:59:59'})");
//
//		Timesheet ts = null;
//		
//		String loginName = null;
//		Date date = null;
//		Time start = null;
//		Time stop = null;
//		Double diffTime = null;
//		Integer orderId = null;
//		String projectName = null;
//		String pmName = null;
//		String language = null;
//		String type = null;
//		String activityGroup = null;
//		String invoicingIndicator = null;
//		String role = null;
//		String position = null;
//		String tool = null;
//		String task = null;
//		String custom = null;
//		String note = null;
//		String tsLock = null;
//		
//		List<Timesheet> list = new ArrayList<Timesheet>();
//		while (rs.next()) {
//			
//			loginName = rs.getString("LoginName");
//			date = rs.getDate("Date");
//			start = rs.getTime("Start");
//			stop = rs.getTime("Stop");
//			diffTime = rs.getDouble("DiffTime");
//			orderId = rs.getInt("OrderID");
//			projectName = rs.getString("Project_Name");
//			pmName = rs.getString("PM_Name");
//			language = rs.getString("Language");
//			type = rs.getString("Type");
//			activityGroup = rs.getString("Activity_Group");
//			invoicingIndicator = rs.getString("Invoicing_Indicator");
//			role = rs.getString("Role");
//			position = rs.getString("Position");
//			tool = rs.getString("Tool");
//			task = rs.getString("Task");
//			custom = rs.getString("Custom");
//			note = rs.getString("Note");
//			tsLock = rs.getString("Lock");
//			
//			ts = new Timesheet(loginName, date, start, stop, diffTime, orderId, projectName, pmName, language, type, activityGroup, invoicingIndicator, role, position, tool, task, custom, note, tsLock);
//			list.add(ts);
////			System.out.println(loginName);
////			System.out.println(date.toString());
////			System.out.println(start.toString());
//		}
//		System.out.println("list.size(): " + list.size());
////		for (Timesheet timesheet : list) {
////			dao.save(timesheet);
////		}
////		bw.flush();
////		bw.close();
////		fw.close();
//
//	}
}
