package com.stt.listdedup;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 石添
 * @date 2023/12/14
 */
public class Test2 {

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

        for (int i = 0; i < list.size() - 1; i++) {
            // 内循环从后到外循环起始位置
            for (int j = list.size() - 1; j > i; j--) {
                // 内外循环当前元素相同就删除内循环的元素，因为它在后边，保障列表前半部分数据不重复
                if(list.get(j).equals(list.get(i))) {
                    // 删除
                    list.remove(j);
                }
            }
        }
        System.out.println("==================去重后集合==================");
        System.out.println(list);
    }
}
