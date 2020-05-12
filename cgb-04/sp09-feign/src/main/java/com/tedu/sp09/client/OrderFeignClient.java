package com.tedu.sp09.client;

import com.tedu.sp01.pojo.Order;
import com.tedu.web.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.tedu.sp09.client.hystrix.*;

/**
 * Created by LJZ.
 * User: UID
 * Date:2020/5/8
 * Time: 19:44
 * To change this template use File | Settings | File Templates.
 */
@FeignClient(name = "order-service",fallback = OrderFeignClientImpl.class)
public interface OrderFeignClient {
    @GetMapping("/{orderId}")
    JsonResult<Order> getOrder(@PathVariable String orderId);
    @GetMapping("/")
    JsonResult addOrder();
}
