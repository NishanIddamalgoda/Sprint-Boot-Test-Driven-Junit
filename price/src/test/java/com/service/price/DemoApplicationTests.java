package com.service.price;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import com.service.price.models.Item;
import com.service.price.models.ItemPrice;
import com.service.price.services.itemService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private itemService itmservice;

	@Test
	public void testGetAllItems() {
		List<Item> itm = new ArrayList<Item>();
		itm = itmservice.getAllItems();
		assertFalse(itm.isEmpty());
	}

	@Test
	public void testItemPriceByUnit() {
		Item itm = new Item();
		itm.setItem_name("Penguin-ears");
		itm.setCarton_price(175);
		itm.setUnits_p_carton(20);
		itm.setCarton_dicnt_qty(3);
		itm.setCarton_dicnt_percnt(10);
		itm.setSingle_unit_increment(1.3);
		itm.setCurrent_selected_units(28);
		itm.setCurrent_selection_total(0);

		ItemPrice itmPric = itmservice.getItemsPriceByUnits(itm);

		assertEquals(itmPric.total_price, 266);
	}

	@Test
	public void testItemPriceByCarton() {
		Item itm = new Item();
		itm.setItem_name("Penguin-ears");
		itm.setCarton_price(175);
		itm.setUnits_p_carton(20);
		itm.setCarton_dicnt_qty(3);
		itm.setCarton_dicnt_percnt(10);
		itm.setSingle_unit_increment(1.3);
		itm.setCurrent_selected_units(6);
		itm.setCurrent_selection_total(0);

		ItemPrice itmPric = itmservice.getItemsPriceByCartons(itm);

		assertEquals(itmPric.total_price, 945);
	}

}
