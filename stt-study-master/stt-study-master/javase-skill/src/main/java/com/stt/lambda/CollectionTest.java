package com.stt.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @date 石添
 * @date 2023/12/17
 */
public class CollectionTest {
    public static void main(String[] args) {


        // 创建集合
        List<String> list = new ArrayList<>();
        // 添加数据
        list.add("艾斯！");
        list.add("赛罗！");
        list.add("杰克！");
        list.add("雷欧！");
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("======================");
        // lambda
        list.forEach(str -> System.out.println(str));
        // 方法引用
        list.forEach(System.out::println);
    }
}
