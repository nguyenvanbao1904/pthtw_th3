package com.nvb.controllers;

import com.nvb.pojo.Cart;
import com.nvb.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiReceiptController {
    @Autowired
    private ReceiptService receiptService;

    @PostMapping("/receipts")
    @ResponseStatus(HttpStatus.CREATED)
    public void addReceipt(@RequestBody List<Cart> carts) {
        this.receiptService.addReceipt(carts);
    }
}
