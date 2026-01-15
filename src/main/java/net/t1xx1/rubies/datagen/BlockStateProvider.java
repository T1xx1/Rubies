package net.t1xx1.rubies.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.t1xx1.rubies.Rubies;
import net.t1xx1.rubies.block.Blocks;

public class BlockStateProvider extends net.neoforged.neoforge.client.model.generators.BlockStateProvider {
    public BlockStateProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, Rubies.MOD_ID, existingFileHelper);
    }

    private void block(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    @Override
    protected void registerStatesAndModels() {
        block(Blocks.RUBY_ORE);
        block(Blocks.DEEPSLATE_RUBY_ORE);
        block(Blocks.RUBY_BLOCK);
    }
}
