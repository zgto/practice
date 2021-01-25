package com.example.practice.thread;

/**
 * @author zhangtao
 * @data 2021/1/11 - 15:19
 */
public class pargramApp {

    public static void main(String[] args) {
        pragram pragram = new pragram();
        Thread t = new Thread(pragram);
        t.start();


        for (int a =0;a<100;a++){
            if (a==50){
                try {
                    t.join();//合并线程（执行完之后再执行main的）
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("main"+a);
        }
    }
}
