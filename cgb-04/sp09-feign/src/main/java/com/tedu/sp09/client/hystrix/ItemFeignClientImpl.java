package com.tedu.sp09.client.hystrix;

import com.tedu.sp01.pojo.Item;
import com.tedu.sp09.client.ItemFeignClient;
import com.tedu.web.util.JsonResult;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ItemFeignClientImpl implements ItemFeignClient {
    @Override
    public JsonResult<List<Item>> getItems(String orderId) {
        return JsonResult.err("无法获取订单商品列表");
    }

    @Override
    public JsonResult decreaseNumber(List<Item> items) {
        return JsonResult.err("无法修改商品库存");
    }
}
