package com.example.practice.thread;

/**
 * @author zhangtao
 * @data 2021/1/11 - 15:09
 */
public class prgarammer extends Thread{
    @Override
    public void run() {
        for (int i=0;i<200;i++){
            System.out.println("run"+i);
        }
    }
}
