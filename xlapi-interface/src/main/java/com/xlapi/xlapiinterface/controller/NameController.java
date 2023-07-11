package com.xlapi.xlapiinterface.controller;


import com.xlapi.xlapiclientsdk.model.User;
import com.xlapi.xlapiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;



@RestController
@RequestMapping("/name")
public class NameController {
    @GetMapping("/")
    public String getNameByGet(String name){
        return "GET my name" + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name){
        return "POST my name" + name;
    }

    @PostMapping("/user")
    public String getUserNameByPost(@RequestBody User user, HttpServletRequest request){
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = request.getHeader("body");
        //todo 实际情况应该是去数据库查看是否已分配用户
        if(!accessKey.equals("cater")){
            throw new RuntimeException("无权限");
        }
        if(Long.parseLong(nonce) > 10000){
            throw new RuntimeException("无权限");
        }
        //todo 时间和当前时间不能超过5分钟

        //todo 实际情况中是从数据库中查出 secretKey
        String serverSign = SignUtils.genSign(body, "abcdefg");
        if(!sign.equals(serverSign)){
            throw new RuntimeException("无权限");
        }

        return "JSON Post your username:" + user.getUsername();
    }
}
