package com.stt.functioninterface;

import java.util.function.Function;

/**
 * @date 石添
 * @date 2023/12/18
 */
public class Test1 {

    public static void main(String[] args) {

        // JDK8之前写法
        Function<String,String> function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                // 转换为大写
                return s.toUpperCase();
            }
        };
        System.out.println(function.apply("stt"));

        //
        Function<String,String> function2 = str -> str.toUpperCase();
        System.out.println(function.apply("huawei"));
    }

}
