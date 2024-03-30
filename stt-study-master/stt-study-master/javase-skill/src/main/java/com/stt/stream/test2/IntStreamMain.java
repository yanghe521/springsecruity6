package com.stt.stream.test2;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @date 石添
 * @date 2023/12/26
 */
public class IntStreamMain {
    public static void main(String[] args) {
        // 定义数组
        String[] strArr = {"hello","am","Stream"};
        // 转换为流对象，使用 mapToInt 方法获取每一个字符串长度，返回的是IntStream类型的流
        IntStream intStream = Arrays.stream(strArr).mapToInt(String::length);
        // 调用sum方法计算和
        int sum =  intStream.sum();
        System.out.println(sum);
    }
}
