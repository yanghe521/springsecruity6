package com.stt.function_ref.test4;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 石添
 * @date 2023/12/21
 */
public class ListMain {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("杰克！");
        list.add("艾斯！");
        list.add("雷欧！");
        list.add("银河！");
        // 输出
        list.forEach(System.out::print);
    }
}
