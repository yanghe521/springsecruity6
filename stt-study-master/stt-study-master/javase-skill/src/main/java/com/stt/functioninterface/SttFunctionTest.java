package com.stt.functioninterface;

/**
 * @date 石添
 * @date 2023/12/18
 */
public class SttFunctionTest {
    public static void main(String[] args) {

        // 字符串拼接
        SttFunctionInterface<String,String,String> stt1 = new SttFunctionInterface<String, String, String>() {
            @Override
            public String fun1(String s, String s2) {
                System.out.println("s=========>" + s);
                System.out.println("s2=========>" + s2);
                return s.concat(s2);
            }
        };
        System.out.println(stt1.fun1("杨绛","我们仨"));

        // Lambda形式
        SttFunctionInterface<String,String,String> stt2 = (s1,s2) -> {
            System.out.println("s1=========>" + s1);
            System.out.println("s2=========>" + s2);
            return s1.concat(s2);
        };
        System.out.println(stt2.fun1("钱钟书","围城"));


    }
}
