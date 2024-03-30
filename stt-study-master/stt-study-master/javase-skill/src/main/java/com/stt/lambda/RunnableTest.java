package com.stt.lambda;

/**
 * @date 石添
 * @date 2023/12/17
 */
public class RunnableTest {

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "-------》线程启动！");
            }
        };
        Thread t1 = new Thread(r1,"自定义线程1");
        t1.start();

        // Lambda形式启动线程
        new Thread(() ->  System.out.println(Thread.currentThread().getName() + "-------》线程启动"),"自定义线程2").start();

    }
}
