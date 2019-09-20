package com.mycompany.Multi_004.com.bjsxt.height.design015;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MasterMY {

    //所有的任务列表
    ConcurrentLinkedQueue<Task> workQueue = new ConcurrentLinkedQueue();

    //所有的结果
    ConcurrentHashMap<String,Object> resultMap = new ConcurrentHashMap();

    //所有的处理Worker
    HashMap<String,Thread> workers = new HashMap();

    //构造类，创建几个工人
    public MasterMY(int workerCount) {
        for(int i=0 ; i < workerCount ; i++){
            WorkerMY worker = new WorkerMY();
            worker.setResultMap(resultMap);
            worker.setWorkQueue(workQueue);
            workers.put("worker"+i,worker);
        }
    }

    // 需要一个提交任务的方法
    public void submit(Task task){
        this.workQueue.add(task);
    }

    //开始任务
    public void excute(){
        for(Map.Entry<String,Thread> entry : workers.entrySet()){
            entry.getValue().run();
        }
    }

    //7 判断是否运行结束的方法
    public boolean isComplete() {
        for(Map.Entry<String, Thread> me : workers.entrySet()){
            if(me.getValue().getState() != Thread.State.TERMINATED){
                return false;
            }
        }
        return true;
    }

    //8 计算结果方法
    public int getResult() {
        int priceResult = 0;
        for(Map.Entry<String, Object> me : resultMap.entrySet()){
            priceResult += (Integer)me.getValue();
        }
        return priceResult;
    }


}
