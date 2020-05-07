package com.tedu.sp02.item.controller;

import com.tedu.sp01.pojo.Item;
import com.tedu.sp01.service.ItemService;
import com.tedu.web.util.JsonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ItemController {
    @Autowired
    private ItemService service;

    @Value("${server.port}")
    private int port;

    @GetMapping("/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId) throws Exception {
        log.info("server.port = " + port + ", orderId = " + orderId);

        //设置随机延迟
        long t = new Random().nextInt(5000);
        if (Math.random() < .6) {
            log.info("item-service - " + port + " - 暂停 " + t);
            Thread.sleep(t);
        }
        //
        List<Item> items = service.getItems(orderId);
        return JsonResult.ok(items).msg("port = " + port);
    }

    @PostMapping("/decreaseNumber")
    public JsonResult decreaseNumber(@RequestBody List<Item> items) {
        service.decreaseNumbers(items);
        return JsonResult.ok();
    }
}
