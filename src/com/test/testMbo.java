package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.LoginviewDAO;
import com.moravia.hs.base.dao.MboDAO;
import com.moravia.hs.base.dao.PositiontitleDAO;
import com.moravia.hs.base.entity.Mbo;
import com.moravia.hs.base.entity.view.Loginview;

public class testMbo {


    public static void main(String[] args) {
          ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml" );
          MboDAO basedao = (MboDAO)context.getBean("mboDAO");
//          Mbo mbo3 = new Mbo(mboRate, mboPaidPeriod, mboDesc, emps)
//          Mbo mbo2 = new Mbo();
//          mbo2.setMboId(14);
//          mbo2.setMboRate(0.55);
//          mbo2.setMboDesc("for test5");
//          basedao.save(mbo2);
          Mbo mbo = basedao.findByMBORate(15.0);
          System.out.println(mbo.getMboRate() + "\t" + mbo.getMboDesc());
          
          
    }
    
}
