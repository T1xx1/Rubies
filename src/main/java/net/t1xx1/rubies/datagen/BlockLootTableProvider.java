package net.t1xx1.rubies.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.t1xx1.rubies.block.Blocks;
import net.t1xx1.rubies.item.Items;

import java.util.Set;

public class BlockLootTableProvider extends BlockLootSubProvider {
    protected BlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        add(Blocks.RUBY_ORE.get(), block -> createOreDrop(Blocks.RUBY_ORE.get(), Items.RUBY.get()));
        add(Blocks.DEEPSLATE_RUBY_ORE.get(), block -> createOreDrop(Blocks.DEEPSLATE_RUBY_ORE.get(), Items.RUBY.get()));
        dropSelf(Blocks.RUBY_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Blocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
