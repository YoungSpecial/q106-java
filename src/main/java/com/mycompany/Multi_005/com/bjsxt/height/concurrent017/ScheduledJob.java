package com.mycompany.Multi_005.com.bjsxt.height.concurrent017;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class Temp extends Thread {
    public void run() {
        System.out.println("run");
    }
}

public class ScheduledJob {
	
    public static void main(String args[]) throws Exception {
    
    	Temp command = new Temp();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


        
        ScheduledFuture<?> scheduleTask = scheduler.scheduleWithFixedDelay(command, 5, 1, TimeUnit.SECONDS);
    
    }
}