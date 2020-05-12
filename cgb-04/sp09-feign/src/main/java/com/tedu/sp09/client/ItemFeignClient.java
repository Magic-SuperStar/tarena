package com.tedu.sp09.client;

import com.tedu.sp01.pojo.Item;
import com.tedu.web.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.tedu.sp09.client.hystrix.*;

import java.util.List;

/**
 * Created by LJZ.
 * User: UID
 * Date:2020/5/8
 * Time: 19:27
 * To change this template use File | Settings | File Templates.
 */
@FeignClient(name = "item-service",fallback = ItemFeignClientImpl.class)
public interface ItemFeignClient {
    @GetMapping("/{orderId}")
    JsonResult<List<Item>> getItems(@PathVariable String orderId);

    @PostMapping("/decreaseNumber")
    JsonResult decreaseNumber(@RequestBody List<Item> items);
}
