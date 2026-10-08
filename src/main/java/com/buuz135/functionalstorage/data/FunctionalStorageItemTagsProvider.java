package com.buuz135.functionalstorage.data;

import com.buuz135.functionalstorage.FunctionalStorage;
import com.buuz135.functionalstorage.util.StorageTags;
import com.hrznstudio.titanium.module.BlockWithTile;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class FunctionalStorageItemTagsProvider extends ItemTagsProvider {


    public FunctionalStorageItemTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId) {
        super(packOutput, lookupProvider, modId);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider p_256380_) {
        var tTagAppender = this.tag(StorageTags.DRAWER);
        for (FunctionalStorage.DrawerType drawerType : FunctionalStorage.DRAWER_TYPES.keySet()) {
            FunctionalStorage.DRAWER_TYPES.get(drawerType).stream().map(BlockWithTile::block)
                    .forEach(ho -> tTagAppender.add(BuiltInRegistries.ITEM.wrapAsHolder(ho.get().asItem()).key()));
        }
        for (FunctionalStorage.DrawerType drawerType : FunctionalStorage.DRAWER_TYPES.keySet()) {
            var byTypeAppender = this.tag(drawerType.getTag());
            FunctionalStorage.DRAWER_TYPES.get(drawerType).stream().map(BlockWithTile::block)
                    .forEach(ho -> byTypeAppender.add(BuiltInRegistries.ITEM.wrapAsHolder(ho.get().asItem()).key()));
        }
        this.tag(FunctionalStorage.DrawerType.X_1.getTag()).add(BuiltInRegistries.ITEM.wrapAsHolder(FunctionalStorage.FLUID_DRAWER_1.getBlock().asItem()).key());
        this.tag(FunctionalStorage.DrawerType.X_2.getTag()).add(BuiltInRegistries.ITEM.wrapAsHolder(FunctionalStorage.FLUID_DRAWER_2.getBlock().asItem()).key());
        this.tag(FunctionalStorage.DrawerType.X_4.getTag()).add(BuiltInRegistries.ITEM.wrapAsHolder(FunctionalStorage.FLUID_DRAWER_4.getBlock().asItem()).key());
        this.tag(StorageTags.FLUID_DRAWER).add(BuiltInRegistries.ITEM.wrapAsHolder(FunctionalStorage.FLUID_DRAWER_1.getBlock().asItem()).key(), BuiltInRegistries.ITEM.wrapAsHolder(FunctionalStorage.FLUID_DRAWER_2.getBlock().asItem()).key(), BuiltInRegistries.ITEM.wrapAsHolder(FunctionalStorage.FLUID_DRAWER_4.getBlock().asItem()).key());
        this.tag(StorageTags.ARMORY_CABINET_INSERTABLE)
                .addTag(ItemTags.SWORDS)
                .addTag(ItemTags.AXES)
                .addTag(ItemTags.HOES)
                .addTag(ItemTags.PICKAXES)
                .addTag(ItemTags.SHOVELS)
                .addTag(ItemTags.HEAD_ARMOR)
                .addTag(ItemTags.CHEST_ARMOR)
                .addTag(ItemTags.LEG_ARMOR)
                .addTag(ItemTags.FOOT_ARMOR)
                .addTag(ItemTags.BOW_ENCHANTABLE)
                .addTag(ItemTags.CROSSBOW_ENCHANTABLE)
                .addTag(ItemTags.TRIDENT_ENCHANTABLE)
                .addTag(ItemTags.MACE_ENCHANTABLE)
                .add(BuiltInRegistries.ITEM.wrapAsHolder(Items.ELYTRA).key(), BuiltInRegistries.ITEM.wrapAsHolder(Items.SHIELD).key(), BuiltInRegistries.ITEM.wrapAsHolder(Items.FISHING_ROD).key(), BuiltInRegistries.ITEM.wrapAsHolder(Items.FLINT_AND_STEEL).key(), BuiltInRegistries.ITEM.wrapAsHolder(Items.SHEARS).key(), BuiltInRegistries.ITEM.wrapAsHolder(Items.BRUSH).key(), BuiltInRegistries.ITEM.wrapAsHolder(Items.ENCHANTED_BOOK).key());
        this.tag(StorageTags.DRAWER_STORAGE_DENYLIST);
        this.tag(StorageTags.CREATIVE_VENDING_UPGRADE_INCOMPATIBLE);
    }

    @Override
    public @NonNull String getName()
    {
        return "Functional Storage Item Tags";
    }

}
