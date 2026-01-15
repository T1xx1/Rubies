package net.t1xx1.rubies.trim;

import net.t1xx1.rubies.Rubies;
import net.t1xx1.rubies.item.Items;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;

import java.util.Map;

public class TrimMaterials {
    public static final ResourceKey<TrimMaterial> RUBY = ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(Rubies.MOD_ID, "ruby"));

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> trimKey, Item item, Style style, float itemModelIndex) {
        TrimMaterial trimmaterial = TrimMaterial.create(trimKey.location().getPath(), item, itemModelIndex, Component.translatable(Util.makeDescriptionId("trim_material", trimKey.location())).withStyle(style), Map.of());

        context.register(trimKey, trimmaterial);
    }

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, RUBY, Items.RUBY.get(), Style.EMPTY.withColor(TextColor.parseColor("#A01136").getOrThrow()), 0.4F);
    }
}