package com.stt.stream.test2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @date 石添
 * @date 2023/12/26
 */
public class MapAndFlatMapMain {
    public static void main(String[] args) {
        // 1、map
        // 定义数组
        String[] strArr = {"hello","am","Stream","see you again","see you tomorrow"};
        // 方法引用
        Stream<String> stream = Arrays.stream(strArr).filter(item -> item.length() > 5).map(String::toUpperCase);
        List<String> list = stream.toList();
        // list.forEach(System.out::println);

        List<Integer> lengthList = Arrays.stream(strArr).map(String::length).toList();
        // lengthList.forEach(System.out::println);

        // 2、flatMap
        // 给定单词列表[“See”,“You”]，你想要返回列表[“S”,“e”,“e”, “Y”,“o”,“u”]
        // 数组
        String[] arr = {"See","You"};
        // 转换流
        Stream<String> flatStream = Arrays.stream(arr);
        Stream<String> flatResultStream = flatStream.flatMap(item -> {
            // item: See     You
            // See--------->S e e
            // You--------->Y o u
            String[] split = item.split("");
            // return的是一个Stream------》一个元素就是一个流
            return Arrays.stream(split);
        });
        List<String> streamList = flatResultStream.toList();
        streamList.forEach(System.out::println);
    }
}
