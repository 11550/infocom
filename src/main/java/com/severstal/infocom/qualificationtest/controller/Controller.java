package com.severstal.infocom.qualificationtest.controller;

import com.severstal.infocom.qualificationtest.model.*;
import com.severstal.infocom.qualificationtest.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class Controller {
    private final PeriodService periodService;
    private final IFruitService<Apple> appleService;
    private final IFruitService<Pear> pearService;
    private final SupplierService supplierService;
    private final GoodsService goodsService;
    private final InvoicePositionService orderLineService;
    private final InvoiceService orderService;

    @GetMapping("/period/{id}")
    public ResponseEntity<Period> getPeriod(@PathVariable(name = "id") Period period) {
        return ResponseEntity.ok(period);
    }

    @GetMapping("/period/all")
    public ResponseEntity<List<Period>> getAllPeriods() {
        return ResponseEntity.ok(periodService.getAll());
    }

    @GetMapping("/apple/{id}")
    public ResponseEntity<Apple> getApple(@PathVariable(name = "id") Apple apple) {
        return ResponseEntity.ok(apple);
    }

    @GetMapping("/apple/all")
    public ResponseEntity<List<Apple>> getAllApples() {
        return ResponseEntity.ok(appleService.getAll());
    }

    @GetMapping("/pear/{id}")
    public ResponseEntity<Pear> getPear(@PathVariable(name = "id") Pear pear) {
        return ResponseEntity.ok(pear);
    }

    @GetMapping("/pear/all")
    public ResponseEntity<List<Pear>> getAllPears() {
        return ResponseEntity.ok(pearService.getAll());
    }

    @GetMapping("/supplier/{id}")
    public ResponseEntity<Supplier> getSupplier(@PathVariable(name = "id") Supplier supplier) {
        return ResponseEntity.ok(supplier);
    }

    @GetMapping("/supplier/all")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.getAll());
    }

    @GetMapping("/goods/{id}")
    public ResponseEntity<Goods> getGoods(@PathVariable(name = "id") Goods priceList) {
        return ResponseEntity.ok(priceList);
    }

    @GetMapping("/goods/all")
    public ResponseEntity<List<Goods>> getAllGoods() {
        return ResponseEntity.ok(goodsService.getAll());
    }

    @GetMapping("/order-line/{id}")
    public ResponseEntity<InvoicePosition> getOrderLine(@PathVariable(name = "id") InvoicePosition invoicePosition) {
        return ResponseEntity.ok(invoicePosition);
    }

    @GetMapping("/order-line/all")
    public ResponseEntity<List<InvoicePosition>> getAllOrderLines() {
        return ResponseEntity.ok(orderLineService.getAll());
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable(name = "id") Order order) {
        return ResponseEntity.ok(order);
    }

    @GetMapping("/order/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAll());
    }



    @PostMapping("/period")
    public ResponseEntity<Period> createPeriod(@RequestBody Period period) {
        return ResponseEntity.ok(period);
    }

    @PostMapping("/apple")
    public ResponseEntity<Apple> createApple(@RequestBody Apple apple) {
        return ResponseEntity.ok(appleService.create(apple));
    }

    @PostMapping("/pear")
    public ResponseEntity<Pear> createPear(@RequestBody Pear pear) {
        return ResponseEntity.ok(pear);
    }

    @PostMapping("/supplier")
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(supplier);
    }

    @PostMapping("/goods")
    public ResponseEntity<Goods> createGoods(@RequestBody Goods priceList) {
        return ResponseEntity.ok(priceList);
    }

    @PostMapping("/order-line")
    public ResponseEntity<InvoicePosition> createOrderLine(@RequestBody InvoicePosition invoicePosition) {
        return ResponseEntity.ok(invoicePosition);
    }

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(order);
    }
}
