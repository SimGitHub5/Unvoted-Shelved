package com.cursedcauldron.unvotedandshelved.core.registries;

import com.cursedcauldron.unvotedandshelved.common.blocks.CopperButtonBlock;
import com.cursedcauldron.unvotedandshelved.core.UnvotedAndShelved;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.concurrent.ConcurrentHashMap;

public class USBlocks {
    private static final ConcurrentHashMap<Identifier, Block> BLOCKS = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Identifier, Item> ITEMS = new ConcurrentHashMap<>();

    public static final Block COPPER_BUTTON = registerBlock("copper_button", new CopperButtonBlock(AbstractBlock.Settings.of(Material.DECORATION).noCollision().strength(0.5F).sounds(BlockSoundGroup.COPPER)), ItemGroup.REDSTONE);

    public static <B extends Block> B registerBlock(String name, B block, ItemGroup group) {
        BLOCKS.put(UnvotedAndShelved.ID(name), block);
        ITEMS.put(UnvotedAndShelved.ID(name), new BlockItem(block, new Item.Settings().group(group)));
        return block;
    }

    public static void register() {
        for (Identifier id : BLOCKS.keySet()) {
            Registry.register(Registry.BLOCK, id, BLOCKS.get(id));
        }
        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }
    }

}
