package com.mycompany.Multi_004.com.bjsxt.height.design015;

import java.util.Random;

public class MainMY {

    public static void main(String[] args) {
        MasterMY masterMY = new MasterMY(10);

        Random random = new Random(1000);
        for(int i=0 ; i<100 ; i++){
            Task task = new Task();
            task.setId(i);
            task.setPrice(random.nextInt());
            masterMY.submit(task);
        }

        System.out.println("开始任务！");
        long begin = System.currentTimeMillis();
        masterMY.excute();

        while (true){
            if(masterMY.isComplete()){
                System.out.println("任务结束，共耗时："+(System.currentTimeMillis()-begin)+",运行结果为："+masterMY.getResult());
                break;
            }
        }


    }
}
