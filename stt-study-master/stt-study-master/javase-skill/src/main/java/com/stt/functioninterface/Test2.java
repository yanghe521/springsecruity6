package com.stt.functioninterface;

import java.util.function.Predicate;

/**
 * @date 石添
 * @date 2023/12/18
 */
public class Test2 {

    public static void main(String[] args) {

        Predicate<String> p1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 3;
            }
        };
        System.out.println( p1.test("我们仨"));

        // Lambda形式
        Predicate<String> p2 = str -> {
            System.out.println("str=======>" + str);
            return str.length() > 3;
        };
        System.out.println( p2.test("八次危机"));
    }
}
