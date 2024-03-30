package com.stt.arraytolist;

import java.util.Arrays;
import java.util.List;

/**
 * @author 石添
 * @date 2023/12/13
 */
public class Test1 {

    public static void main(String[] args) {

        Integer[] arr = {1,2,3,4,5};
        // 转换为集合
        List<Integer> list = Arrays.asList(arr);
        // 此处的操作是读操作，获取长度，没有问题
        System.out.println("arr======>" + arr.length);
        System.out.println("list======>" + list.size());

        int[] arr2 = {1,2,3,4,5};
        // 返回的泛型，是数组类型【int[]\long[]】
        List<int[]> list2 = Arrays.asList(arr2);
        System.out.println("arr2======>" + arr2.length);
        // 此时返回的长度是1
        System.out.println("list2======>" + list2.size());
    }

}
