package com.it.piv.mms.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class ScheduledExample {
	
	public static void main (String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context =
                  new AnnotationConfigApplicationContext(
                            MyConfig.class);

        MyBean bean = context.getBean(MyBean.class);
        System.out.printf("calling MyBean#runTask() thread: %s%n",
                          Thread.currentThread().getName());
        
        
        
        bean.runTask();
        System.out.println("call MyBean#runTask() returned");

        //exit after 5 secs
        Thread.sleep(5000);
        System.exit(0);
    }

}
