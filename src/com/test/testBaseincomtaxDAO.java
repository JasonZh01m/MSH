package com.test;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.BaseincomtaxDAO;
import com.moravia.hs.base.entity.Baseincomtax;

/*个税计算器*/
public class testBaseincomtaxDAO {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BaseincomtaxDAO dao = (BaseincomtaxDAO) context.getBean("baseincomtaxDAO");
		
		
//		
//		dao.deleteById(13);
//		
//		Scanner sc = new Scanner(System.in);
//		String a = sc.next();
//		
//		
		
		List<Baseincomtax> list = dao.findAll();
		System.out.println(list.size());
		
		double incom = 4321.35;
		double threshold = 3500;
		double tax = 0;
		double figure = incom - threshold;
		Collections.reverse(list);
		//Round
		DecimalFormat df = new DecimalFormat("#.00");
		
		for (Baseincomtax baseincomtax : list) { 
			if(figure > baseincomtax.getIncomtaxValue()) {
				tax += (figure - baseincomtax.getIncomtaxValue()) * baseincomtax.getIncomtaxRate() / 100;
				figure = baseincomtax.getIncomtaxValue();
			}
		}
		
		System.out.println(df.format(tax));
		/*
		Double dd = Double.parseDouble(df.format(tax));
		System.out.println(dd.getClass());
		System.out.println(dd * 2);*/
		
		
	}
	
}
