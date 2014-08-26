package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.PositiontitleDAO;
import com.moravia.hs.base.entity.Positiontitle;

public class testPositiontitleDAO {

	public static void main(String[] args) {
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 PositiontitleDAO pdao = (PositiontitleDAO) context.getBean("positiontitleDAO");
//		 System.out.println(pdao.findById(1).getPositionTitleName());
		 
		 Positiontitle pt = new Positiontitle();
		 pt.setPositionTitleName("新职位");
		 pt.setPositionTitleDesc("测试新职位");
		 pdao.save(pt);
		 
	}
	
}
