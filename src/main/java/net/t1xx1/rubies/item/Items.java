package net.t1xx1.rubies.item;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.t1xx1.rubies.Rubies;

public class Items {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Rubies.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    /* */

    public static final DeferredItem<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(RUBY);
        }
    }
}