package com.example.practice.thread;

/**
 * @author zhangtao
 * @data 2021/1/11 - 15:17
 */
public class pragram implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println("run"+i);
        }
    }
}
