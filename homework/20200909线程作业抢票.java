package com.tcp;

public class Main {
    public static void main(String[] args) throws Exception {
        Web12306 web = new Web12306();
        Thread proxy1 = new Thread(web, "黄牛");
        Thread proxy2 = new Thread(web, "程序员");
        Thread proxy3 = new Thread(web, "农民工");
        proxy1.start();
        proxy2.start();
        proxy3.start();
    }
}

class Web12306 implements Runnable {
    private static final Object lock = new Object();
    private static int num = 20; // 总共x张票
    private static boolean flag = true;

    @Override
    public void run() {
        while (flag){
            scrambleTicket();
        }
    }

    public void scrambleTicket() {
        synchronized (Web12306.lock){
            if (num <= 0) {
                flag = false;
                return;//跳出循环，结束
            }
            try {
                Thread.sleep(100);//模拟延时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了:" + num--);
            if (num == 0) System.out.println("票卖完了！");
        }
    }
}
