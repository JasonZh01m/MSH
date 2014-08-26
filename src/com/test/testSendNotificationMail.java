package com.test;

import javax.mail.MessagingException;

import com.moravia.hs.util.Mailer;
import com.moravia.hs.util.SendNotificationMail;

public class testSendNotificationMail {
	
	public static void main(String[] args) throws MessagingException {
		
		SendNotificationMail nm = new SendNotificationMail();
		
		String from = "jasonzh@moravia.com";
		String to = "xinghuai_zhou@163.com";
		
		nm.setFrom(from);
		nm.setTo(to);
		nm.setSubject("Test Subject for NM");
		nm.setLink("http://www.hao123.com");
		nm.setLinkText("Link to hao123.com");
		nm.setTitle("You hava a test affair.");
		nm.setTriggerBy("Somebody");
		nm.setType("Test Type");
		nm.setRequestState("Test State: Active");
		nm.sendMail();
	}

}
