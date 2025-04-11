package com.nvb.services;

import com.nvb.pojo.Cart;

import java.util.List;

public interface ReceiptService {
    void addReceipt(List<Cart> carts);
}
