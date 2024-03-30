package com.stt.arraytolist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @date 石添
 * @date 2023/12/13
 */
public class Test4 {

    public static void main(String[] args) {

        String[] books = {"明朝那些事儿","天幕红尘","遥远救世主","被讨厌的勇气"};
        List<String> list = new ArrayList<>();
        // 通过Collections
        Collections.addAll(list,books);
        list.add("球形闪电");
        list.forEach(System.out::println);
    }

}
