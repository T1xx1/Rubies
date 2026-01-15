package net.t1xx1.rubies.tags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.t1xx1.rubies.Rubies;

public class ItemTags {
    private static TagKey<Item> createTag(String name) {
        return net.minecraft.tags.ItemTags.create(ResourceLocation.fromNamespaceAndPath(Rubies.MOD_ID, name));
    }

    public static final TagKey<Item> RUBY = createTag("ruby");
}