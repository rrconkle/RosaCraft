package com.rrconkle.rosacraft.block;

import com.rrconkle.rosacraft.block.custom.pepperblock;
import com.rrconkle.rosacraft.rosacraft;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ModBlocks {
	public static final Block ROSABLOCK = registerBlock("rosablock", new Block(QuiltBlockSettings.copyOf(Blocks.DIRT)));
	public static final Block TESTBLOCK = registerBlock("testblock", new Block(QuiltBlockSettings.copyOf(Blocks.COBBLESTONE)));
	public static final Block PEPPER_BLOCK = registerBlock("pepperblock", new pepperblock(QuiltBlockSettings.copyOf(Blocks.PUMPKIN).opaque(false)));
	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, new Identifier(rosacraft.MOD_ID, name), block);
	}
	private static Item registerBlockItem(String name, Block block) {
		return Registry.register(Registries.ITEM, new Identifier(rosacraft.MOD_ID, name),
			new BlockItem(block, new QuiltItemSettings()));
	}
	public static void registerModBlocks() {
		rosacraft.LOGGER.info("Registering ModBlocks");
	}
}
