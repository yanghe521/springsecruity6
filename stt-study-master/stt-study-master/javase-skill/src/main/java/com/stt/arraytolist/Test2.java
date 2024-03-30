package com.stt.arraytolist;

import java.util.Arrays;
import java.util.List;

/**
 * @date 石添
 * @date 2023/12/13
 */
public class Test2 {
    public static void main(String[] args) {
        String[] books = {"明朝那些事儿","天幕红尘","遥远救世主","被讨厌的勇气"};
        // 将数组转换为集合
        List<String> list = Arrays.asList(books);
        boolean flag = list.contains("明朝那些事儿");
        System.out.println(flag);
        // 写操作，不可以
        // list.add("当下的力量");
    }
}
