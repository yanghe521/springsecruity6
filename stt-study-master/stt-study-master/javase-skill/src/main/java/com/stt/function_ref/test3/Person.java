package com.stt.function_ref.test3;

/**
 * @date 石添
 * @date 2023/12/21
 */
public class Person {

    private Long id;
    private String name;

    // 空参构造
    public Person() {
    }
    // 两个参数构造方法
    public Person(Long id,String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
