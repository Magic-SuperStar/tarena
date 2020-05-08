package com.tedu.sp09.client.hystrix;

import com.tedu.sp01.pojo.User;
import com.tedu.sp09.client.UserFeignClient;
import com.tedu.web.util.JsonResult;

import org.springframework.stereotype.Component;

@Component
public class UserFeignClientImpl implements UserFeignClient {
    @Override
    public JsonResult<User> getUser(Integer userId) {
        return JsonResult.err("无法获取用户信息");
    }

    @Override
    public JsonResult addScore(Integer userId, Integer score) {
        return JsonResult.err("无法增加用户积分");
    }
}
