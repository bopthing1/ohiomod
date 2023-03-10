package com.bopthing1.ohiomod.item.custom;

import com.bopthing1.ohiomod.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class OhioPickaxeItem extends Item {
    public OhioPickaxeItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        BlockPos positionClicked = new BlockPos(0, 0, 0);
        Block block = pContext.getLevel().getBlockState(positionClicked).getBlock();

        if (pContext.getLevel().isClientSide()) {
            positionClicked = pContext.getClickedPos();
            player.sendMessage(new TextComponent(positionClicked.toString()), player.getUUID());
            block = pContext.getLevel().getBlockState(positionClicked).getBlock();
//            pContext.getLevel().removeBlock(positionClicked, false);
            player.sendMessage(new TextComponent(block.getName().toString()), player.getUUID());
        }


       if (!pContext.getLevel().isClientSide()) {
           System.out.println(pContext.getLevel().isClientSide());
           player.setHealth(player.getHealth() - 10);

           player.addItem(new ItemStack(ModItems.CLEVELAND_ORE.get(), 1));
           pContext.getLevel().removeBlock(positionClicked, false);

           pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), (plr) -> plr.broadcastBreakEvent(plr.getUsedItemHand()));
       }

        return super.useOn(pContext);
    }

}


