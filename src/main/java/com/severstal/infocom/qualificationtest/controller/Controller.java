package com.severstal.infocom.qualificationtest.controller;

import com.severstal.infocom.qualificationtest.model.*;
import com.severstal.infocom.qualificationtest.service.IFruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class Controller {
    private final IFruitService<Apple> appleService;
    private final IFruitService<Pear> pearService;

    @GetMapping("/apple/{id}")
    public ResponseEntity<Apple> getApple(@PathVariable(name = "id") Apple apple) {
        return ResponseEntity.ok(apple);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderLine> getOrder(@PathVariable(name = "id") OrderLine order) {
        return ResponseEntity.ok(order);
    }

    @GetMapping("/pear/{id}")
    public ResponseEntity<Pear> getPear(@PathVariable(name = "id") Pear pear) {
        return ResponseEntity.ok(pear);
    }

    @GetMapping("/period/{id}")
    public ResponseEntity<Period> getPeriod(@PathVariable(name = "id") Period period) {
        return ResponseEntity.ok(period);
    }

    @GetMapping("/price-list/{id}")
    public ResponseEntity<Goods> getPriceList(@PathVariable(name = "id") Goods priceList) {
        return ResponseEntity.ok(priceList);
    }

    @GetMapping("/supplier/{id}")
    public ResponseEntity<Supplier> getSupplier(@PathVariable(name = "id") Supplier supplier) {
        return ResponseEntity.ok(supplier);
    }



    @PostMapping("/apple")
    public ResponseEntity<Apple> createApple(@RequestBody Apple apple) {
        return ResponseEntity.ok(appleService.create(apple));
    }

    @PostMapping("/order")
    public ResponseEntity<OrderLine> createOrder(@RequestBody OrderLine order) {
        return ResponseEntity.ok(order);
    }

    @PostMapping("/pear")
    public ResponseEntity<Pear> createPear(@RequestBody Pear pear) {
        return ResponseEntity.ok(pear);
    }

    @PostMapping("/period")
    public ResponseEntity<Period> createPeriod(@RequestBody Period period) {
        return ResponseEntity.ok(period);
    }

    @PostMapping("/price-list")
    public ResponseEntity<Goods> createPriceList(@RequestBody Goods priceList) {
        return ResponseEntity.ok(priceList);
    }

    @PostMapping("/supplier")
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(supplier);
    }
}
