package com.stt.listdedup;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 石添
 * @date 2023/12/14
 */
public class Test3 {

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
        // 拷贝新的集合
        List<String> newList = new ArrayList<>(list);
        for (String item : list) {
            if(newList.indexOf(item) != newList.lastIndexOf(item)) {
                newList.remove(newList.lastIndexOf(item));
            }
        }
        System.out.println("newList===========>" + newList);
    }
}
