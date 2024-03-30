package com.stt.listdedup;

import java.util.*;

/**
 * @date 石添
 * @date 2023/12/14
 */
public class Test5 {

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

        Set<String> set = new LinkedHashSet<>(list);
        List<String> finalList = new ArrayList<>(set);

        System.out.println("==================去重后集合==================");
        System.out.println(finalList);
        System.out.println(set);
    }
}
