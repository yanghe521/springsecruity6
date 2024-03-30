package com.stt.listdedup;

import com.stt.listdedup.entity.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @date 石添
 * @date 2023/12/14
 */
public class Test8 {
    public static void main(String[] args) {
        // 1、创建原始集合
        List<Book> list = new ArrayList<>();
        list.add(new Book(1L,"我与地坛","文学"));
        list.add(new Book(2L,"生死疲劳","文学"));
        list.add(new Book(3L,"一地鸡毛","文学"));
        list.add(new Book(4L,"明朝那些事儿","历史"));
        list.add(new Book(5L,"长安的荔枝","历史"));
        list.add(new Book(6L,"高效能人士的七个习惯","成功学"));
        list.add(new Book(7L,"励志生存","成功学"));

        // 不感兴趣的书籍类型
        List<String> indiffTypeList = Arrays.asList("成功学","心理");

        List<Book> books = list.stream().filter(item -> !indiffTypeList.contains(item.getType())).collect(Collectors.toList());
        System.out.println("books=======>" + books);
    }
}
