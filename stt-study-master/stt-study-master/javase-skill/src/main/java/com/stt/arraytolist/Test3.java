package com.stt.arraytolist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date 石添
 * @date 2023/12/13
 */
public class Test3 {
    public static void main(String[] args) {

        String[] books = {"明朝那些事儿","天幕红尘","遥远救世主","被讨厌的勇气"};
        List<String> readList = Arrays.asList(books);
        // 创建util下,ArrayList
        List<String> list = new ArrayList<>(readList);
        list.add("围城");
        list.forEach(System.out::println);
    }
}
