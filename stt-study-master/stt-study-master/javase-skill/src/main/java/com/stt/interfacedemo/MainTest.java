package com.stt.interfacedemo;

/**
 * @date 石添
 * @date 2023/12/19
 */
public class MainTest {

    public static void main(String[] args) {

        MyInterfaceImpl myInterface = new MyInterfaceImpl();
        // 重写的抽象方法
        myInterface.abstractTest();
        // 默认实现
        myInterface.test1();

        // 调用接口的静态方法
        MyInterface.staticFun();

        MyInterfaceImpl.staticFun();
    }
}
