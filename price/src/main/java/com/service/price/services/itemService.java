package com.service.price.services;

import com.service.price.repository.itemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.service.price.models.Item;
import com.service.price.models.ItemPrice;

@Service
public class itemService {
    @Autowired
    itemRepository itemRepo;

    public List<Item> getAllItems() {
        List<Item> item_list = itemRepo.findAll();
        if (item_list.size() > 0) {
            return item_list;
        } else {
            return new ArrayList<Item>();
        }
    }

    // calculate price considering number of units
    public ItemPrice getItemsPriceByUnits(Item itm) {
        ItemPrice itmPrice = new ItemPrice();
        itmPrice.calculateTotalByUnits(itm);
        return itmPrice;
    }

    // calculate price considering number of cartons
    public ItemPrice getItemsPriceByCartons(Item itm) {
        ItemPrice itmPrice = new ItemPrice();
        itmPrice.calculateTotalByCarton(itm);
        return itmPrice;
    }
}