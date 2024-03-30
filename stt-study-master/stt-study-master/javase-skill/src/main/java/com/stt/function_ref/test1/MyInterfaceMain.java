package com.stt.function_ref.test1;

/**
 * @date 石添
 * @date 2023/12/21
 */
public class MyInterfaceMain {

    public static void main(String[] args) {
        // 通过Lambda表达式实现
        MyInterface fun1 = new MyInterface() {
            @Override
            public String get(String str) {
                String upperCase = str.toUpperCase();

                // 调用静态方法
                StaticMethod.method1(upperCase);
                return upperCase;
            }
        };
        fun1.get("hello");

        // 通过Lambda方式
        MyInterface fun2 = (str) -> {
            String upperCase = str.toUpperCase();
            // 调用静态方法
            StaticMethod.method1(upperCase);
            return upperCase;
        };
        fun2.get("lambda");

        // 静态方法引用
        MyInterface fun3 = StaticMethod::method1;
        String ref = fun3.get("static method ref");
        System.out.println("ref==========>" + ref);
    }
}
