package com.bopthing1.ohiomod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab OHIO_TAB = new CreativeModeTab("ohiotab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CLEVELAND_ORE.get());
        }
    };
}
