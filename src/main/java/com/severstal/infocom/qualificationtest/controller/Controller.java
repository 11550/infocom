package com.severstal.infocom.qualificationtest.controller;

import com.severstal.infocom.qualificationtest.model.*;
import com.severstal.infocom.qualificationtest.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    private final InvoicePositionService invoicePositionService;
    private final InvoiceService invoiceService;

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

    @GetMapping("/invoice-position/{id}")
    public ResponseEntity<InvoicePosition> getInvoicePosition(@PathVariable(name = "id") InvoicePosition invoicePosition) {
        return ResponseEntity.ok(invoicePosition);
    }

    @GetMapping("/invoice-position/all")
    public ResponseEntity<List<InvoicePosition>> getAllInvoicePositions() {
        return ResponseEntity.ok(invoicePositionService.getAll());
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Invoice> getOrder(@PathVariable(name = "id") Invoice invoice) {
        return ResponseEntity.ok(invoice);
    }

    @GetMapping("/order/all")
    public ResponseEntity<List<Invoice>> getAllOrders() {
        return ResponseEntity.ok(invoiceService.getAll());
    }



    @PostMapping("/period")
    public ResponseEntity<Period> createPeriod(@RequestBody Period period) {
        return ResponseEntity.ok(periodService.create(period));
    }

    @PostMapping("/apple")
    public ResponseEntity<Apple> createApple(@RequestBody Apple apple) {
        return ResponseEntity.ok(appleService.create(apple));
    }

    @PostMapping("/pear")
    public ResponseEntity<Pear> createPear(@RequestBody Pear pear) {
        return ResponseEntity.ok(pearService.create(pear));
    }

    @PostMapping("/supplier")
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(supplierService.create(supplier));
    }

    @PostMapping("/goods")
    public ResponseEntity<Goods> createGoods(@RequestBody Goods goods) {
        return ResponseEntity.ok(goodsService.create(goods));
    }

    @PostMapping("/invoice_position")
    public ResponseEntity<InvoicePosition> createInvoicePosition(@RequestBody InvoicePosition invoicePosition) {
        return ResponseEntity.ok(invoicePositionService.create(invoicePosition));
    }

    @PostMapping("/invoice")
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        return ResponseEntity.ok(invoiceService.create(invoice));
    }
}
