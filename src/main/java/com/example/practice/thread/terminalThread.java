package com.example.practice.thread;

/**
 * @author zhangtao
 * @data 2021/1/11 - 15:36
 * 手动终止线程
 */
public class terminalThread {

    public static void main(String[] args) {
        Abc abc = new Abc();
        Thread t = new Thread(abc);
        t.start();
    }
}


class Abc implements Runnable{

    Boolean flag = true;
    int i =0;
    @Override
    public void run() {
        while (flag){
            System.out.println("run"+i++);
            if (i==50){
                terminal();
            }
        }
    }

    public void terminal(){
        flag = false;
    }
}
