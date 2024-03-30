package com.stt.arraytolist;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @date 石添
 * @date 2023/12/13
 */
public class Test5 {

    public static void main(String[] args) {

        String[] books = {"明朝那些事儿","天幕红尘","遥远救世主","被讨厌的勇气"};
        List<String> list1 = Arrays.stream(books).collect(Collectors.toList());
        list1.add("活着");
        list1.forEach(System.out::println);
        // 基本数据类型，需要boxed()装箱一下
        int[] arr = {1,2,3,4};
        IntStream stream = Arrays.stream(arr);
        Set<Integer> set = stream.boxed().collect(Collectors.toSet());
        set.add(3);
        set.add(5);
        set.forEach(System.out::println);
    }
}
