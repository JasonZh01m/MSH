package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.DepartmentDAO;
import com.moravia.hs.base.dao.EmpDAO;
import com.moravia.hs.base.dao.EmpchangerecordDAO;
import com.moravia.hs.base.dao.PayrollrecordDAO;
import com.moravia.hs.base.entity.other.HistoryTrack;
import com.moravia.hs.base.entity.other.HistoryTrackD;

public class testEmpchangerecordDAO {

	public static void main(String[] args) throws ParseException {
		
		  ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml" );
		  EmpchangerecordDAO empchangeDao = (EmpchangerecordDAO) context.getBean("empchangerecordDAO");
//		  System.out.println(empchangeDao.getLatestPositionTitle("abbys", ""));
//		  System.out.println(empchangeDao.getLatestDepartment("abbys"));
//		  System.out.println(empchangeDao.getLatestCostCenter("abbys"));
//		  
//		  System.out.println(empchangeDao.getLatestBaseSalary("abbys", "2013-06-31"));
//		  System.out.println(empchangeDao.getLatestSocialIns("abbys"));
//		  System.out.println(empchangeDao.getLatestMBORate("abbys"));
//		  List<HistoryTrack> hList = empchangeDao.getHistroryTrack_PositionTitleName("abbys");
//		  List<HistoryTrack> hList = empchangeDao.getHistroryTrack_DepartName("abbys");
//		  List<HistoryTrack> hList = empchangeDao.getHistroryTrack_LineManager("abbys");
		  
//		  List<HistoryTrack> hList = empchangeDao.getHistroryTrack_CostCenter("abbys");
		  
//		  List<HistoryTrackD> hdList = empchangeDao.getHistroryTrack_BaseSalary("abbys");
//		  List<HistoryTrackD> hdList = empchangeDao.getHistroryTrack_SocialIns("abbys");
//		  List<HistoryTrackD> hdList = empchangeDao.getHistroryTrack_MBO("abbys");
//		  List<HistoryTrack> hList = empchangeDao.getHistroryTrack_EmpType("abbys");
//		  
//		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////		  for (HistoryTrackD historyTrackD : hdList) {
////			System.out.println(historyTrackD.getValue() + "\t" + sdf.format(historyTrackD.getValidateDate()));
////		  }
//		  
//		  for (HistoryTrack historyTrack : hList) {
//			  System.out.println(historyTrack.getSection_Name() + "\t" + sdf.format(historyTrack.getValidateDate()));
//		}
		  
		  System.out.println(empchangeDao.getLatestBaseSalary("abbys", "2014-04-30"));
		  System.out.println(empchangeDao.getLatestSocialIns("abbys", "2014-04-30"));
		  
	}
	
}
