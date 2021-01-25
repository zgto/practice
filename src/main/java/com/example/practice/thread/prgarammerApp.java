package com.example.practice.thread;

/**
 * @author zhangtao
 * @data 2021/1/11 - 15:13
 */
public class prgarammerApp {

    public static void main(String[] args) {
        prgarammer prgarammer = new prgarammer();
        prgarammer.setName("adad");
        prgarammer.setPriority(Thread.MAX_PRIORITY);
        prgarammer.start();

        for (int a=0;a<200;a++){
            System.out.println(Thread.currentThread().getName()+"--"+a);
        }

    }
}
