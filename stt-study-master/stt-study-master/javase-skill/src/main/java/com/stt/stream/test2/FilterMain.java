package com.stt.stream.test2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @date 石添
 * @date 2023/12/26
 */
public class FilterMain {
    public static void main(String[] args) {
        // 定义数组
        String[] strArr = {"hello","am","Stream","see you again","see you tomorrow"};
        Stream<String> stringStream = Arrays.stream(strArr).filter(item -> item.length() > 5);
        List<String> list = stringStream.toList();
        list.forEach(System.out::println);
    }
}
