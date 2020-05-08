package com.tedu.sp09.client.hystrix;

import com.tedu.sp01.pojo.Order;
import com.tedu.sp09.client.OrderFeignClient;
import com.tedu.web.util.JsonResult;

import org.springframework.stereotype.Component;

@Component
public class OrderFeignClientImpl implements OrderFeignClient {
    @Override
    public JsonResult<Order> getOrder(String orderId) {
        return JsonResult.err("无法获取商品订单");
    }

    @Override
    public JsonResult addOrder() {
        return JsonResult.err("无法保存订单");
    }
}
