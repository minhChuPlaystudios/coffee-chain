package com.example.shop.controller;

import com.example.dto.order.OrderRequestDto;
import com.example.shop.entity.Shop;
import com.example.shop.service.ShopService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * @author minh.chu
 * @since 19/09/2023
 */
@RestController
@RequestMapping("/shops")
public class ShopController {

    private ShopService shopService;

    private RabbitTemplate rabbitTemplate;

    @GetMapping("/findNearby")
    public ResponseEntity<Collection<Shop>> findNearby(@RequestParam("lat") double lat, @RequestParam("lng") double lng) {
        return new ResponseEntity<>(shopService.findShopNearBy(new Point(lat, lng)), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Collection<Shop>> getShops() {
        return new ResponseEntity<>(shopService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{shopId}")
    public ResponseEntity<Shop> getShop(@PathVariable String shopId) {
        return new ResponseEntity<>(shopService.findShopById(shopId), HttpStatus.OK);
    }

    @PostMapping("/{shopId}/orders")
    public ResponseEntity<Map<String, String>> order(@PathVariable String shopId, @RequestBody OrderRequestDto orderRequestDto) {
        // TODO: Send message to Message broder
        rabbitTemplate.convertAndSend("orderExchange", "orderRequest", orderRequestDto);

        return new ResponseEntity<>(Collections.singletonMap("status", "success"), HttpStatus.OK);
    }


    @Autowired
    public void setShopService(ShopService shopService) {
        this.shopService = shopService;
    }

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
}
