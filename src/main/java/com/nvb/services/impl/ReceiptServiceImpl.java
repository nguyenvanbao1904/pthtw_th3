package com.nvb.services.impl;

import com.nvb.pojo.Cart;
import com.nvb.repositories.ReceiptRepository;
import com.nvb.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Override
    public void addReceipt(List<Cart> carts) {
        receiptRepository.addReceipt(carts);
    }
}
