package com.stt.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 石添
 * @date 2023/12/17
 */
public class PersonTest {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("李小白",24));
        personList.add(new Person("张二三",21));
        personList.add(new Person("王五六",30));

        // 遍历
        System.out.println("排序前-------------------");
        personList.forEach(person -> System.out.println(person));

        // 比较
        personList.sort((o1,o2) -> o1.getAge() - o2.getAge());
        System.out.println("排序后-------------------");
        personList.forEach(person -> System.out.println(person));
    }
}
