package com.stt.test1;

import java.util.HashSet;

/**
 * @author 石添
 * @date 2023/12/12 22:11
 * 主角：Java自增 count++ 和 ++count，两者都是一元运算符【一个元素参与运算】，++就是 + 1
 * count++: 是后加加，也就是先返回值后做加法运算
 * ++count：先做运算再返回值
 * count++的原理： 将count值拷贝到临时变量区【值为0】，对原count值+1，并返回新的值
 * 循环代码步骤：count == count++
 * 1、JVM把count值（其值是0）拷贝到临时变量区。
 * 2、count值加1，这时候count的值是1。
 * 3、返回临时变量区的值，注意这个值是0，没修改过。
 * 4、返回值赋值给count，此时count值被重置成0。
 */
public class Autoincrement {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            //
            // count = count++;
            int temp = count;
            count = count + 1;
            count = temp;
            // i = i++;
        }
        System.out.println("count=====>" + count);

        // count = count++; 同等于

    }

}
