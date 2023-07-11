package com.xlapi.xlapiinterface;

import com.xlapi.xlapiclientsdk.client.XlApiClient;
import com.xlapi.xlapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class XlapiInterfaceApplicationTests {

    @Resource
    private XlApiClient xlApiClient;
    @Test
    void contextLoads() {
        String xl = xlApiClient.getNameByGet("xl");
        User user = new User();
        user.setUsername("xla");
        String userNameByPost = xlApiClient.getUserNameByPost(user);
        System.out.println(xl);
        System.out.println(userNameByPost);
    }

}
