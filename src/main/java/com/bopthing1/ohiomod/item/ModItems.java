package com.bopthing1.ohiomod.item;

import com.bopthing1.ohiomod.OhioMod;
import com.bopthing1.ohiomod.item.custom.OhioCrystalItem;
import com.bopthing1.ohiomod.item.custom.OhioPickaxeItem;
import net.minecraft.ChatFormatting;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OhioMod.MOD_ID);




    public static final RegistryObject<Item> CLEVELAND_ORE = ITEMS.register("cleveland_ore", () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.OHIO_TAB)
            .durability(10000000)
            .rarity(Rarity.create("uncommon", ChatFormatting.YELLOW))



    ));

    public static final RegistryObject<Item> OHIO_PICKAXE = ITEMS.register("ohio_pickaxe", () -> new OhioPickaxeItem(new Item.Properties()
            .tab(ModCreativeModeTab.OHIO_TAB)
            .durability(10000000)
            .rarity(Rarity.create("uncommon", ChatFormatting.YELLOW))



    ));

    ublic static final RegistryObject<Item> OHIO_CRYSTAL = ITEMS.register("ohio_crystal", () -> new OhioCrystalItem(new Item.Properties()
            .tab(ModCreativeModeTab.OHIO_TAB)
            .durability(10000000)
            .rarity(Rarity.create("uncommon", ChatFormatting.YELLOW))



    ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

