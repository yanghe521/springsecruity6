package com.stt.lambda;

import java.util.function.Supplier;

/**
 * @date 石添
 * @date 2023/12/17
 */
public class LambdaTest1 {

    public static void main(String[] args) {

        // 创建函数式接口
        Supplier<String> s1 = new Supplier<>() {
            @Override
            public String get() {
                return "理想国！";
            }
        };
        System.out.println(s1.get());

        // 2、Lambda写法
        Supplier<String> s2 = () -> {
          return "理想国精编版！";
        };
        System.out.println(s2.get());

        // 3、简写方式
        Supplier<String> s3 = () -> "理想国222！";
        System.out.println(s3.get());
    }

}
