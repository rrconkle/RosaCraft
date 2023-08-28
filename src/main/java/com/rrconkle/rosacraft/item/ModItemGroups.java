package com.rrconkle.rosacraft.item;

import com.rrconkle.rosacraft.rosacraft;
import com.rrconkle.rosacraft.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
	//public static final ItemGroup ROSA_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(TestMod.MOD_ID, "rosa"),
	//	FabricItemGroup.builder().name(Text.translatable("itemgroup.rosa"))
	//		.icon(() -> new ItemStack(ModItems.ROSA)).entries());
	public static ItemGroup ROSA_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier("rosacraft.rosagroup", "rosa"),
		FabricItemGroup.builder().name(Text.translatable("itemgroup.rosagroup"))
			.icon(() -> new ItemStack(ModItems.ROSA)).entries((displayContext, entries) -> {
				entries.addItem(ModItems.ROSA);
				entries.addItem(ModBlocks.ROSABLOCK);
				entries.addItem(ModBlocks.TESTBLOCK);
				entries.addItem(ModItems.TESTITEM);
				entries.addItem(ModBlocks.PEPPER_BLOCK);
				entries.addItem(ModItems.PEPPER);
			}).build());

	public static void registerItemGroups() {
		rosacraft.LOGGER.info("Registering Item Groups for " + rosacraft.MOD_ID);
	}
}
