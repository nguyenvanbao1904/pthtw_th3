package com.nvb.repositories;

import com.nvb.pojo.Cart;

import java.util.List;

public interface ReceiptRepository {
    void addReceipt(List<Cart> carts);
}
