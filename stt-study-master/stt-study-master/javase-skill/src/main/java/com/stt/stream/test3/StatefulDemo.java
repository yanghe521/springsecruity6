package com.stt.stream.test3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @date 石添
 * @date 2024/1/9
 */
public class StatefulDemo {

    public static void main(String[] args) {

        // 1、去重
        String[] arr = {"see","you"};
        // 1.1、对数组去重
        Stream<String> arrDistinct = Arrays.stream(arr).flatMap(str -> Arrays.stream(str.split(""))).distinct();
//        arrDistinct.forEach(System.out::println);

        // 1.2、对字符串去重
        String str = "helloworld";
        Stream<String> strDistinct = Stream.of(str).flatMap(item -> Arrays.stream(item.split(""))).distinct();
//        strDistinct.forEach(System.out::println);

        // 2、limit：获取指定个数的数据
        String[] strArray = {"hello", "am", "Stream", "see you again", "see you tomorrow"};
        List<String> list = Arrays.stream(strArray).limit(2).toList();
//        list.forEach(System.out::println);
        List<String> skipList = Arrays.stream(strArray).limit(2).skip(5).toList();
//        skipList.forEach(System.out::println);
    }

}
