package com.stt.listdedup;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 石添
 * @date 2023/12/14
 * 使用单循环循环
 */
public class Test1 {
    public static void main(String[] args) {
        // 创建集合
        List<String> list = new ArrayList<>();
        list.add("山兔");
        list.add("阿米娅");
        list.add("小团团");
        list.add("原神派蒙");
        list.add("阿米娅");
        list.add("原神可莉");
        list.add("小团团");
        // 1、使用单循环去重
        List<String> newList = new ArrayList<>();
        for (String item : list) {
            if(!newList.contains(item)) {
                newList.add(item);
            }
        }
        list.forEach(System.out::println);
        System.out.println("==============================");
        newList.forEach(System.out::println);
    }

}
