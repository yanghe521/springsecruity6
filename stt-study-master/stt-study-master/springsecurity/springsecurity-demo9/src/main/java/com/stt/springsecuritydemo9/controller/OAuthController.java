package com.stt.springsecuritydemo9.controller;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONParser;
import cn.hutool.json.JSONUtil;
import com.stt.springsecuritydemo9.domain.emtity.GiteeBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("oauth")
public class OAuthController {

    // gitee的回调
    @GetMapping("notify")
    public String gitee(@RequestParam("code") String code) {
        // 获取token
        Map<String ,Object> map = new HashMap<>();
        map.put("grant_type","authorization_code");
        map.put("code",code);
        map.put("client_id","2b6d84c6dde313dc3c85c0693182e3cd8319f94ab31ef0beb56d01c149f8b4ce");
        map.put("redirect_uri","http://localhost:8080/oauth/notify");
        map.put("client_secret","d1d1eb6c4ba0098da76c08e6339f3f31122dad8527ea50b25238d42c446e0122");
        // https://gitee.com/oauth/token?grant_type=authorization_code&code={code}&client_id={client_id}&redirect_uri={redirect_uri}&client_secret={client_secret}
        // 通过code获取access_token
        String post = HttpUtil.post("https://gitee.com/oauth/token", map);
        System.out.println("post==========>" + post);
        // 根据access token获取用户信息，调用openApi
        GiteeBody giteeBody = JSONUtil.toBean(post, GiteeBody.class);
        System.out.println("giteeBody=-====>" + giteeBody.getAccessToken());
        String userInfo = HttpUtil.get("https://gitee.com/api/v5/user?access_token=" + giteeBody.getAccessToken());
        String name = (String)JSONUtil.parseObj(userInfo).get("name");
        System.out.println("用户名===》" + name);
        return name;
    }
}
