package net.fluxed.beginning.util;

import net.fluxed.beginning.TheBeginning;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_MODULARIUM_TOOL = createTag("needs_modularium_tool");
        public static final TagKey<Block> INCORRECT_FOR_MODULARIUM_TOOL = createTag("incorrect_for_modularium_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(Identifier.fromNamespaceAndPath(TheBeginning.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> MODULARIUM_REPAIRABLE = createTag("modularium_repairable");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(TheBeginning.MOD_ID, name));
        }
    }

}
