package com.stt.function_ref.test2;

/**
 * @date 石添
 * @date 2023/12/21
 */
public class PersonMain {

    public static void main(String[] args) {


        Person person = new Person(1L, "石添");
        IInstanceMethod p1 = new IInstanceMethod() {
            @Override
            public String getPersonName() {
                return person.getName();
            }
        };
        System.out.println(p1.getPersonName());
        // Lambda
        IInstanceMethod p2 = () -> person.getName();
        System.out.println(p2.getPersonName());

        // 方法引用
        IInstanceMethod p3 = person::getName;
        System.out.println(p3.getPersonName());



    }
}
