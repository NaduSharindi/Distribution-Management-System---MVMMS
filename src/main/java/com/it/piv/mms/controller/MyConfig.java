package com.it.piv.mms.controller;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.it.piv.util.common.MailMail;

@EnableScheduling
@Configuration
public class MyConfig
	{

	@Bean
    public MyBean myBean () {
        return new MyBean();
    }
		/*@Scheduled(fixedDelay = 5000)
	    //@Scheduled(fixedRate = 5000)  //Or use this
	    public void demoServiceMethod()
	    {
			try {
				ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
				MailMail mm = (MailMail) context.getBean("mailMail");
				mm.sendMailTo("Chief Engineer/Maintenance Engineer", "Method executed at every 5 seconds. Current time is :: "+ new Date() ,"gchampika28@gmail.com","Method executed at every 5 seconds. Current time is :: "+ new Date());
			}catch (Exception e) {
				     e.printStackTrace();
			}  

					System.out.println("Email Sent Succesfully...");

		    }
*/
	    }
		
		
