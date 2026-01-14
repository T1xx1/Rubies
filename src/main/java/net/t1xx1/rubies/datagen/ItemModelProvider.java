package net.t1xx1.rubies.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.t1xx1.rubies.Rubies;
import net.t1xx1.rubies.item.Items;

public class ItemModelProvider extends net.neoforged.neoforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Rubies.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(Items.RUBY.get());
    }
}
