package com.stt.interfacedemo;

/**
 * @date 石添
 * @date 2023/12/19
 */
public class MyInterfaceImpl implements MyInterface{

    @Override
    public void abstractTest() {
        System.out.println("实现类，实现抽象方法");
    }

    // 不是重写
    static String staticFun() {
        System.out.println("实现类静态方法");
        return "实现类 static function ......";
    }

}
