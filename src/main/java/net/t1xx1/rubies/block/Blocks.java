package net.t1xx1.rubies.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.t1xx1.rubies.Rubies;
import net.t1xx1.rubies.item.Items;

import java.util.function.Supplier;

public class Blocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Rubies.MODID);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    /* */

    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> b = BLOCKS.register(name, block);

        /* register block item */
        Items.ITEMS.register(name, () -> new BlockItem(b.get(), new Item.Properties()));

        return b;
    }

    public static final DeferredBlock<Block> RUBY_ORE = registerBlock("ruby_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
    public static final DeferredBlock<Block> RUBY_BLOCK = registerBlock("ruby_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).instrument(NoteBlockInstrument.BIT).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(RUBY_BLOCK);
        }

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(RUBY_ORE);
        }
    }
}
