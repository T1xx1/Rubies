package net.t1xx1.rubies.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import net.t1xx1.rubies.Rubies;
import net.t1xx1.rubies.block.Blocks;
import net.t1xx1.rubies.item.Items;

import java.util.List;

@EventBusSubscriber(modid = Rubies.MOD_ID)
public class Events {
    @SubscribeEvent
    public static void addVillagerTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.ARMORER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.RUBY.get(), 1), new ItemStack(Blocks.RUBY_BLOCK.get(), 1), 2, 3, 0.05F));
        }
    }

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> commonTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        rareTrades.add(((entity, randomSource) ->  new MerchantOffer(new ItemCost(Items.RUBY.get(), 2), new ItemStack(Blocks.RUBY_BLOCK.get(), 1), 1, 3, 0.5F)));
    }
}
