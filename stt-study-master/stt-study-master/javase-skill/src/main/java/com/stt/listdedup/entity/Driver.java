package com.stt.listdedup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

/**
 * @date 石添
 * @date 2023/12/14
 */
@Data
@AllArgsConstructor
public class Driver {

    private long id;
    // 姓名
    private String name;
    // 身份证号码
    private String idNumber;

    // hashCode值一样调用equals方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return idNumber.equals(driver.getIdNumber());
    }
    // 先运行hashcode方法
    @Override
    public int hashCode() {
        return Objects.hash(idNumber);
    }
}
