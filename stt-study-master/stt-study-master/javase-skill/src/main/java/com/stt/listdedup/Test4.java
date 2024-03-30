package com.stt.listdedup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

/**
 * @date 石添
 * @date 2023/12/14
 */
public class Test4 {

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

        // set去重
        TreeSet<String> set = new TreeSet<>(list);
        System.out.println(set);
    }
}
