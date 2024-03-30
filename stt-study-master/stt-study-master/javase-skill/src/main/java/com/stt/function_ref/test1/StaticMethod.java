package com.stt.function_ref.test1;

/**
 * @date 石添
 * @date 2023/12/21
 */
public class StaticMethod {

    static String method1(String str) {
        str = str.toUpperCase();
        System.out.println("method1==========》" + str);
        return str;
    }
}
