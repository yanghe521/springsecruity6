package com.stt.springsecuritydemo3.controller;

import com.stt.springsecuritydemo3.MyUser;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("hasAuthority('aaa')")
public class TestController {

    @GetMapping("test1")
    public String test1() {

        return "SpringSecurity - demo3 - test1";
    }

    /**
     * 测试 @PreAuthorize注解
     * 作用：使用类或者方法上，拥有指定的权限才可以访问
     * String类型的参数：语法是Spring的EL表达式
     * 有权限：test1:show权限
     * hasRole: 回去匹配authorities，但是会在hasRole的参数前加一个ROLE_前缀，所以在定义权限的时候需要将ROLE_前缀
     * role和authorities关系是：role是一种复杂的写法，有ROLE_前缀，authorities是role的简化写法
     */
//    @PreAuthorize("hasRole('test1:show')")
    @PreAuthorize("hasAuthority('test1:show') || hasRole('admin')")
    @GetMapping("pre/test")
    public String preTest() {
        System.out.println("preTest==========>");
        return "preTest";
    }

    /**
     *
     * @PostAuthorize：方法返回时的校验，返回用户名，如果用户名的长度大于3位认为是合法的
     * returnObject：是固定写法，就是返回值对象了
     */
    @PreAuthorize("hasAuthority('user:name')")
    @PostAuthorize("returnObject.length() > 3")
    @GetMapping("post/authorize")
    public String postAuthorize() {
        System.out.println("获取用户名");
        return "小张小张";
    }

    /**
     * @PostFilter：过滤符合条件的数据返回
     */
    @PostFilter("filterObject.length() > 3")
    @GetMapping("user/list")
    public List<String> userList() {

        System.out.println("返回用户名");
        List<String> userList = new ArrayList<>();
        userList.add("提莫");
        userList.add("卑尔维斯");
        userList.add("三个字");

        return userList;
    }

    /**
     * @PreFilter：筛选掉符合条件的数据，数据必须是Collection、map、Array【数组】
     * 名字超过3位的才接收
     */
    @PreFilter(value = "filterObject.username.length() > 3")
    @PostMapping("user")
    public List<MyUser> addUser(@RequestBody List<MyUser> userList) {
        for (MyUser myUser : userList) {
            System.out.println("username==========》" + myUser.getUsername());
        }
        return userList;
    }

    @PreFilter(value = "filterObject.length() > 3")
    @PostMapping("user/name")
    public String addUser(@RequestBody String name) {
        System.out.println("========>" + name);
        return name;
    }
}
