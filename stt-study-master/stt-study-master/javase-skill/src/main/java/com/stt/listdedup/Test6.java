package com.stt.listdedup;

import com.stt.listdedup.entity.Driver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @date 石添
 * @date 2023/12/14
 */
public class Test6 {

    public static void main(String[] args) {
        List<Driver> list = new ArrayList<>();
        list.add(new Driver(1L, "张三", "111111"));
        list.add(new Driver(2L,"离思","222222"));
        list.add(new Driver(3L,"王武","111111"));
        list.add(new Driver(4L,"赵六","444444"));
        list.add(new Driver(5L,"武七","555555"));
        HashSet<Driver> set = new HashSet<>(list);
        System.out.println(set);
    }
}
