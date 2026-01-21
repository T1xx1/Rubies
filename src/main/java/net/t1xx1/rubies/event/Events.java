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

            trades.get(1).add((entity, randomSource) -> new MerchantOffer(new ItemCost(net.minecraft.world.item.Items.COAL, 20), new ItemStack(Items.RUBY.get(), 1), 16, 2, 0.05F));

            trades.get(2).add((entity, randomSource) -> new MerchantOffer(new ItemCost(net.minecraft.world.item.Items.IRON_INGOT, 6), new ItemStack(Items.RUBY.get(), 1), 12, 10, 0.2F));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(new ItemCost(net.minecraft.world.item.Items.DIAMOND, 2), new ItemStack(Items.RUBY.get(), 1), 12, 20, 0.05F));
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(new ItemCost(net.minecraft.world.item.Items.EMERALD, 1), new ItemStack(Items.RUBY.get(), 1), 12, 20, 0.05F));
        }

        if (event.getType() == VillagerProfession.BUTCHER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((entity, randomSource) -> new MerchantOffer(new ItemCost(net.minecraft.world.item.Items.CHICKEN, 18), new ItemStack(Items.RUBY.get(), 1), 16, 2, 0.05F));
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(new ItemCost(net.minecraft.world.item.Items.RABBIT, 4), new ItemStack(Items.RUBY.get(), 1), 16, 2, 0.05F));
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(new ItemCost(net.minecraft.world.item.Items.PORKCHOP, 9), new ItemStack(Items.RUBY.get(), 1), 16, 2, 0.05F));
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.RUBY.get(), 18), new ItemStack(net.minecraft.world.item.Items.RABBIT_STEW, 2), 12, 1, 0.05F));

            trades.get(2).add((entity, randomSource) -> new MerchantOffer(new ItemCost(net.minecraft.world.item.Items.COAL, 20), new ItemStack(Items.RUBY.get(), 1), 16, 2, 0.05F));
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.RUBY.get(), 1), new ItemStack(net.minecraft.world.item.Items.COOKED_CHICKEN, 10), 16, 5, 0.05F));
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(new ItemCost(Items.RUBY.get(), 1), new ItemStack(net.minecraft.world.item.Items.COOKED_PORKCHOP, 7), 16, 5, 0.05F));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(new ItemCost(net.minecraft.world.item.Items.BEEF, 12), new ItemStack(Items.RUBY.get(), 1), 16, 20, 0.05F));
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(new ItemCost(net.minecraft.world.item.Items.MUTTON, 10), new ItemStack(Items.RUBY.get(), 1), 16, 20, 0.05F));

            trades.get(4).add((entity, randomSource) -> new MerchantOffer(new ItemCost(net.minecraft.world.item.Items.DRIED_KELP, 12), new ItemStack(Items.RUBY.get(), 1), 12, 30, 0.05F));

            trades.get(5).add((entity, randomSource) -> new MerchantOffer(new ItemCost(net.minecraft.world.item.Items.SWEET_BERRIES, 12), new ItemStack(Items.RUBY.get(), 1), 12, 30, 0.05F));
        }
    }

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> commonTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        rareTrades.add(((entity, randomSource) ->  new MerchantOffer(new ItemCost(Items.RUBY.get(), 2), new ItemStack(Blocks.RUBY_BLOCK.get(), 1), 1, 3, 0.5F)));
    }
}
