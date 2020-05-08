package com.tedu.sp09.controller;

import com.tedu.sp01.pojo.Item;
import com.tedu.sp01.pojo.Order;
import com.tedu.sp01.pojo.User;
import com.tedu.sp09.client.ItemFeignClient;
import com.tedu.sp09.client.OrderFeignClient;
import com.tedu.sp09.client.UserFeignClient;
import com.tedu.web.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by LJZ.
 * User: UID
 * Date:2020/5/8
 * Time: 19:47
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class FeignController {
    @Autowired
    private ItemFeignClient iClient;
    @Autowired
    private UserFeignClient uClient;
    @Autowired
    private OrderFeignClient oClient;

    //item
    @GetMapping("/item-service/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
        return iClient.getItems(orderId);
    }

    @PostMapping("/item-service/decreaseNumber")
    public JsonResult decreaseNumber(@RequestBody List<Item> items) {
        return iClient.decreaseNumber(items);
    }

    //user
    @GetMapping("/user-service/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId) {
        return uClient.getUser(userId);
    }

    @GetMapping("/user-service/{userId}/score")
    public JsonResult addScore(@PathVariable Integer userId, @RequestParam Integer score) {
        return uClient.addScore(userId, score);
    }

    //order
    @GetMapping("/order-service/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable String orderId) {
        return oClient.getOrder(orderId);
    }

    @GetMapping("/order-service")
    public JsonResult addOrder() {
        return oClient.addOrder();
    }
}
