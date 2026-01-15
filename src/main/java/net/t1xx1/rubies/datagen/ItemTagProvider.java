package net.t1xx1.rubies.datagen;

import net.t1xx1.rubies.Rubies;
import net.t1xx1.rubies.block.Blocks;
import net.t1xx1.rubies.item.Items;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.t1xx1.rubies.tags.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends ItemTagsProvider {
    public ItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Rubies.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.RUBY)
                .add(Items.RUBY.get())
                .add(Blocks.RUBY_ORE.asItem())
                .add(Blocks.DEEPSLATE_RUBY_ORE.asItem())
                .add(Blocks.RUBY_BLOCK.asItem());

        this.tag(net.minecraft.tags.ItemTags.TRIM_MATERIALS)
                .add(Items.RUBY.get());
    }
}