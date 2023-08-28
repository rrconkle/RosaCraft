package com.example.example_mod.item;

import com.example.example_mod.TestMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ModItems {
	public static final Item TESTITEM = registerItem("testitem", new Item(new QuiltItemSettings()));
	public static final Item ROSA = registerItem("rosa", new Item(new QuiltItemSettings()));
	//public static final Item ROSABLOCK = registerItem("rosa_block", new Item(new QuiltItemSettings()));
	private static void addItemsToIngrediantItemGroup(FabricItemGroupEntries entries) {
		//entries.addItem(TESTITEM);
		//entries.addItem(ROSA);
	}

	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);
	}
	public static void registerModItems() {
		TestMod.LOGGER.info("Registering Mod Items " + TestMod.MOD_ID);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngrediantItemGroup);
	}
}
