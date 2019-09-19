package com.mycompany.Multi_001.com.bjsxt.base.sync007;

import java.util.concurrent.TimeUnit;

public class ValueNotSee {

    int a = 0;

    public void setA10() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"--------"+a);
        a = 10;
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+"--------"+a);
    }

    public void setA20 () throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"--------"+a);
        Thread.sleep(500);
        System.out.println(Thread.currentThread().getName()+"--------"+a);
        a = 20;
        System.out.println(Thread.currentThread().getName()+"--------"+a);
    }

    public static void main(String[] args) throws InterruptedException {
        final ValueNotSee valueNotSee = new ValueNotSee();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    valueNotSee.setA10();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1");
        t1.start();
//        Thread.sleep(2000);
//        valueNotSee.setA20();
        valueNotSee.a = 20;


    }

}
