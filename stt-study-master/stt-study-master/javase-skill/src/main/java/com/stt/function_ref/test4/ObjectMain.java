package com.stt.function_ref.test4;

/**
 * @date 石添
 * @date 2023/12/21
 */
public class ObjectMain {

    public static void main(String[] args) {

        // 1、匿名内部类实现
        IObjectInterface objectInterface1 = new IObjectInterface() {
            @Override
            public String getPersonName(Person person) {
                return person.getName();
            }
        };
        String innerResult = objectInterface1.getPersonName(new Person(1L, "InnerClass"));
        System.out.println("objectInterface1=====>" + innerResult);

        // Lambda写法
        IObjectInterface objectInterface2 = person -> person.getName();
        System.out.println("objectInterface2=====>" + objectInterface2.getPersonName(new Person(1L,"莫言")));

        // 方法引用写法
        IObjectInterface objectInterface3 = Person::getName;
        System.out.println("objectInterface3=====>" + objectInterface3.getPersonName(new Person(2L,"冰心")));
    }
}
