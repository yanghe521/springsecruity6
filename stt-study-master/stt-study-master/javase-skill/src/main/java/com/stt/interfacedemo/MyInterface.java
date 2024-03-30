package com.stt.interfacedemo;

public interface MyInterface {

    void abstractTest();

    default void test1() {
        System.out.println("接口的默认实现");
    }

    static String staticFun() {
        System.out.println("接口静态方法");
        return "interface static function ......";
    }
}
