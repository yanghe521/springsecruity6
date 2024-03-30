package com.stt.lambda;

import java.util.function.Consumer;

/**
 * @date 石添
 * @date 2023/12/17
 */
public class LambdaTest2 {

    public static void main(String[] args) {

        Consumer<String> c1 = new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println("c1=====》" + s);
            }
        };

        // Lambda写法
        Consumer<String> c2 = (str) -> {
            System.out.println("c2=====>" + str);
        };

        // 简写
        Consumer<String> c3 = str -> {
            System.out.println("c3=====>" + str);
        };

        // 终极简写
        Consumer<String> c4 = str -> System.out.println("c4=====>" + str);

        c1.accept("C1");
        c2.accept("C2");
        c3.accept("A1");
        c4.accept("A2");

    }
}
