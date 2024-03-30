package com.stt.functioninterface;

@FunctionalInterface
public interface SttFunctionInterface<T,R,V> {

    V fun1(T t,R r);

    default T fun2(T t,R r) {
        return t;
    }
}
