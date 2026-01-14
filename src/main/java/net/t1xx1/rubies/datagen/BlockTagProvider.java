package net.t1xx1.rubies.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.t1xx1.rubies.Rubies;
import net.t1xx1.rubies.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends BlockTagsProvider {
    public BlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Rubies.MODID, existingFileHelper);
    }

    public void mineableWithIronPickaxe(Block block) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        tag(BlockTags.NEEDS_IRON_TOOL).add(block);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        mineableWithIronPickaxe(Blocks.RUBY_ORE.get());
        mineableWithIronPickaxe(Blocks.DEEPSLATE_RUBY_ORE.get());
        mineableWithIronPickaxe(Blocks.RUBY_BLOCK.get());
    }
}
