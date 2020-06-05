package com.service.price.controllers;

import java.util.List;

import com.service.price.models.Item;
import com.service.price.models.ItemPrice;
import com.service.price.services.itemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class mainController {
    @Autowired
    private itemService item_service;

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> getItems() {
        return new ResponseEntity<List<Item>>(item_service.getAllItems(), HttpStatus.OK);
    }

    @RequestMapping(value = "/item/unit", method = RequestMethod.PUT)
    public ResponseEntity<ItemPrice> getItemsPriceByUnits(@RequestBody Item itm) {
        return new ResponseEntity<ItemPrice>(item_service.getItemsPriceByUnits(itm), HttpStatus.OK);
    }

    @RequestMapping(value = "/item/crtn", method = RequestMethod.PUT)
    public ResponseEntity<ItemPrice> getItemsPriceByCarton(@RequestBody Item itm) {
        return new ResponseEntity<ItemPrice>(item_service.getItemsPriceByCartons(itm), HttpStatus.OK);
    }

}