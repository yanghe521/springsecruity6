package com.stt.function_ref.test3;

/**
 * @date 石添
 * @date 2023/12/21
 */
public class ConstructorMain {

    public static void main(String[] args) {

//        IConstructorInterface p1 = new IConstructorInterface() {
//            @Override
//            public Person getPerson() {
//                return new Person();
//            }
//        };
//
//        // Lambda
//        IConstructorInterface p2 = () -> new Person();
//
//        // 方法引用
//        IConstructorInterface p3 = Person::new;
//        System.out.println("p1========>" + p1.getPerson());
//        System.out.println("p2========>" + p2.getPerson());
//        System.out.println("p3========>" + p3.getPerson());

        // 传参数怎么办,返回的对象有数据的
        IConstructorInterface p4 = Person::new;
        System.out.println(p4.getPerson2(2L,"余华"));
    }
}
