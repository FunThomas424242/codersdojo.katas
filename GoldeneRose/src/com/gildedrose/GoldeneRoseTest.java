package com.gildedrose;
import static org.junit.Assert.*;

import org.junit.Test;

public class GoldeneRoseTest {

	@Test
	public void foo() {
		Item[] items = new Item[] { new Item("foo", 0, 0) };
		GoldeneRose app = new GoldeneRose(items);
		app.updateQuality();
		assertEquals("fixme", app.items[0].name);
	}
}