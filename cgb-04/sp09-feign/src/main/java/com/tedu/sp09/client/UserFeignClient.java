package com.tedu.sp09.client;

import com.tedu.sp01.pojo.User;
import com.tedu.web.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by LJZ.
 * User: UID
 * Date:2020/5/8
 * Time: 19:40
 * To change this template use File | Settings | File Templates.
 */
@FeignClient(name = "user-service")
public interface UserFeignClient {
    @GetMapping("/{userId}")
    JsonResult<User> getUser(Integer userId);

    @GetMapping("/{userId}/score")
    JsonResult addScore(@PathVariable Integer userId, @RequestParam Integer score);
}
